package recommender.datastructure;

public class MusicDataMatrix extends AbstractMatrix
{

	public MusicDataMatrix()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractVector getVector(int pVkey)
	{
		MusicItemVector obj = (MusicItemVector) dataMatrix.get(pVkey);
		return obj;
	}

}
