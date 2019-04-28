package recommender.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import recommender.core.entities.ArtistTrack;
import recommender.dao.IArtistTrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * ArtistTrackDaoImpl.java
 * Describe:
 */
@Repository
public class ArtistTrackDaoImpl extends GenericDaoImpl<ArtistTrack> implements IArtistTrackDao
{
	public ArtistTrackDaoImpl()
	{
		;
	}

	@Override
	public List<ArtistTrack> getArtistTrackByArtistId(int p_artistId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtistTrack> getArtistTrackByTrackId(int p_trackId)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
