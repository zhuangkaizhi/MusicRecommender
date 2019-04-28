package recommender.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import recommender.download.pojo_json.JsonArtist;
import recommender.download.pojo_json.JsonContributor;
import recommender.download.pojo_json.JsonGenre;
import recommender.download.pojo_json.JsonGenreList;
import recommender.download.pojo_json.JsonTrack;

public class GsonHelper<T>
{
	private static Gson gson = null;
	
	public static void main(String[] args)
	{
		/*
		GsonHelper<Object> test = new GsonHelper<Object>();
		test.readJsonFile(null);
		 */
		
		//this is for testing a simple object which contains only genetic type 
		/*
		GsonHelper<Contributor> ghSimple = new GsonHelper<Contributor>();
		Contributor contributor = ghSimple.getDummyContributor();
		String jsonContributor = ghSimple.serializeSimpleEntity(contributor);
		Contributor contributorNew = ghSimple.deSerializeSimpleEntity(jsonContributor, contributor);
		System.out.println("===="+contributorNew.getName());
		*/
		/*
		//this is for testing a nested object which contains some other objects other than genetic type
		GsonHelper<Track> ghNested = new GsonHelper<Track>();
		Track track = ghNested.getDummyTrack();
		String jsonTrack = ghNested.serializeNestedEntity(track);
		System.out.println("=="+jsonTrack+"==");
		Track trackNew = ghNested.deserializeNestedEntity(jsonTrack, track);
		System.out.println(trackNew.getTitle());
		*/
		
		/*
		//this is for testing the object which contains List
		GsonHelper<Genres> ghWithList = new GsonHelper<Genres>();
		Genres genres = ghWithList.getDummyGenres();
		String jsonGenres = ghWithList.serializeEntityWithList(genres);
		Genres genresNew = ghWithList.deSerializeEntityWithList(jsonGenres, genres);
		System.out.println("====="+genresNew.toString());
		*/
		
	}
	
	
	public GsonHelper()
	{
		if (gson==null)
		{
			gson = new Gson();
		}
	}

	public JsonTrack deSerialize()
	{
		GsonHelper<JsonTrack> ghNested = new GsonHelper<JsonTrack>();
		JsonTrack track = new JsonTrack();
		String jsonTrack = ghNested.readJsonFile("track.json");
		JsonTrack trackNew = ghNested.deserializeNestedEntity(jsonTrack, track);
		System.out.println(trackNew.getTitle());
		return trackNew;
	}
	
	public String readJsonFile(String pFile)
	{
		String bootPath=System.getProperty("user.dir"); 
		StringBuilder sb = new StringBuilder();
		Path path = Paths.get(bootPath + "\\data\\" + pFile );
		try (BufferedReader br = Files.newBufferedReader(path))
		{
            // read line by line
            String line;
            while ((line = br.readLine()) != null) 
            {
                sb.append(line).append("\n");
            }

        } catch (IOException e) 
		{
            System.err.format("IOException: %s%n", e);
        }

		return sb.toString();
		
	}
	
	
	
	/**
	 * serialize a Simple Entity which only contain Genetic type
	 * @param obj
	 * @return
	 */
	public String serializeSimpleEntity(T obj)
	{
		String json = gson.toJson(obj);
		return json;
	}
	
	/**
	 * deserialize a Simple Entity which only contain Genetic type
	 * @param jsonSimple
	 * @param obj
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public T deSerializeSimpleEntity(String simpleJson, Object obj)
	{
		T t = (T) gson.fromJson(simpleJson, obj.getClass());
		return t;
	}
	
	/**
	 * serialize an Entity which contains not only Genetic type but also other object
	 * @param obj
	 * @return
	 */
	public String serializeNestedEntity(T obj)
	{
		String json = gson.toJson(obj);
		return json;
	}
	
	/**
	 * deserialize an Entity which contains not only Genetic type but also other object
	 * @param json
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T deserializeNestedEntity(String json, Object obj)
	{
		T t = (T) gson.fromJson(json, obj.getClass());
		return t;
	}
	
	/**
	 * serialize an object which contains List or Array
	 * @param objWithList
	 * @return
	 */
	public String serializeEntityWithList(T objWithList)
	{
		String json = gson.toJson(objWithList);
		return json;
	}
	
	/**
	 * @param json if json start with {, and the content contains [ and ]
	 * e.g. {"genres":{"data":[{"id":113,"name":"Dance","picture":"https:\/\/api.deezer.com\/genre\/113\/image","type":"genre"}]}}
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public T deSerializeEntityWithList(String json, Object obj)
	{
		T t = (T) gson.fromJson(json, obj.getClass()) ;
		return t;
	}
	
	/**
	 * if json start with [, which means the whole json is an Arraylist, then use this method
	 * @param json
	 * @return List<T> 
	 */
	public List<T> deSerializeListEntity(String json)
	{
		Type tListType = new TypeToken<ArrayList<T>>(){}.getType();
		List<T> ts = gson.fromJson(json, tListType);
		return ts;
	}
	
	
	@SuppressWarnings("unused")
	private JsonGenreList getDummyGenres()
	{
		JsonGenreList genres = new JsonGenreList();
		List<JsonGenre> data = new ArrayList<>();
		
		JsonGenre obj1 = new JsonGenre();
		obj1.setId(1);
		obj1.setName("genre1");
		obj1.setPicture("genre_picture1");
		obj1.setType("genre");
		data.add(obj1);
		
		JsonGenre obj2 = new JsonGenre();
		obj2.setId(2);
		obj2.setName("genre2");
		obj2.setPicture("genre_picture2");
		obj2.setType("genre");
		data.add(obj2);
		
		genres.setData(data);
		
		return genres;
	}
	
	@SuppressWarnings("unused")
	private JsonContributor getDummyContributor()
	{
		JsonContributor retObj = new JsonContributor();
		retObj.setId(1);
		retObj.setName("Contributor_name");
		retObj.setLink("https://www.contriutor.com");
		retObj.setPicture("picture");
		retObj.setPictureBig("pictureBig");
		retObj.setPictureMedium("pictureMedium");
		retObj.setPictureSmall("pictureSmall");
		retObj.setPictureXl("pictureXl");
		retObj.setRadio(true);
		retObj.setRole("role");
		retObj.setShare("share");
		retObj.setTracklist("tracklist");
		retObj.setType("type");
		return retObj;
	}
	
	
	@SuppressWarnings("unused")
	private JsonTrack getDummyTrack()
	{
		JsonArtist artist = new JsonArtist();
		artist.setId(1);
		artist.setName("Artist_name");
		artist.setPicture("picture");
		artist.setPictureBig("pictureBig");
		artist.setPictureMedium("pictureMedium");
		artist.setPictureSmall("pictureSmall");
		artist.setPictureXl("pictureXl");
		artist.setTracklist("tracklist");
		artist.setType("artist_type");
		
		//
		JsonTrack track = new JsonTrack();
		track.setId(1);
		track.setReadable(true);
		track.setTitle("title");
		track.setTitleShort("titleShort");
		track.setTitleVersion("titleVersion");
		track.setLink("link");
		track.setDuration(100);
		track.setRank(10);
		track.setExplicitLyrics(false);
		track.setExplicitContentLyrics(0);
		track.setExplicitContentCover(2);
		track.setPreview("preview");
		track.setArtist(artist);
		track.setType("Track_type");
		
		return track;
	}
}
