package recommender.dao;

import java.util.List;
import java.util.Map;

import recommender.core.entities.Album;
import recommender.core.entities.AlbumTrack;
import recommender.core.entities.Track;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IAlbumTrackDao.java
 * Describe:
 */
public interface IAlbumTrackDao	extends IGenericDao<AlbumTrack>
{
	public Map<Album,Track> getFirstMapByAlbumId(int p_albumId);
	
	public List<AlbumTrack> getAlbumTrackByAlbumId(int p_albumId);
	
	public Map<Track,Album> getFirstMapByTrackId(int p_trackId);
	
	public List<AlbumTrack> getAlbumTrackByTrackId(int p_trackId);
}
