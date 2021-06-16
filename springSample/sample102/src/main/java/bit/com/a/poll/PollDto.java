package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

public class PollDto implements Serializable {
	
	//투표 질문, 질의, 주제,
	private int pollid;	//sequence 투표번호
	private String id;	//투표만든 사람의 아이디 - 맴버에서 오는???
	private String question; //질문(투표 주제)
	private Date sdate;	//투표시작일
	private Date edate;	//투표종료일
	private Date regdate;	//투표만든날
	
	
	private int itemcount;	//보기수 -> 2 ~ 10
	private int polltotal;	//항목에 투표를 한 사람의 수
	private boolean vote;	//투표를 했는지 안했는지?
	
	public PollDto() {}

	public PollDto(int pollid, String id, String question, Date sdate, Date edate, Date regdate, int itemcount,
			int polltotal, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.regdate = regdate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.vote = vote;
	}

	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public Date getregdate() {
		return regdate;
	}

	public void setregdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPolltotal() {
		return polltotal;
	}

	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "PollDto [pollid=" + pollid + ", id=" + id + ", question=" + question + ", sdate=" + sdate + ", edate="
				+ edate + ", regdate=" + regdate + ", itemcount=" + itemcount + ", polltotal=" + polltotal + ", vote="
				+ vote + "]";
	}
	
	
	
	
	
}
