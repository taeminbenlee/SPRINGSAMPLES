package bit.com.a.controller;

import java.util.Date;

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
	
	// MemberService
	@Autowired	// DI IOC
	MemberService memberService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("MemberController login() " + new Date());
		return "login";
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi() " + new Date());
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck.do", method=RequestMethod.POST)
	public String idcheck(MemberDto mem) {
		logger.info("getId " + new Date());
		logger.info(mem.toString());
		
		int count = memberService.getId(mem);
		
		logger.info("count = " + count);
		String msg = "";
		if(count > 0) {
			msg = "NO";
		}else {
			msg = "YES";
		}
		return msg;
	}
	
	@RequestMapping(value = "regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDto dto) {
		logger.info("regiAf " + new Date());
		
		boolean b = memberService.addmember(dto);
		if(b) {
			logger.info("회원 가입되었습니다 " + new Date());
			return "login";
		}
		logger.info("가입되지 않았습니다 " + new Date());
		
		return "regi";
	}
	
}







