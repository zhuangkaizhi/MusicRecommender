package recommender.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "album_artist")
@NamedQuery(name = "AlbumArtist.findAll", query = "SELECT a FROM AlbumArtist a")
public class AlbumArtist implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name="album_id", nullable=false)
	private int albumId;
	
	@Column(name="artist_id", nullable=false)
	private int artistId;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;
	*/
	
	public AlbumArtist()
	{
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public int getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(int albumId)
	{
		this.albumId = albumId;
	}

	public int getArtistId()
	{
		return artistId;
	}

	public void setArtistId(int artistId)
	{
		this.artistId = artistId;
	}
	

}
