package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getBbslist(BbsParam bbs);
	int getBbsCount(BbsParam bbs);
	boolean bbsWriteAf(BbsDto dto);
	BbsDto getBbs(int seq);
	boolean bbsanswerAf(BbsDto dto, int seq);
	boolean deleteBbs(int seq);
	boolean updateBbs(BbsDto bbs);
	
	
}
