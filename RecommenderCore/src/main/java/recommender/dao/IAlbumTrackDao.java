package recommender.dao;

import java.util.List;

import recommender.core.entities.AlbumTrack;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IAlbumTrackDao.java
 * Describe:
 */
public interface IAlbumTrackDao	extends IGenericDao<AlbumTrack>
{
	public List<AlbumTrack> getAlbumTrackByAlbumId(int p_albumId);
	
	public List<AlbumTrack> getAlbumTrackByTrackId(int p_trackId);
}
