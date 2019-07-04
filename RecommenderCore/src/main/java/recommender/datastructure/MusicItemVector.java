package recommender.datastructure;

public class MusicItemVector extends AbstractVector
{

	public MusicItemVector()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addItem(ItemValueEntity obj)
	{
		this.itemList.add(obj);
	}

	@Override
	public void delItem(ItemValueEntity obj)
	{
		this.itemList.remove(obj);
	}

	@Override
	public void delItem(int pItemIndex)
	{
		for(int i=0;i<itemList.size();i++)
		{
			ItemValueEntity obj = itemList.get(i);
			if (obj.getItemIndex()==pItemIndex)
			{
				itemList.remove(i);
			}
		}
	}

	

}
