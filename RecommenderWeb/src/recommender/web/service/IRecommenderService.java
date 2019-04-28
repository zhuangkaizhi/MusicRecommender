package recommender.web.service;

import java.util.List;

import recommender.core.entities.Artist;
import recommender.web.bean.RecommendAlbum;
import recommender.web.bean.RecommendAlbumSlides;

public interface IRecommenderService
{
	public Artist getArtistById(String id);

	public RecommendAlbumSlides getRecommendAlbumSlides();
	
	public List<RecommendAlbum> getRecommendAlbum(int slideIdx);
	
}
