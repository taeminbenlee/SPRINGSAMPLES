package dto;

import java.io.Serializable;

public class MovieVo implements Serializable{
	private String title;
	private double percent;
	
	public MovieVo() {
		
	}

	public MovieVo(String title, double percent) {
		super();
		this.title = title;
		this.percent = percent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "MovieVo [title=" + title + ", percent=" + percent + "]";
	}
	
	
}
