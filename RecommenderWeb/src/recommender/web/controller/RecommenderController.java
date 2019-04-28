package recommender.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import recommender.core.entities.Artist;
import recommender.web.bean.RecommendAlbum;
import recommender.web.bean.RecommendAlbumSlides;
import recommender.web.service.IRecommenderService;

@Controller
public class RecommenderController extends BaseController
{
	@Autowired
	private IRecommenderService rService;
	
	public RecommenderController(){}
	
	@RequestMapping("/artists")
	public ModelAndView getAllArtists() 
	{
		Artist artist = rService.getArtistById("Jason Zhuang");
		System.out.println("getAllArtists: " + artist.getName() );
		ModelAndView mv = new ModelAndView("content/artists");
		mv.addObject("name", artist.getName());
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rAlbumTest" 
				, method = RequestMethod.GET
				, headers = "Accept=application/json")				
	public List<RecommendAlbum> getRecommendAlbumTest() 
	{
		List<RecommendAlbum> retList = rService.getRecommendAlbum(1);
		return retList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rAlbum" 
				, method = RequestMethod.GET
				, headers = "Accept=application/json")				
	public RecommendAlbumSlides getRecommendAlbum() 
	{
		RecommendAlbumSlides retSlides = rService.getRecommendAlbumSlides();
		return retSlides;
	}
	

}
