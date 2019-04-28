package recommender.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="artist")
@NamedQuery(name="Artist.findAll", query="SELECT a FROM Artist a")
public class Artist implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="artist_id", unique=true, nullable=false)
	private int artistId;

	@Column(nullable=false, length=255)
	private String name;
	
	@Column(name="picture_small", length=500)
	private String pictureSmall;
	
	@Column(name="picture_medium", length=500)
	private String pictureMedium;
	
	@Column(name="picture_big", length=500)
	private String pictureBig;

	@Column(name="picture_xl", length=500)
	private String pictureXl;

	@Column(name="nb_album")
	private int nbAlbum;

	@Column(length=255)
	private String type;

	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy="artist")
	private List<AlbumArtist> albumArtists;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="artist")
	private List<ArtistTrack> artistTracks;
	*/
	
	public Artist() 
	{
	}

	
	public long getId()
	{
		return id;
	}


	public void setId(long id)
	{
		this.id = id;
	}


	public int getArtistId()
	{
		return artistId;
	}

	public void setArtistId(int artistId)
	{
		this.artistId = artistId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPictureSmall()
	{
		return pictureSmall;
	}

	public void setPictureSmall(String pictureSmall)
	{
		this.pictureSmall = pictureSmall;
	}

	public String getPictureMedium()
	{
		return pictureMedium;
	}

	public void setPictureMedium(String pictureMedium)
	{
		this.pictureMedium = pictureMedium;
	}

	public String getPictureBig()
	{
		return pictureBig;
	}

	public void setPictureBig(String pictureBig)
	{
		this.pictureBig = pictureBig;
	}

	public String getPictureXl()
	{
		return pictureXl;
	}

	public void setPictureXl(String pictureXl)
	{
		this.pictureXl = pictureXl;
	}

	public int getNbAlbum()
	{
		return nbAlbum;
	}

	public void setNbAlbum(int nbAlbum)
	{
		this.nbAlbum = nbAlbum;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
}
