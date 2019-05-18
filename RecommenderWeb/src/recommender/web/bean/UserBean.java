package recommender.web.bean;

public class UserBean
{

	public UserBean()
	{
		;
	}
	
	private int    userId;
	private String userName;
	private String userEmail;
	private String userGender;
	private String userBirthDay;
	private String userBirthMonth;
	private String userBirthYear;
	private String firstPassword;
	private String secondPassword;
	private String createTime;
	
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public String getUserGender()
	{
		return userGender;
	}
	public void setUserGender(String userGender)
	{
		this.userGender = userGender;
	}
	public String getUserBirthDay()
	{
		return userBirthDay;
	}
	public void setUserBirthDay(String userBirthDay)
	{
		this.userBirthDay = userBirthDay;
	}
	public String getUserBirthMonth()
	{
		return userBirthMonth;
	}
	public void setUserBirthMonth(String userBirthMonth)
	{
		this.userBirthMonth = userBirthMonth;
	}
	public String getUserBirthYear()
	{
		return userBirthYear;
	}
	public void setUserBirthYear(String userBirthYear)
	{
		this.userBirthYear = userBirthYear;
	}
	public String getFirstPassword()
	{
		return firstPassword;
	}
	public void setFirstPassword(String firstPassword)
	{
		this.firstPassword = firstPassword;
	}
	public String getSecondPassword()
	{
		return secondPassword;
	}
	public void setSecondPassword(String secondPassword)
	{
		this.secondPassword = secondPassword;
	}
	
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	
}
