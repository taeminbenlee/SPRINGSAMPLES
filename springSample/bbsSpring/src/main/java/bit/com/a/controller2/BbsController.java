package bit.com.a.controller2;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import bit.com.a.dto.BbsDto;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService bbsService;
	@RequestMapping(value="allBbs.do", method = RequestMethod.GET)
	public String allBbs(Model model) {
		logger.info("MemberController allmember " + new Date());
		
		List<BbsDto> list = bbsService.allBbs();
		
		model.addAttribute("bbslist", list);
		
		return "allBbs";
	}
}
