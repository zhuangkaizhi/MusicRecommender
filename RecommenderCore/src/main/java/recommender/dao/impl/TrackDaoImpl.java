package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.Track;
import recommender.dao.ITrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * TrackDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class TrackDaoImpl extends GenericDaoImpl<Track> implements ITrackDao
{

	public TrackDaoImpl()
	{
		;
	}
}
