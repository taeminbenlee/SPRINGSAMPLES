package bit.com.a.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component	//생성해 놓는다 오토와이어로 콘트롤러에서 생성된 것을 불러올수잇다
public class YoutubeParser {
	
	String urls = "https://www.youtube.com/results?search_query="; //유튜브 검색부분의 url경로
	
	public String search(String s) {
		//s는 검색어 받은것
		System.out.println("콘트롤러에서 넘어온 것:  "+s);
		BufferedReader br = null;
		String str = "";
		
		try {
			String ss = URLEncoder.encode(s, "utf-8"); //검색어 한글깨짐방지해주고 ss에 넣어줌
			
			
				URL url = new URL(urls + ss);
				br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
				
				String msg = "";
				String text = "";
				
				while((msg = br.readLine())!=null) {
					text += msg.trim();
				}
				
				//System.out.println(text);
				
				//시작위치
				int pos = text.trim().indexOf("\"responseContext\"");
				//끝위치
				int endpos = text.indexOf("};", pos);
				
				str = text.substring(pos -1, endpos +1);
				//System.out.println(str);
				str = str.replace("\"", "\\\""); 	// " -> \"
				str = str.replace("\'", "\\\'");	//	' -> \'
				
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	
	
	
	
}
