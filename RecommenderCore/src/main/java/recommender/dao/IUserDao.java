package recommender.dao;

import recommender.core.entities.UserInfo;
import recommender.dao.IGenericDao;

public interface IUserDao extends IGenericDao<UserInfo>
{
	public UserInfo getUserByEmail(String pEmail);

}
