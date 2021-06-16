package bit.com.a.util;

import java.util.Date;

public class PdsUtil {
	//파일명 변경 -> time
	
	//myfile.txt -> f.indexOf('.') -> 6
	//파일명(바꿈), 확장자명(안바꿈) -> 분리시켜줌
	//f.substring(6) -> .txt
	//f.substring(0, 6) -> myfile
	
	
	//확장자명을 유지하고 파일명만 (newfilename)시간으로 바까주는 함수. 
	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.lastIndexOf('.')>=0) { //확장자명이 있다!!
			fpost = f.substring(f.lastIndexOf('.')); // .txt
			filename = new Date().getTime() + fpost;	//123456789.txt
		}else {
			filename = new Date().getTime() + ".back";	//확장자명이 없으면 내가 임의로 붙여버림
		}
		return filename;
	}
	
	
	
	
	
}
