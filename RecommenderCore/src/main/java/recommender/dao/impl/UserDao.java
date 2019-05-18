package recommender.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.UserInfo;
import recommender.dao.IUserDao;

/**
 * @author Jason.Zhuang
 * May 9, 2019
 * UserDao.java
 * Describe:
 */
@Repository
public class UserDao extends GenericDaoImpl<UserInfo>	implements IUserDao
{

	public UserDao()
	{
		;
	}

	@Override
	public UserInfo getUserByEmail(String pEmail)
	{
		String jpql = "SELECT t FROM UserInfo t WHERE 1=1 ";
		jpql = jpql + "AND t.email=:email ";
		
		TypedQuery<UserInfo> query = em.createQuery(jpql, UserInfo.class);
		query.setParameter("email", pEmail);
		
		UserInfo returnObject;
		try
		{
			returnObject = query.getSingleResult();
		}catch (NoResultException exp)
		{
			returnObject = null;
		}catch (Exception exp)
		{
			returnObject = null;
		}
		
		return returnObject;
		
	}
	
	

}
