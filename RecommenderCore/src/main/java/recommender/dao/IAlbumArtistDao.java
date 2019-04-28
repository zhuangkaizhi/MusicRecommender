package recommender.dao;

import java.util.List;

import recommender.core.entities.AlbumArtist;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IAlbumArtistDao.java
 * Describe:
 */
public interface IAlbumArtistDao extends IGenericDao<AlbumArtist>
{
	public List<AlbumArtist> getAlbumArtistByAlbumId(int p_albumId);
	
	public List<AlbumArtist> getAlbumArtistByArtistId(int p_artistId);
}
