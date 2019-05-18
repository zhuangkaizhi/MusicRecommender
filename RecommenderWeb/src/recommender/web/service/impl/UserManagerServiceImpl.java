package recommender.web.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.utilities.DateUtilZ;
import recommender.core.entities.UserInfo;
import recommender.dao.IUserDao;
import recommender.web.bean.UserBean;
import recommender.web.service.IUserManager;

@Service
public class UserManagerServiceImpl implements IUserManager
{
	@Autowired
	private IUserDao	userDao;
	

	public UserManagerServiceImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createUser(UserBean pBean)
	{
		UserInfo obj;
		obj = userDao.getUserByEmail(pBean.getUserEmail());
		
		if (obj != null)
		{
			return -1;
		}else
		{
			obj = new UserInfo();
		}
		
		obj.setUsername(pBean.getUserName());
		obj.setPassword(pBean.getSecondPassword());
		obj.setEmail(pBean.getUserEmail());
		//
		Calendar cal1 = Calendar.getInstance();
		obj.setCreateTime(cal1.getTime());
		//
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, Integer.valueOf(pBean.getUserBirthYear()));
		cal2.set(Calendar.MONTH, Integer.valueOf(pBean.getUserBirthMonth()) - 1 );
		cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(pBean.getUserBirthDay()));
		obj.setDateOfBirth(cal2.getTime());
		//
		obj.setGender(Integer.valueOf(pBean.getUserGender()));
		//
		userDao.create(obj);
		obj = userDao.getUserByEmail(pBean.getUserEmail());
		
		return obj.getUserId();
	}

	@Override
	public UserBean getUserById(int pId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean getUserByEmail(String pEmail)
	{
		UserBean retBean = new UserBean();
		UserInfo object = userDao.getUserByEmail(pEmail);
		if (object == null)
		{
			return null;
		}
		//
		retBean.setUserId(object.getUserId());
		retBean.setUserName(object.getUsername());
		retBean.setUserEmail(object.getEmail());
		retBean.setFirstPassword(object.getPassword());
		retBean.setUserGender(String.valueOf(object.getGender()));
		//
		Date dBirth = object.getDateOfBirth();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dBirth);
		retBean.setUserBirthYear(String.valueOf(cal.get(Calendar.YEAR)));
		retBean.setUserBirthMonth(String.valueOf(cal.get(Calendar.MONTH + 1)));
		retBean.setUserBirthDay(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		//
		retBean.setCreateTime(DateUtilZ.convertDateToString(object.getCreateTime()));
		
		return retBean;
		
	}

	@Override
	public void updateUser(UserBean pBean)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserByid(int pId)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserByEmail(String pEmail)
	{
		// TODO Auto-generated method stub

	}

}
