package bit.com.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketController {
	
	@RequestMapping(value = "chatting.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String chatting(Model model) {
		model.addAttribute("doc_title", "chatting");
		
		return "chatting.tiles";
	}
}
