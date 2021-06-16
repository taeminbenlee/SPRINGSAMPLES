package bit.com.a.poll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;

@Controller
public class PollController {
	@Autowired
	PollService service;
	
	@RequestMapping(value = "polllist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String polllist(Model model, HttpServletRequest req) {
		model.addAttribute("doc_title", "투표목록");
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		
		List<PollDto> list = service.getPollAllList(id);
		
		model.addAttribute("plists", list);
		return "polllist.tiles";
		
	}
	
	@RequestMapping(value = "pollmake.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pollmake(Model model) {
		model.addAttribute("doc_title", "투표만들기");
		
		return "pollmake.tiles";
	}
	
	@RequestMapping(value = "pollmakeAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pollmakeAf(PollBean pbean) {
		service.makePoll(pbean);
		
		return "redirect:/polllist.do";
	}
	
	@RequestMapping(value = "polldetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String polldetail(Model model, PollDto poll ) {
		model.addAttribute("doc_title", "투표 내용");
		PollDto dto = service.getPoll(poll);
		List<PollSubDto> list = service.getPollSubList(poll);
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "polldetail.tiles";
	}
	
	@RequestMapping(value = "polling.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String polling(Voter voter) {
		service.polling(voter);
		return "redirect:/polllist.do";
	}
	
	@ResponseBody
	@RequestMapping(value = "preresult.do", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Result> pollresult2(int pollid, Model model) {
		
		
		List<Result> list = service.pollresult(pollid);
		
		
		
		return list;
	}
	
	@RequestMapping(value = "pollresult.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pollresult(Model model, PollDto poll) {
		model.addAttribute("doc_title", "투표 결과");
		//polltotal
		PollDto dto = service.getPoll(poll);
		//보기들(acount)
		List<PollSubDto> list = service.getPollSubList(poll);
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "pollresult.tiles";
	}
}

