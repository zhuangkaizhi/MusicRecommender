package recommender.download.pojo_json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonTrack implements Serializable
{
	private final static long serialVersionUID = -1L;
	
	@SerializedName("id")
	@Expose
	private Integer id;

	@SerializedName("readable")
	@Expose
	private Boolean readable;

	@SerializedName("title")
	@Expose
	private String title;

	@SerializedName("title_short")
	@Expose
	private String titleShort;

	@SerializedName("title_version")
	@Expose
	private String titleVersion;

	@SerializedName("isrc")
	@Expose
	private String isrc;
	
	@SerializedName("link")
	@Expose
	private String link;
	
	@SerializedName("share")
	@Expose
	private String share;

	@SerializedName("duration")
	@Expose
	private Integer duration;

	@SerializedName("track_position")
	@Expose
	private Integer track_position;
	
	@SerializedName("disk_number")
	@Expose
	private Integer disk_number;
	
	@SerializedName("rank")
	@Expose
	private Integer rank;
	
	@SerializedName("release_date")
	@Expose
	private Date release_date;

	@SerializedName("explicit_lyrics")
	@Expose
	private Boolean explicitLyrics;

	@SerializedName("explicit_content_lyrics")
	@Expose
	private Integer explicitContentLyrics;

	@SerializedName("explicit_content_cover")
	@Expose
	private Integer explicitContentCover;

	@SerializedName("preview")
	@Expose
	private String preview;

	@SerializedName("bpm")
	@Expose
	private Float bpm;
	
	@SerializedName("gain")
	@Expose
	private String gain;
	
	@SerializedName("available_countries")
	@Expose
	private String[] available_countries;
	
	@SerializedName("contributors")
	@Expose
	private ArrayList<JsonContributor> contributors;
	
	@SerializedName("artist")
	@Expose
	private JsonArtist artist;
	
	@SerializedName("album")
	@Expose
	private JsonAlbum album;

	@SerializedName("type")
	@Expose
	private String type;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Boolean getReadable()
	{
		return readable;
	}

	public void setReadable(Boolean readable)
	{
		this.readable = readable;
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

	public String getTitleVersion()
	{
		return titleVersion;
	}

	public void setTitleVersion(String titleVersion)
	{
		this.titleVersion = titleVersion;
	}

	public String getIsrc()
	{
		return isrc;
	}

	public void setIsrc(String isrc)
	{
		this.isrc = isrc;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getShare()
	{
		return share;
	}

	public void setShare(String share)
	{
		this.share = share;
	}

	public Integer getDuration()
	{
		return duration;
	}

	public void setDuration(Integer duration)
	{
		if (duration==null)
		{
			duration = 0;
		}
		this.duration = duration;
	}

	public Integer getTrack_position()
	{
		return track_position;
	}

	public void setTrack_position(Integer track_position)
	{
		if (track_position==null)
		{
			track_position = 0;
		}
		this.track_position = track_position;
	}

	public Integer getDisk_number()
	{
		return disk_number;
	}

	public void setDisk_number(Integer disk_number)
	{
		if (disk_number==null)
		{
			disk_number = 0;
		}
		this.disk_number = disk_number;
	}

	public Integer getRank()
	{
		return rank;
	}

	public void setRank(Integer rank)
	{
		this.rank = rank;
	}

	public Date getRelease_date()
	{
		return release_date;
	}

	public void setRelease_date(Date release_date)
	{
		this.release_date = release_date;
	}

	public Boolean getExplicitLyrics()
	{
		return explicitLyrics;
	}

	public void setExplicitLyrics(Boolean explicitLyrics)
	{
		this.explicitLyrics = explicitLyrics;
	}

	public Integer getExplicitContentLyrics()
	{
		return explicitContentLyrics;
	}

	public void setExplicitContentLyrics(Integer explicitContentLyrics)
	{
		this.explicitContentLyrics = explicitContentLyrics;
	}

	public Integer getExplicitContentCover()
	{
		return explicitContentCover;
	}

	public void setExplicitContentCover(Integer explicitContentCover)
	{
		this.explicitContentCover = explicitContentCover;
	}

	public String getPreview()
	{
		return preview;
	}

	public void setPreview(String preview)
	{
		this.preview = preview;
	}

	public Float getBpm()
	{
		return bpm;
	}

	public void setBpm(Float bpm)
	{
		this.bpm = bpm;
	}

	public String getGain()
	{
		return gain;
	}

	public void setGain(String gain)
	{
		this.gain = gain;
	}

	public String[] getAvailable_countries()
	{
		return available_countries;
	}

	public void setAvailable_countries(String[] available_countries)
	{
		this.available_countries = available_countries;
	}

	public ArrayList<JsonContributor> getContributors()
	{
		return contributors;
	}

	public void setContributors(ArrayList<JsonContributor> contributors)
	{
		this.contributors = contributors;
	}

	public JsonArtist getArtist()
	{
		return artist;
	}

	public void setArtist(JsonArtist artist)
	{
		this.artist = artist;
	}

	public JsonAlbum getAlbum()
	{
		return album;
	}

	public void setAlbum(JsonAlbum album)
	{
		this.album = album;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

}