package recommender.web.bean;

public class RecommendAlbum
{
	private String albumId;
	
	private String albumName;
	
	private String albumDescribe;
	
	private String imageCover;
	
	private String playLink;
	
	private String detailLink;
	
	public RecommendAlbum()
	{
		;
	}

	public String getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(String albumId)
	{
		this.albumId = albumId;
	}

	public String getAlbumName()
	{
		return albumName;
	}

	public void setAlbumName(String albumName)
	{
		this.albumName = albumName;
	}
	
	public String getAlbumDescribe()
	{
		return albumDescribe;
	}

	public void setAlbumDescribe(String albumDescribe)
	{
		this.albumDescribe = albumDescribe;
	}

	public String getImageCover()
	{
		return imageCover;
	}

	public void setImageCover(String imageCover)
	{
		this.imageCover = imageCover;
	}

	public String getPlayLink()
	{
		return playLink;
	}

	public void setPlayLink(String playLink)
	{
		this.playLink = playLink;
	}

	public String getDetailLink()
	{
		return detailLink;
	}

	public void setDetailLink(String detailLink)
	{
		this.detailLink = detailLink;
	}
	
	
	
}
