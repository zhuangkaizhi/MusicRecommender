package recommender.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import recommender.web.bean.UserBean;
import recommender.web.service.IUserManager;

@RestController
public class UserManagerController extends BaseController
{

	@Autowired
	IUserManager userManager;
	
	public UserManagerController()
	{
		;
	}
	
	@PostMapping(value = "/regUser")
	public ResponseEntity<?> createUser(@RequestBody UserBean pBean, HttpSession session) 
	{
		//System.out.println("==========" + pBean.getUserName());
		int retValue = userManager.createUser(pBean);
		if (retValue == -1)
		{
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}else
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/loginUser")
	public ResponseEntity<UserBean> login(@RequestBody UserBean pBean, HttpSession session) 
	{
		UserBean retBean = new UserBean();
		
		String userEmail = pBean.getUserEmail();
		String userPassd = pBean.getFirstPassword();
		if (userEmail==null || userEmail.equals("") 
			|| userPassd == null || userPassd.equals(""))
		{
			retBean.setUserId(-1);
			retBean.setUserName("");
			retBean.setUserEmail(pBean.getUserEmail());
		}
		
		UserBean uBean = userManager.getUserByEmail(userEmail);
		if (uBean == null)
		{
			retBean.setUserId(-1);
			retBean.setUserName("");
			retBean.setUserEmail(pBean.getUserEmail());
		}
		
		if (userPassd.equals(uBean.getFirstPassword()))
		{
			retBean.setUserId(uBean.getUserId());
			retBean.setUserName(uBean.getUserName());
			retBean.setUserEmail(uBean.getUserEmail());
			return new ResponseEntity<UserBean>(retBean, HttpStatus.OK);
		}
		
		return new ResponseEntity<UserBean>(retBean, HttpStatus.UNAUTHORIZED);
		
	}
	
	/*
	@ResponseBody
	@RequestMapping(value = "/regUser", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserInfo user,
			UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating User " + user.getUsername());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<Void> getUsers()
	{
		System.out.println("==========");
		return null;
	}
	*/

}
