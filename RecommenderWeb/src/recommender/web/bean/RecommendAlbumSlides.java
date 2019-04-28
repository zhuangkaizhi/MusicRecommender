package recommender.web.bean;

import java.util.List;

public class RecommendAlbumSlides
{
	private List<RecommendAlbum> rAlbumSide1;
	
	private List<RecommendAlbum> rAlbumSide2;
	
	private List<RecommendAlbum> rAlbumSide3;

	public RecommendAlbumSlides()
	{
	}

	public List<RecommendAlbum> getrAlbumSide1()
	{
		return rAlbumSide1;
	}

	public void setrAlbumSide1(List<RecommendAlbum> rAlbumSide1)
	{
		this.rAlbumSide1 = rAlbumSide1;
	}

	public List<RecommendAlbum> getrAlbumSide2()
	{
		return rAlbumSide2;
	}

	public void setrAlbumSide2(List<RecommendAlbum> rAlbumSide2)
	{
		this.rAlbumSide2 = rAlbumSide2;
	}

	public List<RecommendAlbum> getrAlbumSide3()
	{
		return rAlbumSide3;
	}

	public void setrAlbumSide3(List<RecommendAlbum> rAlbumSide3)
	{
		this.rAlbumSide3 = rAlbumSide3;
	}
	
}
