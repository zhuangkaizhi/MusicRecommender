package recommender.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import recommender.core.entities.UserRecommend;
import recommender.dao.IUserRecommendDao;
/**
 * @author Jason.Zhuang
 * May 23, 2019
 * UserRecommendDaoImpl.java
 * Describe:
 */
@Repository
public class UserRecommendDaoImpl 
			 extends GenericDaoImpl<UserRecommend>	
			 implements IUserRecommendDao
{

	public UserRecommendDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserRecommend> getLimitedRecommendationByUserId(int limit,
																int userId)
	{
		// TODO Auto-generated method stub
		String jpql = "SELECT t FROM UserRecommend t WHERE 1=1 ";
		jpql = jpql + "AND t.userId=:pUserId  ";
		jpql = jpql + "ORDER BY t.recommendTime DESC ";
		
		TypedQuery<UserRecommend> query = em.createQuery(jpql, UserRecommend.class);
		query.setParameter("pUserId", userId);
		query.setMaxResults(limit);
		
		List<UserRecommend> returnList;
		try
		{
			returnList = query.getResultList();
		}catch (NoResultException exp)
		{
			returnList = null;
		}catch (Exception exp)
		{
			returnList = null;
		}
		
		return returnList;
	}

}
