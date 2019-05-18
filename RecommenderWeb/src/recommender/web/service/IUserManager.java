package recommender.web.service;

import recommender.web.bean.UserBean;

public interface IUserManager
{
	public int createUser(UserBean pBean);
	
	public UserBean getUserById(int pId);
	
	public UserBean getUserByEmail(String pEmail);
	
	public void updateUser(UserBean pBean);
	
	public void deleteUserByid(int pId);
	
	public void deleteUserByEmail(String pEmail);
}
