package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao dao;
	
	@Override
	public List<BbsDto> getBbslist(BbsParam bbs) {		
		return dao.getBbslist(bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {		
		return dao.getBbsCount(bbs);		
	}

	@Override
	public boolean bbsWriteAf(BbsDto dto) {
		return dao.bbsWriteAf(dto);	
	}

	@Override
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public boolean bbsanswerAf(BbsDto dto, int seq) {
		return dao.bbsanswerAf(dto, seq);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}

	@Override
	public boolean updateBbs(BbsDto bbs) {

		return dao.updateBbs(bbs);
	}

	


	

	
}





