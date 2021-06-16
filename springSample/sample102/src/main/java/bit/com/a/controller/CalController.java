package bit.com.a.controller;


import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.CalendarDto;

import bit.com.a.dto.MemberDto;
import bit.com.a.dto.calParam;
import bit.com.a.service.CalService;



@Controller
public class CalController {
	@Autowired
	CalService service;
	
	
	
	
	@RequestMapping(value = "callist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String callist(Model model) {
		model.addAttribute("doc_title", "일정목록");

		return "callist.tiles";
	}
	
	@RequestMapping(value = "showSchedule.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showSchedule(String id, Model model, HttpServletRequest req){
		MemberDto dto = (MemberDto)req.getSession().getAttribute("login");
		model.addAttribute("doc_title", "일정목록");
		List<CalendarDto> list = service.showSchedule(dto.getId());
		model.addAttribute("list", list);
		//System.out.println(list.toString());
		return "callist.tiles";
	}
	
	@RequestMapping(value = "calwriteAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String calwriteAf(CalendarDto dto, HttpServletRequest req) {
		
		
		boolean b = service.calWriteAf(dto);
		if(b) {
			
			return "redirect:/showSchedule.do";
		} else {
		
		return "redirect:/showSchedule.do";
		}
	}
	@RequestMapping(value = "calUpdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String calUpdateAf(CalendarDto dto, HttpServletRequest req) {
		boolean b = service.calUpdateAf(dto);
		if(b) {
			System.out.println("수정성공");
			return "redirect:/showSchedule.do";
		} else {
		System.out.println("수정실패");
		return "redirect:/showSchedule.do";
		}
		
		
	}
	
	@RequestMapping(value = "calDelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String calDelete(CalendarDto dto) {
		boolean b = service.calDelete(dto);
		if(b) {
			System.out.println("수정성공");
			return "redirect:/showSchedule.do";
		} else {
		System.out.println("수정실패");
		return "redirect:/showSchedule.do";
		}
	}
	@ResponseBody
	@RequestMapping(value = "calSearch.do", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CalendarDto> calSearchAf(calParam param, Model model, HttpServletRequest req) {
		List<CalendarDto> lista = service.searchAf(param);
		
		model.addAttribute("list", lista);
		System.out.println(lista.toString());
		return lista;
		
	}
	
	
	
}

