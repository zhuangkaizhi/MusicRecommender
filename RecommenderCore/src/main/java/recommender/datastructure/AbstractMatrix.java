package recommender.datastructure;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jason.Zhuang
 * Jun 3, 2019
 * AbstractMatrix.java
 * Describe: The basic abstract matrix class which implement IMatrix
 */
public abstract class AbstractMatrix implements IMatrix
{
    protected final Log LOG = LogFactory.getLog(this.getClass());

    protected int rows; //the number of rows in Matrix
    
    protected int columns;//the number of columns in Matrix
    
    protected static Map<Integer, AbstractVector> dataMatrix;

    public AbstractMatrix() 
    {
    	if (dataMatrix==null)
    	{
    		dataMatrix = new HashMap<>();
    	}
    }

	public static Map<Integer, AbstractVector> getDataMatrix()
	{
		return dataMatrix;
	}

	@Override
	public void addVector(AbstractVector v)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVector(int v_key, AbstractVector v)
	{
		dataMatrix.put(v_key, v);
	}
	
	@Override
	public int columnSize()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rowSize()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IVector getRow(int rowIdx)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVector getColumn(int columnIdx)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCell(int row, int column)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCell(int row, int column, double value)
	{
		// TODO Auto-generated method stub
		
	}
    
    
}
