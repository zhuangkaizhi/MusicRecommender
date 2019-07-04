package recommender.datastructure;

public class ItemValueEntity
{
	private int itemIndex;
	
	private int itemValue;
	
	public ItemValueEntity(int pItemId, int pValue)
	{
		this.itemIndex = pItemId;
		this.itemValue = pValue;
	}

	public int getItemIndex()
	{
		return itemIndex;
	}

	public void setItemIndex(int itemIndex)
	{
		this.itemIndex = itemIndex;
	}

	public int getItemValue()
	{
		return itemValue;
	}

	public void setItemValue(int itemValue)
	{
		this.itemValue = itemValue;
	}

}
