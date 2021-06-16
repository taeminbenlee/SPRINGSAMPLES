package movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class MovieChart {
	
	
	public static List<MovieVo> getCGVData() throws IOException{
		
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
		//제목
		Elements titles = doc.select("div.box-contents strong.title");
		//예매율
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		for(int i=0; i<7; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			
			
			String t = title.text();
			String p = percent.text();
			//System.out.println(t);
			//System.out.println(p);
			
			MovieVo vo = new MovieVo();
			
			double pv = Double.parseDouble(p.replace("%", ""));
			
			vo.setTitle(t);
			vo.setPercent(pv);
			
			list.add(vo);
			
		}
		return list;
		
	}
}
