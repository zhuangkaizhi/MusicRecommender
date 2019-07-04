package recommender.dao;

import java.util.List;

import recommender.core.entities.UserRecommend;

/**
 * 
 * @author Jason.Zhuang
 * May 23, 2019
 * IUserRecommendDao.java
 * Describe: 
 */
public interface IUserRecommendDao extends IGenericDao<UserRecommend>
{
	public List<UserRecommend> getLimitedRecommendationByUserId(int limit, int userId);
}
