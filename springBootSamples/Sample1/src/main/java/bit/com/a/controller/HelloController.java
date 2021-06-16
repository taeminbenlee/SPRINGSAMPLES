package bit.com.a.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;

@RestController		//== @Controller + @Responsebody -> Restful
public class HelloController {
	
	
	
	//value에 / 만 주면 동작안한다.
	@RequestMapping(value="//", method = {RequestMethod.GET, RequestMethod.POST})
	public String base() {
		System.out.println("HelloController base() " + new Date());
		return "test";
	}
	
	
	@RequestMapping(value="/test", method = {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("HelloController test() " + new Date());
		return "test";
	}
	
	@RequestMapping(value="/member", method = {RequestMethod.GET, RequestMethod.POST})
	public MemberDto getMember() {
		System.out.println("HelloController getMember() " + new Date());
		MemberDto dto =new MemberDto("aaa", "111", "aaa","aaa@naver.com", 3);
		
		return dto;
		
	}
	
	@RequestMapping(value="/conn_param", method = {RequestMethod.GET, RequestMethod.POST})
	public String conn_param(String title) {
		System.out.println("HelloController conn_param() " + new Date());
		System.out.println("title: " + title);
		
		return "conn_success";
		
	}
	
	
	@RequestMapping(value="/conn_param_get", method = {RequestMethod.GET, RequestMethod.POST})
	public String conn_param_get(MemberDto dto) {
		System.out.println("HelloController conn_param() " + new Date());
		System.out.println(dto.toString());
		return "yes";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
