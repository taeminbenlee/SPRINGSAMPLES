package bit.com.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {
	
	@RequestMapping(value = "gamelist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String gamelist(Model model) {		
		model.addAttribute("doc_title", "게임");
		return "game.tiles";
	}
	
	@RequestMapping(value = "tetris.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String tetris(Model model) {	
		model.addAttribute("doc_title", "테트리스");
		return "tetris.tiles";
	}
	
	@RequestMapping(value = "break.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String breaktheblocks(Model model) {		
		model.addAttribute("doc_title", "벽돌부시기");
		return "breaktheblocks.tiles";
	}
	@RequestMapping(value = "bird.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bird(Model model) {		
		model.addAttribute("doc_title", "새날리기");
		return "bird.tiles";
	}
	@RequestMapping(value = "car.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String car(Model model) {		
		model.addAttribute("doc_title", "안전운전");
		return "car.tiles";
	}
	
	@RequestMapping(value = "Onoff.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String onoff(Model model) {		
		model.addAttribute("doc_title", "onoff");
		return "onoff.tiles";
	}
	
}
