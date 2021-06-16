package bit.com.a.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.dto.MemberDto;

@Aspect
public class LogAop {
	
	@Around("within(bit.com.a.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		//session check
		//세션이 비었는제 체크후 비었으면 로그인.두로 보내주자 리퀘스트로 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		if(request != null ) {
			
			HttpSession session = request.getSession();
			MemberDto login = (MemberDto)session.getAttribute("login");
			if(login==null) {
				return "redirect:/sessionOut.do";
			}
		}
		// System.out.println(signatureStr + "시작");
		
		try {
			Object obj = joinpoint.proceed();	// 실행시
			
			System.out.println("loggerAOP:" + signatureStr + " 메소드가 실행 " + new Date());
			
			return obj;
			
			
		}finally {
		//	System.out.println("실행 후:" + System.currentTimeMillis());
		//	System.out.println(signatureStr + "종료");	// 실행후
		}		
	}

}









