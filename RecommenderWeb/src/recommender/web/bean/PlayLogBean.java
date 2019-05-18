package recommender.web.bean;

import java.util.Date;

public class PlayLogBean
{
	private String id;

	private String albumId;
	
	private String trackId;

	private String userId;
	
	private Date playTime;
	
	private String ipAddress;
	
	private String browser;
	
	private Date startPlayTime;

	private Date endPlayTime;

	private int playDuration;
	
	public PlayLogBean()
	{
		// TODO Auto-generated constructor stub
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(String albumId)
	{
		this.albumId = albumId;
	}

	public String getTrackId()
	{
		return trackId;
	}

	public void setTrackId(String trackId)
	{
		this.trackId = trackId;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
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
