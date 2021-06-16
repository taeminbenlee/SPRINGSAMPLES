package bit.com.a.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
@Aspect
public class LogAop {
	
	@Around("within(bit.com.a.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable {
		//dto의 cat클래스안의 어떤 메소드든 호출되면 aop설정 자동호출로 인해서 이넘이 호출됨
		
		String signatureStr = joinpoint.getSignature().toShortString(); //함수명 출력하는???
		
		//System.out.println("signatureStr"+signatureStr+"시작~");
		
		try {
			Object obj = joinpoint.proceed(); //실행시
			
			System.out.println("loggerAOP: "+ signatureStr+ "메소드가 실행됨" + new Date());
			
			
			
			return obj;
			
		}finally {
			//System.out.println("실행후~ :"+System.currentTimeMillis());
			//System.out.println("signatureStr"+signatureStr+"종료"); //실행후

		}
	}
	
	
	
	
	
	
	
}
