package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
public class BbsServiceimpl implements bit.com.a.service.BbsService {
	@Autowired
	BbsDao bbsDao;
	@Override
	public List<BbsDto> getBbsList() {
		
		return bbsDao.getBbsList();
	}
	@Override
	public List<BbsDto> getBbsPagingList(BbsParam bbs) {
		
		return bbsDao.getBbsPagingList(bbs);
	}
	@Override
	public int getAllBbs(BbsParam bbs) {
		return bbsDao.getAllBbs(bbs);
	}
	@Override
	public BbsDto getBbsDetail(int seq) {
	
		return bbsDao.getBbsDetail(seq);
	}
	@Override
	public boolean bbsWriteAf(BbsDto dto) {
		
		return bbsDao.bbsWriteAf(dto);
	}
	@Override
	public boolean bbsUpdateAf(BbsDto dto) {
		return bbsDao.bbsUpdateAf(dto);
	}
	@Override
	public boolean deleteBbs(int seq) {
		return bbsDao.deleteBbs(seq);
	}
	@Override
	public boolean answerAf(int seq, BbsDto dto) {
		return bbsDao.answerAf(seq, dto);
	}

}
