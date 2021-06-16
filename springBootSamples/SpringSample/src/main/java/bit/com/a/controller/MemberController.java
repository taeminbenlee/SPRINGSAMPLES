package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/loginAf", method = {RequestMethod.GET, RequestMethod.POST})
	public MemberDto loginAf(String id, String pwd, HttpServletRequest req) {
		System.out.println("MemberController login() " + new Date());
	
		MemberDto login = service.loginAf(id, pwd);
		
		if(login != null && !login.getId().equals("")) {
			//req.getSession().setAttribute("login", login);
			//req.getSession().setMaxInactiveInterval(60*60*20);
			
			return login;			
		}
		else {		
		
			return login;
		}
		
		
		
	}
	
	@RequestMapping(value="/idcheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idcheck(String id) {
		System.out.println("MemberController idcheck() " + new Date());
		int count = service.idcheck(id);
		String msg = "";
		if(count > 0) {		//아이디가 잇음
			msg = "사용할수없는 아이디";
		}else {				//없음 사용가능
			msg = "사용 가능한 아이디";
		}
		return msg;
		
	}
	
	@RequestMapping(value="/regiAf", method = {RequestMethod.GET, RequestMethod.POST})
	public String regiAf(MemberDto dto) {
		System.out.println("MemberController regiAf() " + new Date());
		
		
			
			
		boolean b = service.addmember(dto);
		String msg = "";
		if(b) {
			System.out.println("회원 가입되었습니다 " + new Date());
			msg = "회원가입 성공";
		} else {
		System.out.println("가입되지 않았습니다 " + new Date());
		msg = "회원가입 실패";
		}
		return msg;
		
	}
	
}
