package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.AlbumTrack;
import recommender.dao.IAlbumTrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumTrackDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class AlbumTrackDaoImpl extends GenericDaoImpl<AlbumTrack> implements IAlbumTrackDao
{

	public AlbumTrackDaoImpl()
	{
		;
	}
}
