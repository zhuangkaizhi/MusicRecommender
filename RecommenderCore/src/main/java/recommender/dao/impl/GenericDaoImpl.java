package recommender.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import recommender.dao.IGenericDao;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * GenericDaoImpl.java
 * Describe:
 */
@Repository
public class GenericDaoImpl<T> implements IGenericDao<T>
{

	@PersistenceContext
	protected EntityManager em;

	protected int batchSize = 1000;

	@Override
	@Transactional
	public void create(T entity)
	{
		em.persist(entity);
	}

	@Override
	@Transactional
	public void delete(T entity)
	{
		em.remove(entity);
	}

	@Override
	@Transactional
	public void update(T entity)
	{
		em.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(T entity, Serializable id)
	{
		return (T) em.find(entity.getClass(), id);
	}

	@Override
	@Transactional(readOnly = false)  
	public int insertBatch(List<T> entityList)
	{
		try
		{
			int length = entityList.size();
			for (int i = 0; i < length; i++)
			{
				if (i > 0 && i % batchSize == 0)
				{
					em.flush();
					em.clear();
				}
				em.persist(entityList.get(i));
			}
			em.flush();
			em.clear();
		}catch (Exception exp)
		{
			em.clear();
			return -1;
		}
		return 0;
	}
	
	@Override
	@Transactional
	public void deleteAll(String entityName)
	{
		try
		{
			Query q = em.createQuery((new StringBuilder()).append("DELETE FROM ").append(entityName).toString());
			q.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void truncateTable(String tableName)
	{
		String query = (new StringBuilder("TRUNCATE TABLE ")).append(tableName).toString();
		em.createNativeQuery(query).executeUpdate();
	}

	@Override
	@Transactional
	public void flushEM()
	{
		em.flush();
		em.clear();
	}
	
}
