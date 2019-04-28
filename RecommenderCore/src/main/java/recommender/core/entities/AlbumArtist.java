package recommender.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String id;

	@Column(name="album_id", nullable=false)
	private int albumId;
	
	@Column(name="artist_id", nullable=false)
	private int artistId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;

	public AlbumArtist()
	{
	}

	public AlbumArtist(int p_albumId, int p_artistId)
	{
		this.albumId = p_albumId;
		this.artistId = p_artistId;
	}
	
	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Album getAlbum()
	{
		return this.album;
	}

	public void setAlbum(Album album)
	{
		this.album = album;
	}

	public Artist getArtist()
	{
		return this.artist;
	}

	public void setArtist(Artist artist)
	{
		this.artist = artist;
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
