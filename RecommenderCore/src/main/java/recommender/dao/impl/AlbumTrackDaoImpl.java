package recommender.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recommender.core.entities.Album;
import recommender.core.entities.AlbumTrack;
import recommender.core.entities.Track;
import recommender.dao.IAlbumDao;
import recommender.dao.IAlbumTrackDao;
import recommender.dao.ITrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumTrackDaoImpl.java
 * Describe:
 */
@Repository
public class AlbumTrackDaoImpl extends GenericDaoImpl<AlbumTrack> implements IAlbumTrackDao
{
	@Autowired
	private IAlbumDao albumDao;
	
	@Autowired
	private ITrackDao trackDao;
	
	public AlbumTrackDaoImpl()
	{
		;
	}

	@Override
	public Map<Album, Track> getFirstMapByAlbumId(int p_albumId)
	{
		Map<Album, Track> retMap = new HashMap<Album, Track>();
		String jql = "SELECT c FROM AlbumTrack c WHERE c.albumId = :albumId ORDER BY c.id DESC";
		TypedQuery<AlbumTrack> query = em.createQuery(jql, AlbumTrack.class);
		query.setParameter("albumId", p_albumId);
		query.setMaxResults(1);
		AlbumTrack temp = query.getSingleResult();
		if (temp!=null)
		{
			Album tempAlbum = albumDao.getAlbumByAlbumId(temp.getAlbumId());
			Track tempTrack = trackDao.getTrackByTrackId(temp.getTrackId());
			retMap.put(tempAlbum, tempTrack);
		}
		return retMap;
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
	public Map<Track,Album> getFirstMapByTrackId(int p_trackId)
	{
		Map<Track,Album> retMap = new HashMap<>();
		String jql = "SELECT c FROM AlbumTrack c WHERE c.trackId = :trackId ORDER BY c.id DESC";
		TypedQuery<AlbumTrack> query = em.createQuery(jql, AlbumTrack.class);
		query.setParameter("trackId", p_trackId);
		query.setMaxResults(1);
		AlbumTrack temp = query.getSingleResult();
		if (temp!=null)
		{
			Album tempAlbum = albumDao.getAlbumByAlbumId(temp.getAlbumId());
			Track tempTrack = trackDao.getTrackByTrackId(temp.getTrackId());
			retMap.put(tempTrack,tempAlbum);
		}
		return retMap;
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
