package bit.com.a.controller;

import java.util.Date;
import java.util.List;

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
	
	@RequestMapping(value="/dbtest", method = {RequestMethod.GET, RequestMethod.POST})
	public List<MemberDto> dbtest(){
		System.out.println("MemberController dbtest() " + new Date());
		List<MemberDto> list = service.allMember();
		return list;
	}
	
}
