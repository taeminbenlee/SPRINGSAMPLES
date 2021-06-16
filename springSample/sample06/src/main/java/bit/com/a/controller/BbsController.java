package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping(value="bbslist.do", method = RequestMethod.GET)	
	public String bbslist(Model model, HttpServletRequest req) {
		//logger.info("bbsController bbslist() " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		
		model.addAttribute("list", list);
		req.setAttribute("content", "bbslist");
		return "main";
		
	}
	
	@RequestMapping(value="bbspagingsearchlist.do", method = RequestMethod.GET)
	public String bbspaginglist(Model model, BbsParam bbs, HttpServletRequest req) {
		//logger.info("bbsController bbspaginglist() " + new Date());
		
		int start, end;
		start = 1+10 * bbs.getpageNumber();
		end = 10 + 10 * bbs.getpageNumber();
		
		bbs.setStart(start);
		bbs.setEnd(end);
		
		List<BbsDto> list = bbsService.getBbsPagingList(bbs);
		
		
		int bbsPage = bbsService.getAllBbs(bbs);
		System.out.println("bbsPage:" + bbsPage);
		
		
		model.addAttribute("bbsPage", bbsPage);
		model.addAttribute("pageNumber", bbs.getpageNumber());
		model.addAttribute("list", list);
		req.setAttribute("content", "./bbs/bbslist");
		
		return "main";
	
	}
	
	@RequestMapping(value="bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(Model model, int seq, HttpServletRequest req) {
		//logger.info("bbsController bbsdetail() " + new Date());
		seq = Integer.parseInt(req.getParameter("seq").trim());
		
		BbsDto dto = bbsService.getBbsDetail(seq);
		
		
		model.addAttribute("detail", dto);
		req.setAttribute("content", "./bbs/bbsdetail");
		
		return "main";
		
	}
	@RequestMapping(value="bbswrite.do", method = RequestMethod.GET)
	public String bbswrite(HttpServletRequest req) {
		//logger.info("bbsController bbswrite() " + new Date());
		req.setAttribute("content", "./bbs/bbswrite");
		
		return "main";
	}
	
	
	@RequestMapping(value="writeAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbswriteAf(BbsDto dto, HttpServletRequest req) {
		//logger.info("bbsController writeAf() " + new Date());
		
		boolean b = bbsService.bbsWriteAf(dto);
		if(b) {
			logger.info("글쓰기 성공 " + new Date());
			return "redirect:/bbspagingsearchlist.do";
		} else {
		logger.info("글쓰기 실패 " + new Date());
		return "redirect:/bbspagingsearchlist.do";
		}
	}
	
	
	@RequestMapping(value="bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(Model model, int seq, HttpServletRequest req) {
		//logger.info("bbsController bbsupdate() " + new Date());
		
		BbsDto dto = bbsService.getBbsDetail(seq);
		model.addAttribute("detail", dto);
		req.setAttribute("content", "./bbs/bbsupdate");
		
		return "main";
	}
	@RequestMapping(value="updateAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateAf(BbsDto dto, HttpServletRequest req) {
		//logger.info("bbsController updateAf() " + new Date());
		
		boolean b = bbsService.bbsUpdateAf(dto);
		if(b) {
			logger.info("글수정 성공 " + new Date());
			return "redirect:/bbspagingsearchlist.do";
		} else {
		logger.info("글수정 실패 " + new Date());
		return "redirect:/bbspagingsearchlist.do";
		}
	}
	
	@RequestMapping(value="bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, HttpServletRequest req) {
		//logger.info("bbsController deleteBbs() " + new Date());
		
		boolean b = bbsService.deleteBbs(seq);
		if(b) {
			logger.info("글삭제 성공 " + new Date());
			return "redirect:/bbspagingsearchlist.do";
		} else {
		logger.info("글삭제 실패 " + new Date());
		return "redirect:/bbspagingsearchlist.do";
		}
	}
	@RequestMapping(value="toAnswer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String toAnswer(Model model, int seq, HttpServletRequest req) {
		//logger.info("bbsController toAnswer() " + new Date());
		BbsDto dto = bbsService.getBbsDetail(seq);
		model.addAttribute("detail", dto);
		
		req.setAttribute("content", "./bbs/bbsanswer");
		
		return "main";	
	}
	
	@RequestMapping(value="answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(int seq, BbsDto dto, HttpServletRequest req) {
			//logger.info("bbsController answerAf() " + new Date());
		
		boolean b = bbsService.answerAf(seq, dto);
		if(b) {
			logger.info("답글쓰기 성공 " + new Date());
			return "redirect:/bbspagingsearchlist.do";
		} else {
		logger.info("답글쓰기 실패 " + new Date());
		return "redirect:/bbspagingsearchlist.do";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
