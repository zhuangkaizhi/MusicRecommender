package recommender.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the user_recommend database table.
 */
@Entity
@Table(name = "user_recommend")
@NamedQuery(name = "UserRecommend.findAll", query = "SELECT u FROM UserRecommend u")
public class UserRecommend implements Serializable
{

	private static final long serialVersionUID = -3064064483214830195L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserInfo userInfo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", nullable = false)
	private Track track;
	
	
	@Column(name = "recommend_time", nullable = false)
	private Timestamp recommendTime;

	@Column(name = "recommend_system", length = 255)
	private String recommendSystem;
	
	@Column(length = 500)
	private String reasons;


	public UserRecommend()
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

	public UserInfo getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}


	public Track getTrack()
	{
		return track;
	}


	public void setTrack(Track track)
	{
		this.track = track;
	}


	public Timestamp getRecommendTime()
	{
		return recommendTime;
	}


	public void setRecommendTime(Timestamp recommendTime)
	{
		this.recommendTime = recommendTime;
	}


	public String getRecommendSystem()
	{
		return recommendSystem;
	}


	public void setRecommendSystem(String recommendSystem)
	{
		this.recommendSystem = recommendSystem;
	}


	public String getReasons()
	{
		return reasons;
	}


	public void setReasons(String reasons)
	{
		this.reasons = reasons;
	}
	

}