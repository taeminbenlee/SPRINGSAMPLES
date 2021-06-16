package bit.com.a.poll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {
	@Autowired
	PollDao dao;

	@Override
	public List<PollDto> getPollAllList(String id) {
		//모든 투표 목록을 갖고 온다
		List<PollDto> list = dao.getPollAllList();
		//편집을 해서 투표가 가능한지 설정한후 넘겨줄 리스트
		List<PollDto> plist = new ArrayList<PollDto>();
		
		for (PollDto poll : list) {
			int pollid = poll.getPollid(); //투표번호 알아내기
			//isVote에 pollid랑 id만 필요하기때문에 가운데는 0을 넣어준다...(의미없음)
			int count = dao.isVote(new Voter(pollid, 0, id)); //여기서 카운트가 1 이면 투표한거임
			if(count == 1) {
				poll.setVote(true);
				
			} else {
				poll.setVote(false);
			}
			plist.add(poll);
			
		}
		return plist;
		
	}

	@Override
	public void makePoll(PollBean pbean) {
		//투표 주제
		PollDto poll = new PollDto(pbean.getId(), 
									pbean.getQuestion(), pbean.getSdate(),
									pbean.getEdate(), pbean.getItemcount(), 0);
		
		dao.makePoll(poll);
		
		//투표 보기
		String answer[] = pbean.getPollnum();
		
		for(int i =0; i<pbean.getItemcount(); i++) {
			PollSubDto pollsub = new PollSubDto();
			pollsub.setAnswer(answer[i]);
			
			dao.makePollSub(pollsub);
		}
		
	}

	@Override
	public PollDto getPoll(PollDto poll) {
		return dao.getPoll(poll);
	}

	@Override
	public List<PollSubDto> getPollSubList(PollDto poll) {
		return dao.getPollSubList(poll);
	}

	@Override
	public void polling(Voter voter) {
		
		dao.pollingVoter(voter);
		dao.pollingPoll(voter);
		dao.pollingSub(voter);
		
	}

	@Override
	public List<Result> pollresult(int pollid) {
		return dao.pollresult(pollid);
	}
	
	
	
	
	
	
}
