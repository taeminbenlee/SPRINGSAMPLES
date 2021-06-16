package bit.com.a.poll;

import java.io.Serializable;

public class Result implements Serializable{
	private int rid;
	private String rquestion;
	private String ranswer;
	private int racount;
	
	public Result() {}
	public Result(int rid, String rquestion, String ranswer, int racount) {
		super();
		this.rid = rid;
		this.rquestion = rquestion;
		this.ranswer = ranswer;
		this.racount = racount;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRquestion() {
		return rquestion;
	}
	public void setRquestion(String rquestion) {
		this.rquestion = rquestion;
	}
	public String getRanswer() {
		return ranswer;
	}
	public void setRanswer(String ranswer) {
		this.ranswer = ranswer;
	}
	public int getRacount() {
		return racount;
	}
	public void setRacount(int racount) {
		this.racount = racount;
	}
	@Override
	public String toString() {
		return "Result [rid=" + rid + ", rquestion=" + rquestion + ", ranswer=" + ranswer + ", racount=" + racount
				+ "]";
	}
	
	
}
