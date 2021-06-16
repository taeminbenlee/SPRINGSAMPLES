package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {
	@Autowired
	BbsDao dao;
	public List<BbsDto> bbslistData(BbsParam param) {
		return dao.bbslistData(param);
	}
	public int bbslistCount(BbsParam param) {
		return dao.bbslistCount(param);
	}
	public BbsDto bbsdetail(int seq) {
		return dao.bbsdetail(seq);
	}
	public void readcount(int seq) {
		dao.readcount(seq);
	}
	public boolean bbswriteAf(BbsDto dto) {
		return dao.bbswriteAf(dto);
	}
	public boolean bbsupdateAf(BbsDto dto) {
		return dao.bbsupdateAf(dto);
	}
	public boolean answerAf(BbsDto dto) {
		return dao.answerAf(dto);
	}
	public void stepIncrease(BbsDto dto) {
		dao.stepIncrease(dto);
	}

}
