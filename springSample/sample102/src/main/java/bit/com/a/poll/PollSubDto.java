package bit.com.a.poll;

import java.io.Serializable;

public class PollSubDto implements Serializable {
	//투표 보기, 초이스
	
		private int pollsubid;	//보기번호(초이스번호)
		private int pollid;	//polldto의 pollid(어떤 질문의 어떤 답이냐를 알기 위함)
		private String answer;	//초이스 명
		private int acount;	//answer count == 해당 답을 선택한 사람의 수
		
		public PollSubDto() {}

		public PollSubDto(int pollsubid, int pollid, String answer, int acount) {
			super();
			this.pollsubid = pollsubid;
			this.pollid = pollid;
			this.answer = answer;
			this.acount = acount;
		}

		public int getPollsubid() {
			return pollsubid;
		}

		public void setPollsubid(int pollsubid) {
			this.pollsubid = pollsubid;
		}

		public int getPollid() {
			return pollid;
		}

		public void setPollid(int pollid) {
			this.pollid = pollid;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public int getAcount() {
			return acount;
		}

		public void setAcount(int acount) {
			this.acount = acount;
		}

		@Override
		public String toString() {
			return "PollSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", acount="
					+ acount + "]";
		}
		
		
}
