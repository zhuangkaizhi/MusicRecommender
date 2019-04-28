package recommender.download.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.AlbumTrack;
import recommender.core.entities.ArtistTrack;
import recommender.core.entities.Track;
import recommender.dao.IAlbumTrackDao;
import recommender.dao.IArtistTrackDao;
import recommender.dao.ITrackDao;
import recommender.download.pojo_json.JsonAlbum;
import recommender.download.pojo_json.JsonArtist;
import recommender.download.pojo_json.JsonTrack;
import recommender.service.IBaseService;
import test.HttpDownloadFile;

@Service
public class TrackDownloadService implements IBaseService
{
	private final static Logger log =  LogManager.getLogger(TrackDownloadService.class);

	@Autowired
	ITrackDao  trackDao;
	
	@Autowired
	IAlbumTrackDao  albumTrackDao;
	
	@Autowired
	IArtistTrackDao  artistTrackDao;
	
	
	
	@PostConstruct
	public void init()
	{
		;
	}
	
	public void saveData(JsonTrack trackJson)
	{
		if (trackJson != null)
		{
			Track entity = new Track();
			if (trackJson.getId() !=null && trackJson.getId()!=0)
			{
				entity.setTrackId(trackJson.getId());
			}else
			{
				return;
			}
			
			//
			JsonArtist artist = trackJson.getArtist();
			if (artist != null)
			{
				List<ArtistTrack> lst = new ArrayList<>();
				ArtistTrack obj = new ArtistTrack(artist.getId(), trackJson.getId());
				lst.add(obj);
				entity.setArtistTracks(lst);
			}
			
			//
			JsonAlbum album = trackJson.getAlbum();
			if (album != null)
			{
				List<AlbumTrack> lst = new ArrayList<>();
				AlbumTrack obj = new AlbumTrack(album.getId(), trackJson.getId());
				lst.add(obj);
				entity.setAlbumTracks(lst);
			}
			
			//
			entity.setDiskNumber(trackJson.getDisk_number()==null?0:trackJson.getDisk_number());
			entity.setDuration(trackJson.getDuration()==null?0:trackJson.getDuration());
			entity.setTrackPosition(trackJson.getTrack_position()==null?0: trackJson.getTrack_position());
			
			entity.setPreviewUrl(trackJson.getPreview());
			entity.setReleaseDate(trackJson.getRelease_date());
			entity.setTitle(trackJson.getTitle());
			entity.setTitleShort(trackJson.getTitleShort());
			
			
			try
			{
				trackDao.create(entity);
			}catch(Exception e)
			{
				System.out.println(">>>>>>>>>>>>>>Error:"+ e.getMessage());
			}
		}
		
	}
	
	public void saveData(List<JsonTrack> pList)
	{
		int albumId = 0;
		int artistId = 0;
		int trackId = 0;
		
		if (pList!=null && pList.size()>0)
		{
			for (JsonTrack jsonTrack : pList)
			{
				albumId  = jsonTrack.getAlbum().getId();
				artistId = jsonTrack.getArtist().getId();
				trackId  = jsonTrack.getId();
				//
				if (trackId == 0)
				{
					continue;
				}else
				{
					saveData(jsonTrack);
				}
				//
				if ( albumId == 0)
				{
					;
				}else
				{
					saveRelationAlbum(albumId, trackId);
				}
				//
				if (artistId == 0)
				{
					;
				}else
				{
					saveRelationArtist(artistId, trackId);
				}
				
			}
		}
	}
	
	
	public void saveRelationAlbum(int pAlbumId, int pTrackId)
	{
		AlbumTrack entity = new AlbumTrack(pAlbumId, pTrackId);
		try
		{
			albumTrackDao.create(entity);
		}catch(Exception e)
		{
			log.info(">>>>> Error:" + e.getMessage());
			//e.printStackTrace();
		}
		
	}
	
	
	public void saveRelationArtist(int pArtistId, int pTrackId)
	{
		ArtistTrack entity = new ArtistTrack(pArtistId, pTrackId);
		try
		{
			artistTrackDao.create(entity);
		}catch(Exception e)
		{
			log.info(">>>>> Error:" + e.getMessage());
			//e.printStackTrace();
		}
		
	}
	

	@SuppressWarnings("unused")
	private byte[] downloadFile(String link) 
	{
		String dir_name = "D:\\JasonPro\\J2EE\\RecommenderDownload\\data";
		String file_name = dir_name + "\\temp.mp3";
		try
		{
            File out = new File(file_name);
            new Thread(new HttpDownloadFile(link, out)).start();
			//saveFileFromUrlWithJavaIO(file_name, mp3url);
            //saveFileFromUrlWithCommonsIO(file_name, mp3url);
            System.out.println("finished");
	    } catch (Exception exp)
		{
	    	exp.printStackTrace();
		}
		
		return null;
	}

	public void clearTable()
	{
		trackDao.deleteAll("Track");
		//trackDao.flushEM();
	}
	
	public void truncateTable()
	{
		trackDao.truncateTable("Track");
		//trackDao.flushEM();
	}
	

}
