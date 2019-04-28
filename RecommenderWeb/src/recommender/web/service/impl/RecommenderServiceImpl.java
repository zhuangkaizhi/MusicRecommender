package recommender.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recommender.core.entities.Album;
import recommender.core.entities.AlbumTrack;
import recommender.core.entities.Artist;
import recommender.dao.IAlbumDao;
import recommender.web.bean.RecommendAlbum;
import recommender.web.bean.RecommendAlbumSlides;
import recommender.web.service.IRecommenderService;

@Service
public class RecommenderServiceImpl implements IRecommenderService
{

	@Autowired
	private IAlbumDao albumDao;
	
	public RecommenderServiceImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Artist getArtistById(String id)
	{
		Artist artist = new Artist();
		artist.setName("Jason Zhuang");
		return artist;
	}
	
	@Override
	public RecommendAlbumSlides getRecommendAlbumSlides()
	{
		
		RecommendAlbumSlides retSlides = new RecommendAlbumSlides();
		retSlides.setrAlbumSide1(getRecommendAlbum(1));
		retSlides.setrAlbumSide2(getRecommendAlbum(2));
		retSlides.setrAlbumSide3(getRecommendAlbum(3));
		return retSlides;
	}

	@Override
	public List<RecommendAlbum> getRecommendAlbum(int slideIdx)
	{
		List<RecommendAlbum> retList = new ArrayList<RecommendAlbum>();
		Random rand = new Random();
		// Obtain a number between [0 - 100].
		long id1 = rand.nextInt(100) + 200;
		long id2 = id1 + 1;
		long id3 = id1 + 2;
		long id4 = id1 + 3;
		
		Album obj1 = new Album();
		obj1 = albumDao.findById(obj1, id1);
		RecommendAlbum r1 = new RecommendAlbum();
		r1.setAlbumId(String.valueOf(obj1.getAlbum_id()));
		r1.setAlbumName(obj1.getTitle());
		r1.setAlbumDescribe(obj1.getLabel());
		r1.setImageCover(obj1.getImageMedium());
		r1.setDetailLink("/album?id="+ obj1.getAlbum_id());
		List<AlbumTrack> lst1 = obj1.getAlbumTracks();
		AlbumTrack albumTrack = lst1.get(0);
		albumTrack.getTrack().getPreview_url();
		
		r1.setPlayLink(obj1.getAlbumTracks().get(0).getTrack().getPreview_url());
		retList.add(r1);
		
		//
		Album obj2 = new Album();
		obj2 = albumDao.findById(obj2, id2);
		RecommendAlbum r2 = new RecommendAlbum();
		r2.setAlbumId(String.valueOf(obj2.getAlbum_id()));
		r2.setAlbumName(obj2.getTitle());
		r2.setAlbumDescribe(obj2.getLabel());
		r2.setImageCover(obj2.getImageMedium());
		r2.setDetailLink("/album?id="+ obj2.getAlbum_id());
		r2.setPlayLink(obj2.getAlbumTracks().get(0).getTrack().getPreview_url());
		retList.add(r2);
		
		//
		Album obj3 = new Album();
		obj3 = albumDao.findById(obj3, id3);
		RecommendAlbum r3 = new RecommendAlbum();
		r3.setAlbumId(String.valueOf(obj3.getAlbum_id()));
		r3.setAlbumName(obj3.getTitle());
		r3.setAlbumDescribe(obj3.getLabel());
		r3.setImageCover(obj3.getImageMedium());
		r3.setDetailLink("/album?id="+ obj3.getAlbum_id());
		r3.setPlayLink(obj3.getAlbumTracks().get(0).getTrack().getPreview_url());
		retList.add(r3);
		
		//
		Album obj4 = new Album();
		obj4 = albumDao.findById(obj4, id4);
		RecommendAlbum r4 = new RecommendAlbum();
		r4.setAlbumId(String.valueOf(obj4.getAlbum_id()));
		r4.setAlbumName(obj4.getTitle());
		r4.setAlbumDescribe(obj4.getLabel());
		r4.setImageCover(obj4.getImageMedium());
		r4.setDetailLink("/album?id="+ obj4.getAlbum_id());
		r4.setPlayLink(obj4.getAlbumTracks().get(0).getTrack().getPreview_url());
		retList.add(r4);
		
		return retList;
		
	}
	
	
	public List<RecommendAlbum> getRecommendAlbum2(int slideIdx)
	{
		List<RecommendAlbum> retList = new ArrayList<RecommendAlbum>();
		
		RecommendAlbum a = new RecommendAlbum();
		a.setAlbumId("1");
		a.setAlbumName("The First");
		a.setAlbumDescribe("This is First Album");
		switch (slideIdx)
		{
			case 1:
				a.setImageCover("https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg");
				break;
			case 2:
				a.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/cabf70079c74cdc4a119db7c8def4e8a/250x250-000000-80-0-0.jpg");			
							break;
			case 3:
				a.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/608ec16c6904a496e9d94d8ab431298d/250x250-000000-80-0-0.jpg");
				break;
			default:
				break;
		}
		a.setDetailLink("/hello");
		a.setPlayLink("http://www.google.com");
		
		//
		RecommendAlbum b = new RecommendAlbum();
		b.setAlbumId("2");
		b.setAlbumName("The Second");
		b.setAlbumDescribe("This is second Album");
		switch (slideIdx)
		{
			case 1:
				b.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/cabf70079c74cdc4a119db7c8def4e8a/250x250-000000-80-0-0.jpg");
				break;
			case 2:
				b.setImageCover("https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg");			
				break;
			case 3:
				b.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/608ec16c6904a496e9d94d8ab431298d/250x250-000000-80-0-0.jpg");
				break;
			default:
				break;
		}
		b.setDetailLink("/hello");
		b.setPlayLink("http://www.google.com");

		//
		RecommendAlbum c = new RecommendAlbum();
		c.setAlbumId("3");
		c.setAlbumName("The Third");
		c.setAlbumDescribe("This is Third Album");
		switch (slideIdx)
		{
			case 1:
				c.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/608ec16c6904a496e9d94d8ab431298d/250x250-000000-80-0-0.jpg");
				break;
			case 2:
				c.setImageCover("https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg");			
				break;
			case 3:
				c.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/cabf70079c74cdc4a119db7c8def4e8a/250x250-000000-80-0-0.jpg");
				break;
			default:
				break;
		}
		c.setDetailLink("/hello");
		c.setPlayLink("http://www.google.com");
		
		RecommendAlbum d = new RecommendAlbum();
		d.setAlbumId("4");
		d.setAlbumName("The Fouth");
		d.setAlbumDescribe("This is Fouth Album");
		switch (slideIdx)
		{
			case 1:
				d.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/642d4202e435c194e1150fae7542e44e/250x250-000000-80-0-0.jpg");
				break;
			case 2:
				d.setImageCover("https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg");			
				break;
			case 3:
				d.setImageCover("https://e-cdns-images.dzcdn.net/images/cover/608ec16c6904a496e9d94d8ab431298d/250x250-000000-80-0-0.jpg");
				break;
			default:
				break;
		}
		d.setDetailLink("/hello");
		d.setPlayLink("http://www.google.com");
		
		retList.add(a);
		retList.add(b);
		retList.add(c);
		retList.add(d);
		
		return retList;
		
	}
	
	
	
}
