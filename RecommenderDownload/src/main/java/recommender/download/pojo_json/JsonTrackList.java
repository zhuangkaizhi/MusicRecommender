
package recommender.download.pojo_json;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonTrackList implements Serializable
{
	private static final long serialVersionUID = -8086818199867900417L;
	
	@SerializedName("data")
	@Expose
	private List<JsonTrack> data;

	public List<JsonTrack> getData()
	{
		return data;
	}

	public void setData(List<JsonTrack> data)
	{
		this.data = data;
	}

}
