package recommender.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.Album;
import recommender.dao.IAlbumDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumDaoImpl.java
 * Describe:
 */
@Repository
public class AlbumDaoImpl extends GenericDaoImpl<Album>	implements IAlbumDao
{

	public AlbumDaoImpl()
	{
		;
	}

	@Override
	public Album getAlbumByAlbumId(int p_AlbumId)
	{
		Album retValue = new Album();
		String jql = "SELECT c FROM Album c WHERE c.albumId = :albumId";
		TypedQuery<Album> query = em.createQuery(jql, Album.class);
		query.setParameter("albumId", p_AlbumId);
		retValue = query.getSingleResult();
		return retValue;
	}
}
