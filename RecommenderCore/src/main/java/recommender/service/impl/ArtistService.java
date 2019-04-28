package recommender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.Album;
import recommender.core.entities.AlbumArtist;
import recommender.core.entities.Artist;
import recommender.dao.IAlbumArtistDao;
import recommender.dao.IArtistDao;
import recommender.service.IBaseService;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * ArtistService.java
 * Describe:
 */
@Service
public class ArtistService implements IBaseService
{
	@Autowired
	private IArtistDao artistDao;
	
	@Autowired
	private IAlbumArtistDao albumArtistDao;

	public ArtistService()
	{
		;
	}

	public void init()
	{
		;
	}

	public void saveData(Artist entity)
	{
		try
		{
			artistDao.create(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveRelationAlbum(Album pAlbum, Artist pArtist)
	{
		AlbumArtist entity = new AlbumArtist();
		entity.setAlbumId(pAlbum.getAlbumId()); 
		entity.setArtistId(pArtist.getArtistId());
		try
		{
			albumArtistDao.create(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void clearTable()
	{
		artistDao.deleteAll("Artist");
	}
}
