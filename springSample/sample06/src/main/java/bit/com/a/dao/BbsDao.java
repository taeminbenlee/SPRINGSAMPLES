package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {
	List<BbsDto> getBbsList();
	List<BbsDto> getBbsPagingList(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
	BbsDto getBbsDetail(int seq);
	boolean bbsWriteAf(BbsDto dto);
	boolean bbsUpdateAf(BbsDto dto);
	boolean deleteBbs(int seq);
	boolean answerAf(int seq, BbsDto dto);
}
