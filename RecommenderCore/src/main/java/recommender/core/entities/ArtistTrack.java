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
@Table(name="artist_track")
@NamedQuery(name="ArtistTrack.findAll", query="SELECT a FROM ArtistTrack a")
public class ArtistTrack implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="artist_id", nullable=false)
	private int artistId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;

	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_id", nullable=false)
	private Artist artist;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="track_id", nullable=false)
	private Track track;
	*/
	
	public ArtistTrack() 
	{
		;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
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
