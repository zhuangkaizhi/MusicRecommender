package recommender.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.classfile.ConstantValue;

import app.utilities.DateUtilZ;
import app.utilities.IpUtils;
import recommender.core.entities.Artist;
import recommender.core.entities.PlayLog;
import recommender.core.entities.Track;
import recommender.web.AppConstantsValue;
import recommender.web.bean.PlayLogBean;
import recommender.web.bean.RecommendAlbum;
import recommender.web.bean.RecommendAlbumSlides;
import recommender.web.service.IRecommenderService;

@Controller
public class RecommenderController extends BaseController
{
	private static final long serialVersionUID = 4857544233259801029L;
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private IRecommenderService rService;
	
	//=============================================//
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
	
	
	@RequestMapping(value = "/play", method = RequestMethod.GET)				
	public void playTrack(@RequestParam("albumId") String albumId,
						  @RequestParam("trackId") String trackId,
						  @RequestParam("userId")  String userId,
						  HttpSession session,
						  HttpServletRequest request)
	{
		System.out.println("userId="+userId + ":albumId=" + albumId + ":trackId="+trackId);
		String ipAddress = IpUtils.getClientIpAddressIfServletRequestExist(); 
		String browser = "";
		//
		Calendar cal = Calendar.getInstance();
		Date curtPlayTime = cal.getTime();
		//
		int iUserId = Integer.valueOf(userId);
		PlayLog obj = rService.getLatestLogByUserId(iUserId);
		if (obj != null)
		{
			Date previousPlayTime = obj.getPlayTime();
			long seconds = (curtPlayTime.getTime() - previousPlayTime.getTime())/1000;
			if (seconds != 0 && seconds < AppConstantsValue.MAX_MUSIC_SECONDS)
			{
				obj.setEndPlayTime(curtPlayTime);
				obj.setPlayDuration((int)seconds);
			}else
			{
				Track track = rService.getTrackByTrackId(obj.getTrack_id());
				int duration = track.getDuration();
				Calendar calTemp = Calendar.getInstance();
				calTemp.setTimeInMillis(previousPlayTime.getTime());
				calTemp.add(Calendar.SECOND, duration);
				obj.setEndPlayTime(calTemp.getTime());
				obj.setPlayDuration(duration);
			}
			rService.updatePlayLog(obj);
		}
		
		PlayLogBean bean = new PlayLogBean();
		bean.setUserId(userId);
		bean.setAlbumId(albumId);
		bean.setTrackId(trackId);
		bean.setPlayTime(curtPlayTime);
		bean.setIpAddress(ipAddress);
		bean.setBrowser(browser);
		bean.setStartPlayTime(curtPlayTime);
		bean.setEndPlayTime(null);
		bean.setPlayDuration(0);
		
		rService.savePlayLog(bean);
		
		System.out.println("Save play log"+bean.getPlayTime());
		
	}
	
	

}
