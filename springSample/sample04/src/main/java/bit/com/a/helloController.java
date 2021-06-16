package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.Human;

@Controller
public class helloController {
	
	private static Logger logger = LoggerFactory.getLogger(helloController.class);
	@RequestMapping("hello.do")
	public String helloMethod() {
		//System.out.println("helloController helloMethod()");
		logger.info("어휴"+  new Date());
		return "hello";		//hello.jsp로 이동
	}
	
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("helloController home() "+ new Date());
		
		String name = "홍길동";
		model.addAttribute("_name", name);
		
		return "home";
		
	}
	
	
	
}













