package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model) {		
		model.addAttribute("doc_title", "글목록");
		return "bbslist.tiles";
	}

	@ResponseBody
	@RequestMapping(value = "bbslistData.do", method = RequestMethod.GET)
	public List<BbsDto> bbslistData(BbsParam param) {		
		
		// paging 처리
		int sn = param.getPage();
		int start = sn * 10 + 1;	// 1 	11
		int end = (sn + 1) * 10; 	// 10   20
		
		param.setStart(start);
		param.setEnd(end);
				
		List<BbsDto> list = service.getBbslist(param);		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "bbslistCount.do", method = RequestMethod.GET)
	public int bbslistCount(BbsParam param) {
		int count = service.getBbsCount(param);
		return count;
	}
	@ResponseBody
	@RequestMapping(value = "searchAf.do", method = RequestMethod.GET)
	public String searchAf(BbsParam param, Model model) {
		List<BbsDto> list = service.getBbslist(param);	
		int count = service.getBbsCount(param);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "bbslist.tiles";
	}
}







