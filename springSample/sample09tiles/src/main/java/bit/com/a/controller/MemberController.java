package bit.com.a.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//MemberService
	@RequestMapping(value="login.do", method = RequestMethod.GET)	
	public String login() {
		logger.info("MemberController login 메소드 실행됨 " + new Date());
		
		return "login.tiles";		
	}
	@RequestMapping(value="bbslist.do", method = RequestMethod.GET)	
	public String bbslist() {
		logger.info("MemberController bbslist 메소드 실행됨 " + new Date());
		
		return "bbslist.tiles";		
	}
		
	@RequestMapping(value="regi.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String regi() {
		//logger.info("MemberController regi 메소드 실행됨 " + new Date());
		return "regi";
	}
	
	
}
