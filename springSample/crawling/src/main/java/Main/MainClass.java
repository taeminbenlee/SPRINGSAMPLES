package Main;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) throws Exception{
	
		//Jsoup : 각종 사이트에서 데이트를 취합할 수 있는 라이브러리
		
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
		
		
		//영화제목을 가져오자
		/*
		<div class="box-contents">
        <a href="/movies/detail-view/?midx=84514">
            <strong class="title">내일의 기억</strong>
		*/
		
		//예매율
		/*
		 * <div class="score"> <strong class="percent">예매율<span>7.6%</span></strong>
		 * <!-- 2020.05.07 개봉전 프리에그 노출, 개봉후 골든에그지수 노출변경 (적용 범위1~ 3위)--> <div
		 * class='egg-gage small'> <span class='egg great'></span> <span
		 * class='percent'>94%</span> </div> </div>
		 */
		
		
		
		Elements titles = doc.select("div.box-contents strong.title");
		
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		for(int i=0; i<7; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			
			
			String t = title.text();
			String p = percent.text();
			System.out.println(t);
			System.out.println(p);
		}
		
		
	
		
		
		
		
	}

}
