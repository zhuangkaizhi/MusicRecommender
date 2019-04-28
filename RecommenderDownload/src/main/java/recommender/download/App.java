package recommender.download;

import recommender.download.pojo_json.JsonTrack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Download System Start..." );
        //
        String trackID = "3000000";
        DataDownload d = new DataDownload();
        String json = d.getTrackJson(trackID);
        //
		GsonHelper<JsonTrack> ghWithList = new GsonHelper<JsonTrack>();
		JsonTrack track = ghWithList.deSerializeEntityWithList(json, new JsonTrack());
		System.out.println(track.getTitle());
        
    }
}
