package recommender.download;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceUtils;

import app.utilities.StaticUtils;
import recommender.download.pojo_json.JsonAlbum;
import recommender.download.pojo_json.JsonTrack;
import recommender.download.service.impl.AlbumDownloadService;
import recommender.download.service.impl.ArtistDownloadService;
import recommender.download.service.impl.TrackDownloadService;

/**
 * @author Jason Zhuang
 * @version Create Date：April 20, 2019 1:43:12 AM
 */
public class DataDownload
{
	private final static Logger log =  LogManager.getLogger(DataDownload.class);
	
	private Client client;
	
	private static AlbumDownloadService  albumService;
	private static ArtistDownloadService artistService;
	private static TrackDownloadService  trackService;
	
	public DataDownload()
	{
		this.client = ClientBuilder.newClient();
	}

	public void init()
	{
		;
	}

	
	public static void main(String[] args)
	{
		try
		{
			StaticUtils.initApplicationContext();
			//
			albumService = (AlbumDownloadService) StaticUtils.getContext().getBean("albumDownloadService");
			artistService = (ArtistDownloadService) StaticUtils.getContext().getBean("artistDownloadService");
			trackService = (TrackDownloadService) StaticUtils.getContext().getBean("trackDownloadService");
			trackService.clearTable();
			artistService.clearTable();
			albumService.clearTable();
			//
			DataDownload dd = (DataDownload) StaticUtils.getContext().getBean("dataDownload");
			dd.processAlbum();
			
		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	private void processAlbum() throws IOException
	{
		GsonHelper<JsonAlbum> gson = new GsonHelper<>();
		int maxNumber = 100;
		int start_id=302127;
		String id = "";
		try
		{
			for (int i=0;i<maxNumber;i++)
			{
				id = String.valueOf((start_id + i));
				String jsonText = getAlbumJson(id);
				JsonAlbum jsonObject = gson.deSerializeEntityWithList(jsonText, new JsonAlbum());
				
				if (jsonObject == null || jsonObject.getId() == null)
				{
					continue;
				}
				//
				log.info("==================== Process Album Id:"+jsonObject.getId());
				//
				try
				{
					albumService.saveData(jsonObject);
					if (jsonObject.getArtist() != null)
					{
						artistService.saveData(jsonObject.getArtist());
						artistService.saveRelationAlbum(jsonObject.getId(), jsonObject.getArtist().getId());
					}
					if (jsonObject.getTracklist() != null)
					{
						List<JsonTrack> tracks = jsonObject.getTracks().getData();
						for (JsonTrack tempObj : tracks)
						{
							tempObj.setAlbum(jsonObject);
						}
						trackService.saveData(tracks);
					}
					//
					Thread.sleep(500L);
					//
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		log.info("==================== end ==============");
	}
	
	
	private String getAlbumJson(String id)
	{
		String stringResponse ="";
		Builder builder = client.target(AppConstants.DEEZER_SERVICE_ALBUM_BASE_URL)
						.path("/{albumId}")
						.resolveTemplate("albumId", id)
						.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
		if (response.getStatus() == 200) 
		{
			stringResponse = response.readEntity(String.class);
			
		} else 
		{
			stringResponse="null";
		}
		
		return stringResponse;
	}
	
	
	
	@SuppressWarnings("unused")
	private void processArtist() throws IOException
	{
		
	}
	
	@SuppressWarnings("unused")
	private void processTrack() throws IOException
	{
		System.out.println("====================begin===============");
		TrackDownloadService trackService = (TrackDownloadService) StaticUtils.getContext().getBean("trackService");
		GsonHelper<JsonTrack> gson = new GsonHelper<>();
		String id="";
		trackService.truncateTable();
		for (int i=0;i<10000;i++)
		{
			id = String.valueOf((3135556 + i));
			String jsonText = getTrackJson(id);
			JsonTrack track = gson.deSerializeEntityWithList(jsonText, new JsonTrack());
			if (track == null)
			{
				continue;
			}
			try
			{
				trackService.saveData(track);
				System.out.println("=="+ id +":"+track.getTitle());
				Thread.sleep(500L);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("==================== end ==============");
	}
	
	public String getTrackJson(String id)
	{
		String stringResponse ="";
		Builder builder = client.target(AppConstants.DEEZER_SERVICE_TRACK_BASE_URL)
						.path("/{trackId}")
						.resolveTemplate("trackId", id)
						.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
		if (response.getStatus() == 200) 
		{
			stringResponse = response.readEntity(String.class);
			
		} else 
		{
			stringResponse="null";
		}
		
		return stringResponse;
	}
	
	public void Test()
	{
		// Retrieve the data source from the application context
		DataSource ds = (DataSource) StaticUtils.getContext().getBean("dataSource");
		// Open a database connection using Spring's DataSourceUtils
		Connection c = DataSourceUtils.getConnection(ds);
		try {
		    // retrieve a list of three random cities
		    PreparedStatement ps = c.prepareStatement(
		        "select City.Name as 'City', Country.Name as 'Country' " +
		        "from City inner join Country on City.CountryCode = Country.Code " +
		        "order by rand() limit 3");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) 
		    {
		        String city = rs.getString("City");
		        String country = rs.getString("Country");
		        System.out.printf("The city %s is in %s%n", city, country);
		    }
		} catch (SQLException ex) 
		{
		    // something has failed and we print a stack trace to analyse the error
		    ex.printStackTrace();
		    // ignore failure closing connection
		    try { c.close(); } catch (SQLException e) { }
		} finally {
		    // properly release our connection
		    DataSourceUtils.releaseConnection(c, ds);
		}
	}

}
