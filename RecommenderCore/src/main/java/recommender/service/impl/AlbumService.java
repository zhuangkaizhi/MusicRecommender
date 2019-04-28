package recommender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.Album;
import recommender.dao.IAlbumDao;
import recommender.service.IBaseService;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumService.java
 * Describe:
 */
@Service
public class AlbumService implements IBaseService
{
	@Autowired
	private IAlbumDao albumDao;

	public AlbumService()
	{
		;
	}

	public void init()
	{
		;
	}

	public void saveData(Album entity)
	{
		albumDao.create(entity);
	}

	public void clearTable()
	{
		albumDao.deleteAll("Album");
	}
}
