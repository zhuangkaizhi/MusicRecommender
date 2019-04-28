package recommender.download.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.utilities.DateUtilZ;
import recommender.core.entities.Album;
import recommender.core.entities.AlbumArtist;
import recommender.core.entities.Artist;
import recommender.dao.IAlbumDao;
import recommender.download.pojo_json.JsonAlbum;
import recommender.download.pojo_json.JsonArtist;
import recommender.service.IBaseService;

@Service
public class AlbumDownloadService implements IBaseService
{

	@Autowired
	IAlbumDao  albumDao;
	
	@PostConstruct
	public void init()
	{
		;
	}
	
	public void saveData(JsonAlbum jsonObject)
	{
		if (jsonObject != null)
		{
			Album entity = new Album();
			if (jsonObject.getId() !=null && jsonObject.getId()!=0)
			{
				entity.setAlbumId(jsonObject.getId());
			}else
			{
				return;
			}
			
			entity.setAvailable(jsonObject.getAvailable());
			//
			entity.setImageBig(jsonObject.getCoverBig());
			entity.setImageMedium(jsonObject.getCoverMedium());
			entity.setImageSmall(jsonObject.getCoverSmall());
			entity.setImageXl(jsonObject.getCoverXl());
			//
			entity.setDuration(jsonObject.getDuration());
			//
			entity.setFans(jsonObject.getFans());
			//entity.setGenreId(jsonObject.getGenre_id());
			entity.setLabel(jsonObject.getLabel());
			entity.setNbTracks(jsonObject.getNb_tracks());
			entity.setRating(jsonObject.getRating());
			//
			String release_date = jsonObject.getReleaseDate();
			Date d = new Date();
			try
			{
				if (release_date == null || release_date.equals(""))
				{
					
				}else
				{
					d = DateUtilZ.convertStringToDate(release_date);
					entity.setReleaseDate(new java.sql.Date(d.getTime()) );
				}
			}catch (ParseException e)
			{
				e.printStackTrace();
			}
			//
			entity.setTitle(jsonObject.getTitle());
			entity.setType(jsonObject.getType());
			entity.setUpc(jsonObject.getUpc());
			//
			JsonArtist artist =  jsonObject.getArtist();
			if (artist !=null && artist.getId() != 0)
			{
				List<AlbumArtist> lst = new ArrayList<AlbumArtist>();
				//AlbumArtist obj = new AlbumArtist(jsonObject.getId(),artist.getId());
				AlbumArtist obj = new AlbumArtist();
				Album album = new Album();
				album.setAlbumId(jsonObject.getId());
				obj.setAlbum(album);
				
				Artist artistEntity = new Artist();
				artistEntity.setArtistId(artist.getId());
				obj.setArtist(artistEntity);
				
				lst.add(obj);
				
				entity.setAlbumArtists(lst);
			}
			
			try
			{
				albumDao.create(entity);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void clearTable()
	{
		albumDao.deleteAll("Album");
	}
	
	public void truncateTable()
	{
		albumDao.truncateTable("Album");
	}

}
