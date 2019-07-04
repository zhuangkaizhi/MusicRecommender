package recommender.datastructure;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jason.Zhuang
 * Jun 1, 2019
 * AbstractVector.java
 * Describe:
 */
public abstract class AbstractVector implements IVector
{

	protected final Log LOG = LogFactory.getLog(this.getClass());

	protected ArrayList<ItemValueEntity> itemList;

	public AbstractVector()
	{
		if (itemList==null)
		{
			itemList = new ArrayList<>();
		}
	}
	
	public ArrayList<ItemValueEntity> getItemList()
	{
		return itemList;
	}

	public void setItemList(ArrayList<ItemValueEntity> itemList)
	{
		this.itemList = itemList;
	}
	
	
	public abstract void addItem(ItemValueEntity obj);
	
	public abstract void delItem(ItemValueEntity obj);
	
	public abstract void delItem(int itemIndex);
	

	@Override
	public int getNumEntries()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemValueEntity getVectorEntry(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, double value)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public double get(int index)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sum()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sumOfSquares()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mean()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
    
}
