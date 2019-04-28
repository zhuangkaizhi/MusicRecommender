package recommender.download.pojo_json;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonGenre implements Serializable
{
	private final static long serialVersionUID = -750438324898719656L;
	
	@SerializedName("id")
	@Expose
	private Integer id;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("picture")
	@Expose
	private String picture;

	@SerializedName("type")
	@Expose
	private String type;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPicture()
	{
		return picture;
	}

	public void setPicture(String picture)
	{
		this.picture = picture;
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
