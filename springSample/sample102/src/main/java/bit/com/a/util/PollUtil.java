package bit.com.a.util;

import java.util.Calendar;
import java.util.Date;

public class PollUtil {
	
	//달력의 날짜를 20210426형식으로 만드는 함수
	public static String StringCal(Calendar dd) {
		String s = "";
		int year = dd.get(Calendar.YEAR);
		int month = dd.get(Calendar.MONTH) + 1;
		int day = dd.get(Calendar.DATE);
		
		s = year + "" + UtilEx.two(month + "") + UtilEx.two(day + "");
		
		return s;
	}
	
	// 연월일을 비교. 투표가 끝났는지.? 오늘 > 종료일 == 투표마감.. 즉 오늘날짜와 비교하는 함수
	public static boolean isEnd(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		Calendar now = Calendar.getInstance();
		//오늘이 마감일보다 큰지?
		
		boolean b = Integer.parseInt(StringCal(now)) > Integer.parseInt(StringCal(c));
		return b;
		
	}
	
	//투표 종료의 판별위한 문자열
	public static String pollState(Date d) {
		String s1 = "<div style='color:RED'>[종료]</div>";
		String s2 = "<div style='color:BLUE'>[진행중]</div>";
		return isEnd(d)?s1:s2;
	}
	
	
	
	
}
