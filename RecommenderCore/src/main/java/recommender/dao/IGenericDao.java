package recommender.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jason.Zhuang
 * Apr 28, 2019
 * IGenericDao.java
 * Describe:
 */
public interface IGenericDao<T>
{
	/**
	 * create a new entity save to database
	 * @param entity
	 */
	void create(T entity);
	
	/**
	 * delete a entity from database
	 * @param entity
	 */
    void delete(T entity);
    
    /**
     * update entity to database
     * @param entity
     */
    void update(T entity);
    
    /**
     * get an entity object from database table by its PK
     * @param entity.class
     * @param id
     * @return
     */
    T findById(T entity, Serializable id);
    
    /**
    * insert a List of entity
    * @param entityList
    * @return
    */
    int insertBatch(List<T> entityList);
	
    /**
     * delete All recoders in a table
     * @param s
     */
	void deleteAll(String s);

	/**
	 * truncate a table
	 * @param s
	 */
	void truncateTable(String s);

	/**
	 * flush EntityManager
	 */
	void flushEM();
}
