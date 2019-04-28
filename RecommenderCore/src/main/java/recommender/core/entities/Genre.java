package recommender.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
@NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")
public class Genre implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id", unique = true, nullable = false)
	private int genreId;

	@Column(name = "genre_name", nullable = false, length = 255)
	private String genreName;

	@OneToMany(mappedBy = "genre")
	private List<Album> albums;

	public Genre()
	{
	}

	public int getGenreId()
	{
		return this.genreId;
	}

	public void setGenreId(int genreId)
	{
		this.genreId = genreId;
	}

	public String getGenreName()
	{
		return this.genreName;
	}

	public void setGenreName(String genreName)
	{
		this.genreName = genreName;
	}

	public List<Album> getAlbums()
	{
		return this.albums;
	}

	public void setAlbums(List<Album> albums)
	{
		this.albums = albums;
	}

	public Album addAlbum(Album album)
	{
		getAlbums().add(album);
		album.setGenre(this);

		return album;
	}

	public Album removeAlbum(Album album)
	{
		getAlbums().remove(album);
		album.setGenre(null);

		return album;
	}

}
