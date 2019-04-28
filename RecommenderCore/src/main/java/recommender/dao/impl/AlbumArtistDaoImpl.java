package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.AlbumArtist;
import recommender.dao.IAlbumArtistDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumArtistDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class AlbumArtistDaoImpl extends GenericDaoImpl<AlbumArtist> implements IAlbumArtistDao
{

	public AlbumArtistDaoImpl()
	{
		;
	}
}
