package bit.com.a.controller;

import java.util.Date;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;



@Controller
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="allMember.do", method = RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController allmember " + new Date());
		
		List<MemberDto> list = memberService.allMember();
		
		model.addAttribute("memlist", list);
		
		return "allMember";
	}
	
	
}
