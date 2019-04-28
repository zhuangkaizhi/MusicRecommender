package recommender.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "track")
@NamedQuery(name = "Track.findAll", query = "SELECT t FROM Track t")
public class Track implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "track_id", unique = true, nullable = false)
	private int trackId;
	
	@Column(nullable = false, length = 255)
	private String title;

	@Column(name = "title_short", length = 100)
	private String titleShort;
	
	@Column(nullable = false)
	private int duration;
	
	@Column(name = "track_position", nullable = false)
	private int trackPosition;

	@Column(name = "disk_number", nullable = false)
	private int diskNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Column(name = "preview_url", length = 500)
	private String previewUrl;
	
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
	private List<AlbumTrack> albumTracks;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
	private List<ArtistTrack> artistTracks;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
	private List<PlayLog> playLogs;

	@OneToMany(mappedBy = "track")
	private List<UserRecommend> userRecommends;
	*/

	public Track()
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

	public int getTrackId()
	{
		return trackId;
	}

	public void setTrackId(int trackId)
	{
		this.trackId = trackId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitleShort()
	{
		return titleShort;
	}

	public void setTitleShort(String titleShort)
	{
		this.titleShort = titleShort;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public int getTrackPosition()
	{
		return trackPosition;
	}

	public void setTrackPosition(int trackPosition)
	{
		this.trackPosition = trackPosition;
	}

	public int getDiskNumber()
	{
		return diskNumber;
	}

	public void setDiskNumber(int diskNumber)
	{
		this.diskNumber = diskNumber;
	}

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public String getPreviewUrl()
	{
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl)
	{
		this.previewUrl = previewUrl;
	}

	
	
}
