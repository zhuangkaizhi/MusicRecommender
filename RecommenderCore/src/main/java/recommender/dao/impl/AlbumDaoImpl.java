package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.Album;
import recommender.dao.IAlbumDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class AlbumDaoImpl extends GenericDaoImpl<Album>	implements IAlbumDao
{

	public AlbumDaoImpl()
	{
		;
	}
}
