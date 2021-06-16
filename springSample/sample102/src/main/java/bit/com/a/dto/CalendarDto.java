package bit.com.a.dto;

import java.io.Serializable;

public class CalendarDto implements Serializable {
	
	private int seq;
	private String id;
	private String title;
	private String mycontent;
	private String startdate;
	private String enddate;
	private String wdate;		//작성일
	
	public CalendarDto() {
		
	}

	public CalendarDto(int seq, String id, String title, String mycontent, String startdate, String enddate,
			String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.mycontent = mycontent;
		this.startdate = startdate;
		this.enddate = enddate;
		this.wdate = wdate;
	}

	public CalendarDto(String id, String title, String mycontent, String startdate, String enddate, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.mycontent = mycontent;
		this.startdate = startdate;
		this.enddate = enddate;
		this.wdate = wdate;
	}
	
	public CalendarDto(int seq, String title, String mycontent, String startdate, String enddate) {
		super();
		this.seq = seq;
		this.title = title;
		this.mycontent = mycontent;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return mycontent;
	}

	public void setContent(String content) {
		this.mycontent = content;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "CalendarDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + mycontent + ", startdate="
				+ startdate + ", enddate=" + enddate + ", wdate=" + wdate + "]";
	}

	
}
