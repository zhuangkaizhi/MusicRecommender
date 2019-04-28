package recommender.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import recommender.core.entities.AlbumArtist;
import recommender.dao.IAlbumArtistDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * AlbumArtistDaoImpl.java
 * Describe:
 */
@Repository
public class AlbumArtistDaoImpl extends GenericDaoImpl<AlbumArtist> implements IAlbumArtistDao
{

	public AlbumArtistDaoImpl()
	{
		;
	}

	@Override
	public List<AlbumArtist> getAlbumArtistByAlbumId(int p_albumId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumArtist> getAlbumArtistByArtistId(int p_artistId)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
