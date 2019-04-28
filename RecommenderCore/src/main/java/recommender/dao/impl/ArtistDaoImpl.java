package recommender.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.Artist;
import recommender.dao.IArtistDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * ArtistDaoImpl.java
 * Describe:
 */
@Repository
public class ArtistDaoImpl extends GenericDaoImpl<Artist> implements IArtistDao
{

	public ArtistDaoImpl()
	{
		;
	}
	
	@Override
	public Artist getArtistByArtistId(int p_ArtistId)
	{
		Artist retValue = new Artist();
		String jql = "SELECT c FROM Artist c WHERE c.artistId = :artistId";
		TypedQuery<Artist> query = em.createQuery(jql, Artist.class);
		query.setParameter("artistId", p_ArtistId);
		retValue = query.getSingleResult();
		return retValue;
	}
}
