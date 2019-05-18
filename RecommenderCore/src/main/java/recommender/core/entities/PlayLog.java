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
@Table(name = "play_log")
@NamedQuery(name = "PlayLog.findAll", query = "SELECT p FROM PlayLog p")
public class PlayLog implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "track_id", nullable = false)
	private Integer track_id;

	@Column(name = "user_id", nullable = false)
	private Integer user_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "play_time", nullable = false)
	private Date playTime;
	
	@Column(name = "ip_address", length = 100)
	private String ipAddress;
	
	@Column(length = 100)
	private String browser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_play_time")
	private Date startPlayTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_play_time")
	private Date endPlayTime;

	@Column(name = "play_duration")
	private int playDuration;

	public PlayLog()
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

	public Integer getTrack_id()
	{
		return track_id;
	}

	public void setTrack_id(Integer track_id)
	{
		this.track_id = track_id;
	}

	public Integer getUser_id()
	{
		return user_id;
	}

	public void setUser_id(Integer user_id)
	{
		this.user_id = user_id;
	}

	public Date getPlayTime()
	{
		return playTime;
	}

	public void setPlayTime(Date playTime)
	{
		this.playTime = playTime;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	public String getBrowser()
	{
		return browser;
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
	}

	public Date getStartPlayTime()
	{
		return startPlayTime;
	}

	public void setStartPlayTime(Date startPlayTime)
	{
		this.startPlayTime = startPlayTime;
	}

	public Date getEndPlayTime()
	{
		return endPlayTime;
	}

	public void setEndPlayTime(Date endPlayTime)
	{
		this.endPlayTime = endPlayTime;
	}

	public int getPlayDuration()
	{
		return playDuration;
	}

	public void setPlayDuration(int playDuration)
	{
		this.playDuration = playDuration;
	}

}
