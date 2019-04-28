
package recommender.download.pojo_json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonGenreList implements Serializable
{
	private final static long serialVersionUID = 7245126838474608270L;
	
	@SerializedName("data")
	@Expose
	private List<JsonGenre> data = new ArrayList<JsonGenre>();

	public List<JsonGenre> getData()
	{
		return data;
	}

	public void setData(List<JsonGenre> data)
	{
		this.data = data;
	}

}
