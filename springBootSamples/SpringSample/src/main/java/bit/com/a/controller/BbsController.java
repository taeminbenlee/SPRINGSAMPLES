package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	@Autowired
	BbsService service;
	
	
	@RequestMapping(value="/bbslistData", method = {RequestMethod.GET, RequestMethod.POST})
	public List<BbsDto> bbslistData(BbsParam param){
		System.out.println("BbsController bbslistData() " + new Date());
		// paging 처리
				int sn = param.getPage();
				int start = sn * 10 + 1;	// 1 	11
				int end = (sn + 1) * 10; 	// 10   20
				
				param.setStart(start);
				param.setEnd(end);
		List<BbsDto> list = service.bbslistData(param);
		//System.out.println(list.toString());
		
		
		return list;
		
	}
	
	@RequestMapping(value="/bbslistCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int bbslistCount(BbsParam param) {
		int count = service.bbslistCount(param);
		return count;
	}
	
	@RequestMapping(value="/bbsdetail", method = {RequestMethod.GET, RequestMethod.POST})
	public BbsDto bbsdetail(int seq) {
		BbsDto bbs = service.bbsdetail(seq);
		service.readcount(seq);
		return bbs;
	}
	
	@RequestMapping(value="/bbswriteAf", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbswriteAf(BbsDto dto) {
		
		boolean b = service.bbswriteAf(dto);
		if(b) {
			String msg = "글작성성공";
			return msg;
		} else {
			String msg = "글작성실패";
			return msg;
		}
	}
	
	@RequestMapping(value="/updateAf", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateAf(BbsDto dto) {
		boolean b = service.bbsupdateAf(dto);
		if(b) {
			System.out.println("수정성공");
			String msg = "수정성공";
			return msg;
		} else {
			String msg = "수정실패";
			return msg;
		}
	}
	@RequestMapping(value="/answerAf", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(BbsDto dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		boolean b = service.answerAf(dto);
		service.stepIncrease(dto);
		if(b) {
			System.out.println("답글메소드");
			String msg = "답글작성 성공";
			return msg;
		} else {
			String msg = "답글작성 실패";
			return msg;
		}
	}
	
}
