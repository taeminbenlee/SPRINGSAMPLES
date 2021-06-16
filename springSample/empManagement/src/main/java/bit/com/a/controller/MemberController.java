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
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//MemberService
	@RequestMapping(value="login.do", method = RequestMethod.GET)	
	public String login() {
		//logger.info("MemberController login 메소드 실행됨 " + new Date());
		
		return "login";		
	}
		

	
	@Autowired
	MemberService memberService;
	
	

	
	

	//컨트롤러에서 컨트롤러로 이동할때는 "redirect:/bbslist.do";
}
