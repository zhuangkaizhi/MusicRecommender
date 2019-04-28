
package recommender.core.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private int userId;

	@Column(nullable=false, length=255)
	private String email;
	
	@Column(nullable=false, length=20)
	private String username;
	
	@Column(nullable=false, length=30)
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gender", nullable=false)
	private CodeGender codeGender;
	
	@Column(name="create_time", nullable=false)
	private Timestamp createTime;

	@OneToMany(mappedBy="userInfo")
	private List<PlayLog> playLogs;

	@OneToMany(mappedBy="userInfo")
	private List<UserRecommend> userRecommends;

	public UserInfo() 
	{
		;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public CodeGender getCodeGender()
	{
		return codeGender;
	}

	public void setCodeGender(CodeGender codeGender)
	{
		this.codeGender = codeGender;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public List<PlayLog> getPlayLogs()
	{
		return playLogs;
	}

	public void setPlayLogs(List<PlayLog> playLogs)
	{
		this.playLogs = playLogs;
	}

	public List<UserRecommend> getUserRecommends()
	{
		return userRecommends;
	}

	public void setUserRecommends(List<UserRecommend> userRecommends)
	{
		this.userRecommends = userRecommends;
	}
	
	
	
}