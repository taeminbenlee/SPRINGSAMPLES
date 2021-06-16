package bit.com.a.member;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {	
		return "login.tiles";
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "getId.do", method = RequestMethod.POST)
	public String getId(MemberDto mem) {	
		
		int count = service.getId(mem);
		String msg = "";
		if(count > 0) {
			msg = "YES";
		}else {
			msg = "NO";
		}
		return msg;
	}
	
	@RequestMapping(value = "regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDto dto) {		
		
		boolean b = service.addmember(dto);
		if(b) {
			System.out.println("회원 가입되었습니다 " + new Date());
			return "login.tiles";
		}
		System.out.println("가입되지 않았습니다 " + new Date());
		
		return "regi.tiles";
	}
	
	@RequestMapping(value = "loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		
		MemberDto login = service.login(dto);
		if(login != null && !login.getId().equals("")) {
			
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60*60*20);
			
			return "redirect:/bbslist.do";			
		}
		else {			
			return "redirect:/login.do";
		}
		
		
	}
	
	
	
	@RequestMapping(value = "logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout() {
		return "login.tiles";
	}
	
	@RequestMapping(value="sessionOut.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String sessionOut() {
		return "sessionOut.tiles";
	}
}








