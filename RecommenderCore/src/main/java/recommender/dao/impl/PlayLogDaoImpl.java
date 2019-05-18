package recommender.dao.impl;

import org.springframework.stereotype.Repository;

import recommender.core.entities.PlayLog;
import recommender.dao.IPlayLogDao;

/**
 * @author Jason.Zhuang
 * May 9, 2019
 * PlayLogDaoImpl.java
 * Describe:
 */
@Repository
public class PlayLogDaoImpl extends GenericDaoImpl<PlayLog> implements IPlayLogDao
{

	public PlayLogDaoImpl()
	{
		// TODO Auto-generated constructor stub
	}

}
