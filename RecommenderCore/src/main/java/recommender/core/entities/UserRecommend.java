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

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name="fk_recommend_user") )
	//private UserInfo userInfo;
	@Column(name="user_id", nullable=false)
	private int userId;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "track_id", nullable = false, foreignKey = @ForeignKey(name="fk_recommend_track") )
	//private Track track;
	@Column(name = "track_id", nullable = false)
	private int trackId;
	
	@Column(name = "recommend_time", nullable = false)
	private Date recommendTime;

	@Column(name = "recommend_system", length = 255)
	private String recommendSystem;
	
	@Column(name = "recommend_reasons", length = 500)
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

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getTrackId()
	{
		return trackId;
	}

	public void setTrackId(int trackId)
	{
		this.trackId = trackId;
	}

	public Date getRecommendTime()
	{
		return recommendTime;
	}

	public void setRecommendTime(Date recommendTime)
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