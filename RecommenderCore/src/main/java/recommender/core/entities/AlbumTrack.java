
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
@Table(name="album_track")
@NamedQuery(name="AlbumTrack.findAll", query="SELECT a FROM AlbumTrack a")
public class AlbumTrack implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="album_id", nullable=false)
	private int albumId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="album_id", nullable=false)
	private Album album;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="track_id", nullable=false)
	private Track track;

	public AlbumTrack() 
	{
	}
	
	public AlbumTrack(int p_albumId, int p_trackId) 
	{
		this.albumId = p_albumId;
		this.trackId = p_trackId;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public int getTrackId()
	{
		return trackId;
	}

	public void setTrackId(int trackId)
	{
		this.trackId = trackId;
	}

	public Album getAlbum()
	{
		return album;
	}

	public void setAlbum(Album album)
	{
		this.album = album;
	}

	public Track getTrack()
	{
		return track;
	}

	public void setTrack(Track track)
	{
		this.track = track;
	}
	
	
}
