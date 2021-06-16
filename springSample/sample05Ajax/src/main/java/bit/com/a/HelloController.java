package bit.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MyClass;
import bit.com.a.dto.human;



@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	/* 1 */
	@RequestMapping(value="hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("헬로콘트롤러 헬로 메소드 실행됨 " + new Date());
		
		MyClass cls = new MyClass(1001, "홍길동");
		model.addAttribute("mycls", cls);
		
		return "hello"; //함수명과 이후에 들어가는 jsp파일명은 달라도 되지만 되도록 맞추어준다.
	}

	/* 2 jsp랑 데이터 주고받기*/
	@RequestMapping(value="move.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String world(Model model, MyClass mycls) {
		logger.info("헬로콘트롤러 무브 메소드 실행됨 " + new Date());
		
		System.out.println(mycls.toString());
	
		model.addAttribute("mycls", mycls);
		return "hello";
		
	}
	
	/* 3 Ajax 활용 데이터 전송*/
	@ResponseBody //ajax사용시엔 꼭 써야하는 어노테이션
	@RequestMapping(value="idcheck.do", method = {RequestMethod.GET, RequestMethod.POST}, 
	produces = "application/String; charset=utf-8")
	public String idcheck(String id) { //id는 ajax를 통해 들어오는 데이타
		logger.info("헬로콘트롤러 아이디체크 메소드 실행됨 " + new Date());
		System.out.println("id: "+id);
		
		//나가는 데이타
		String str = "오또케이";
		
		
		return str; //
		
	}
	
	/* 4 */
	@ResponseBody
	@RequestMapping(value="account.do", method = {RequestMethod.GET, RequestMethod.POST},
	produces = "application/String; charset=utf-8")
	public Map<String, Object> account(human h) {
		logger.info("헬로콘트롤러 어카운트 메소드 실행됨 " + new Date());

		System.out.println(h.toString());
		
		//DB접근
		//날려줄 맵 준비!
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "message sample");
		 map.put("name", "성춘향");
		
		return map;
		
		
	}
	
	/* 5 */
	@ResponseBody
	@RequestMapping(value="dataread.do", method = {RequestMethod.GET, RequestMethod.POST})
	public List<human> dataread(){
		logger.info("헬로콘트롤러 데이터리드 메소드 실행됨 " + new Date());
		
		
		List<human>list = new ArrayList();
		list.add(new human("김종훈","123","234","456"));
		list.add(new human("박종훈","123","234","456"));
		list.add(new human("방종훈","123","234","456"));
		
		
		return list;
		
	}
	
	
}
