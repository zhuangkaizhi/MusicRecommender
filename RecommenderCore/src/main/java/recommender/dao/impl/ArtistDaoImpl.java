package recommender.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.core.entities.Artist;
import recommender.dao.IArtistDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * ArtistDaoImpl.java
 * Describe:
 */
@Transactional
@Repository
public class ArtistDaoImpl extends GenericDaoImpl<Artist> implements IArtistDao
{

	public ArtistDaoImpl()
	{
		;
	}
}
