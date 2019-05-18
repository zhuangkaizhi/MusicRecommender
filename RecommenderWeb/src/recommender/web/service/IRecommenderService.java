package recommender.web.service;

import java.util.List;

import recommender.core.entities.Artist;
import recommender.core.entities.PlayLog;
import recommender.core.entities.Track;
import recommender.web.bean.PlayLogBean;
import recommender.web.bean.RecommendAlbum;
import recommender.web.bean.RecommendAlbumSlides;

public interface IRecommenderService
{
	public Artist getArtistById(String id);

	public RecommendAlbumSlides getRecommendAlbumSlides();
	
	public List<RecommendAlbum> getRecommendAlbum(int slideIdx);
	
	public Track getTrackByTrackId(int p_trackId);
	
	public int savePlayLog(PlayLogBean pPlayLogBean);
	
	public PlayLog getLatestLogByUserId(int p_userId);
	
	public void updatePlayLog(PlayLog pPlayLogObj);
}
