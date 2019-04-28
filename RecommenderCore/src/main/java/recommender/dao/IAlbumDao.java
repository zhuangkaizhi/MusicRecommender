package recommender.dao;

import recommender.core.entities.Album;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IAlbumDao.java
 * Describe:
 */
public interface IAlbumDao extends IGenericDao<Album>
{
	public Album getAlbumByAlbumId(int p_AlbumId);
}
