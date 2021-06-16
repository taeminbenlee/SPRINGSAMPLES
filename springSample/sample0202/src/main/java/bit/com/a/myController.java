package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.human;

@Controller
public class myController {
	private static Logger logger = LoggerFactory.getLogger(myController.class);
	@RequestMapping(value="homooo.do", method = RequestMethod.GET)
	public String helloMethod(Model model) {
		System.out.println("ddddddddddddddddddController helloMethod()");
		logger.info("어휴"+  new Date());
		String name = "홍길동";
		model.addAttribute("_name", name);
		
		return "homooo";		//hello.jsp로 이동
	}
	@RequestMapping(value="newboy.do", method=RequestMethod.GET)
	public String info(human ham) {
		logger.info("info로 넘어옴"+ new Date());
		System.out.println(ham.toString());
		return "info";
	}
}
