package recommender.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.Track;
import recommender.dao.ITrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * TrackDaoImpl.java
 * Describe:
 */
@Repository
public class TrackDaoImpl extends GenericDaoImpl<Track> implements ITrackDao
{

	public TrackDaoImpl()
	{
		;
	}

	@Override
	public Track getTrackByTrackId(int p_trackId)
	{
		Track retValue = new Track();
		String jql = "SELECT c FROM Track c WHERE c.trackId = :trackId";
		TypedQuery<Track> query = em.createQuery(jql, Track.class);
		query.setParameter("trackId", p_trackId);
		retValue = query.getSingleResult();
		return retValue;
	}
}
