package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.ArtistTrack;
import recommender.dao.IArtistTrackDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * ArtistTrackDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class ArtistTrackDaoImpl extends GenericDaoImpl<ArtistTrack> implements IArtistTrackDao
{
	public ArtistTrackDaoImpl()
	{
		;
	}
}
