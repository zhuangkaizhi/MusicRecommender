package recommender.dao;

import recommender.core.entities.Artist;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IArtistDao.java
 * Describe:
 */
public interface IArtistDao extends IGenericDao<Artist>
{
	public Artist getArtistByArtistId(int p_ArtistId);
	
}
