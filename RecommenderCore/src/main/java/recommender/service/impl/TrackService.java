package recommender.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.Album;
import recommender.core.entities.AlbumTrack;
import recommender.core.entities.Artist;
import recommender.core.entities.ArtistTrack;
import recommender.core.entities.Track;
import recommender.dao.IAlbumTrackDao;
import recommender.dao.IArtistTrackDao;
import recommender.dao.ITrackDao;
import recommender.service.IBaseService;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * TrackService.java
 * Describe:
 */
@Service
public class TrackService implements IBaseService
{

	private static final Logger log = LogManager.getLogger(TrackService.class);

	@Autowired
	private ITrackDao trackDao;

	@Autowired
	private IAlbumTrackDao albumTrackDao;

	@Autowired
	private IArtistTrackDao artistTrackDao;

	public TrackService()
	{
		;
	}

	public void init()
	{
	}

	public void saveData(Track entity)
	{
		try
		{
			trackDao.create(entity);
		} catch (Exception e)
		{
			System.out.println(
					(new StringBuilder()).append(">>>>>>>>>>>>>>Error:")
							.append(e.getMessage()).toString());
		}
	}

	public void saveData(List<Track> pList)
	{
		if (pList != null && pList.size() > 0)
		{
			for (Track enity : pList)
			{
				saveData(enity);
			}

		}
	}

	public void saveRelationAlbum(Album pAlbum, Track pTrack)
	{
		AlbumTrack entity = new AlbumTrack();
		entity.setAlbumId(pAlbum.getAlbumId());
		entity.setTrackId(pTrack.getTrackId());
		try
		{
			albumTrackDao.create(entity);
		} catch (Exception e)
		{
			log.info((new StringBuilder()).append(">>>>> Error:")
					.append(e.getMessage()).toString());
		}
	}

	public void saveRelationArtist(Artist pArtist, Track pTrack)
	{
		ArtistTrack entity = new ArtistTrack();
		entity.setArtistId(pArtist.getArtistId());
		entity.setTrackId(pTrack.getTrackId());
		try
		{
			artistTrackDao.create(entity);
		} catch (Exception e)
		{
			log.info((new StringBuilder()).append(">>>>> Error:")
					.append(e.getMessage()).toString());
		}
	}

	public void clearTable()
	{
		trackDao.deleteAll("Track");
	}

}
