package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

public class Voter implements Serializable {
	//투표자
	
	private int voterid;
	private int pollid;	//어떤 질문에 
	private int pollsubid;	//어떤 답을 하엿는지
	private String id; //누구?
	private Date regdate;
	
	
	public Voter() {}


	public Voter(int voterid, int pollid, int pollsubid, String id, Date regdate) {
		super();
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}

	//시퀀스와 레지데이트(시스데이트)뺀 나머지
	public Voter(int pollid, int pollsubid, String id) {
		super();
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
	}


	public int getVoterid() {
		return voterid;
	}


	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}


	public int getPollid() {
		return pollid;
	}


	public void setPollid(int pollid) {
		this.pollid = pollid;
	}


	public int getPollsubid() {
		return pollsubid;
	}


	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getregdate() {
		return regdate;
	}


	public void setregdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
