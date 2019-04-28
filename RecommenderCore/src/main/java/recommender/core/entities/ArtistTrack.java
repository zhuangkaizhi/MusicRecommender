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
@Table(name="artist_track")
@NamedQuery(name="ArtistTrack.findAll", query="SELECT a FROM ArtistTrack a")
public class ArtistTrack implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="artist_id", nullable=false)
	private int artistId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_id", nullable=false)
	private Artist artist;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="track_id", nullable=false)
	private Track track;

	public ArtistTrack() 
	{
		;
	}
	
	public ArtistTrack(int p_artistId, int p_trackId) 
	{
		this.artistId = p_artistId;
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

	public Artist getArtist()
	{
		return artist;
	}

	public void setArtist(Artist artist)
	{
		this.artist = artist;
	}

	public Track getTrack()
	{
		return track;
	}

	public void setTrack(Track track)
	{
		this.track = track;
	}

	public int getArtistId()
	{
		return artistId;
	}

	public void setArtistId(int artistId)
	{
		this.artistId = artistId;
	}

	public int getTrackId()
	{
		return trackId;
	}

	public void setTrackId(int trackId)
	{
		this.trackId = trackId;
	}
	
	
	
}
