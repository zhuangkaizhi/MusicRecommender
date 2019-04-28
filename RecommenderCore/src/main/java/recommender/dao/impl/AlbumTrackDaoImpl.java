package recommender.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.AlbumTrack;
import recommender.dao.IAlbumTrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumTrackDaoImpl.java
 * Describe:
 */
@Repository
public class AlbumTrackDaoImpl extends GenericDaoImpl<AlbumTrack> implements IAlbumTrackDao
{

	public AlbumTrackDaoImpl()
	{
		;
	}

	@Override
	public List<AlbumTrack> getAlbumTrackByAlbumId(int p_albumId)
	{
		List<AlbumTrack> retList = new ArrayList<AlbumTrack>();
		String jql = "SELECT c FROM AlbumTrack c WHERE c.albumId = :albumId";
		TypedQuery<AlbumTrack> query = em.createQuery(jql, AlbumTrack.class);
		
		query.setParameter("albumId", p_albumId);
		retList = query.getResultList();
		return retList;
	}

	@Override
	public List<AlbumTrack> getAlbumTrackByTrackId(int p_trackId)
	{
		List<AlbumTrack> retList = new ArrayList<AlbumTrack>();
		String jql = "SELECT c FROM AlbumTrack c WHERE c.trackId = :trackId";
		TypedQuery<AlbumTrack> query = em.createQuery(jql, AlbumTrack.class);
		
		query.setParameter("trackId", p_trackId);
		retList = query.getResultList();
		return retList;
		
	}
}
