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
	
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
	private List<Album> albums;
	*/
	
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

}
