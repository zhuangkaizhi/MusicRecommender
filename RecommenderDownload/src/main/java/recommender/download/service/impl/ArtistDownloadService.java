package recommender.download.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.AlbumArtist;
import recommender.core.entities.Artist;
import recommender.dao.IAlbumArtistDao;
import recommender.dao.IArtistDao;
import recommender.download.pojo_json.JsonArtist;
import recommender.service.IBaseService;

@Service
public class ArtistDownloadService implements IBaseService
{

	@Autowired
	IArtistDao  artistDao;
	
	@Autowired
	IAlbumArtistDao  albumArtistDao;
	
	@PostConstruct
	public void init()
	{
		;
	}
	
	public void saveData(JsonArtist jsonObject)
	{
		if (jsonObject == null)
		{
			return;
		}
		//
		Artist entity = new Artist();
		if (jsonObject.getId() !=null && jsonObject.getId()!=0)
		{
			entity.setArtistId(jsonObject.getId());
		}else
		{
			return;
		}
		entity.setName(jsonObject.getName());
		//
		entity.setPictureBig(jsonObject.getPictureBig());
		entity.setPictureMedium(jsonObject.getPictureMedium());
		entity.setPictureSmall(jsonObject.getPictureSmall());
		entity.setPictureXl(jsonObject.getPictureXl());
		//
		entity.setType(jsonObject.getType());
		//
		try
		{
			artistDao.create(entity);
		}catch(Exception e)
		{
			System.out.println(">>>>>>>>>>>>>>Error:"+ e.getMessage());
		}
	}

	
	public void saveRelationAlbum(int pAlbumId, int pArtistId)
	{
		AlbumArtist entity = new AlbumArtist(pAlbumId,pArtistId);
		try
		{
			albumArtistDao.create(entity);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void clearTable()
	{
		artistDao.deleteAll("Artist");
	}
	
	public void truncateTable()
	{
		artistDao.truncateTable("Artist");
	}
	

}
