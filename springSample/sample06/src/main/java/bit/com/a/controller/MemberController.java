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
		
	@RequestMapping(value="regi.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String regi() {
		//logger.info("MemberController regi 메소드 실행됨 " + new Date());
		return "regi";
	}
	
	@Autowired
	MemberService memberService;
	
	/* 3 Ajax 활용 데이터 전송*/
	@ResponseBody //ajax사용시엔 꼭 써야하는 어노테이션
	@RequestMapping(value="idcheck.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String idcheck(String id) { //id는 ajax를 통해 들어오는 데이타
		//logger.info("MemberController 아이디체크 메소드 실행됨 " + new Date());
		
		System.out.println("id: "+id);
		
		//
		boolean isID = memberService.idcheck(id);
		
		String str = "";
		if(isID == false){	// id있음
			str="A user with the specified ID already exists. Please choose a different one.";
		} else {
			str = "good";
		}
		
	
		
		
		return str; //
		
	}
	

	@RequestMapping(value = "regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDto dto) {
		//logger.info("regiAf " + new Date());
		
		boolean b = memberService.addmember(dto);
		if(b) {
			logger.info("회원 가입되었습니다 " + new Date());
			return "login";
		}
		logger.info("가입되지 않았습니다 " + new Date());
		
		return "regi";
	}
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		//logger.info("loginAf " + new Date());
		String str="";
		MemberDto mem = memberService.login(dto);
		logger.info(mem.toString());
		if(mem != null && !mem.getId().equals("")) {
			logger.info("로그인 성공 " + new Date());
			req.getSession().setAttribute("login", mem);
			str = "main";
		} 
		else {
			logger.info("로그인 실패 " + new Date());
			str =  "login";
			//return "redirectMove"; //alert만 뿌려지는 jsp
		}
		
		return str;

	}
	@RequestMapping(value="main.do", method = RequestMethod.GET)	
	public String main() {
		//logger.info("MemberController main 메소드 실행됨 " + new Date());
		
		return "main";		
	}
	//컨트롤러에서 컨트롤러로 이동할때는 "redirect:/bbslist.do";
}
