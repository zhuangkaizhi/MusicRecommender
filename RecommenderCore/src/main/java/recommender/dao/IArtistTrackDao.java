package recommender.dao;

import java.util.List;

import recommender.core.entities.ArtistTrack;

/**
 * @author Jason.Zhuang Apr 28, 2019 IArtistTrackDao.java Describe:
 */
public interface IArtistTrackDao extends IGenericDao<ArtistTrack>
{
	public List<ArtistTrack> getArtistTrackByArtistId(int p_artistId);

	public List<ArtistTrack> getArtistTrackByTrackId(int p_trackId);
}
