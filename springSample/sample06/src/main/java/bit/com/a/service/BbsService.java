package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {
	List<BbsDto> getBbsList();

	List<BbsDto> getBbsPagingList(BbsParam bbs);

	int getAllBbs(BbsParam bbs);

	BbsDto getBbsDetail(int seq);

	boolean bbsWriteAf(BbsDto dto);

	boolean bbsUpdateAf(BbsDto dto);

	boolean deleteBbs(int seq);

	boolean answerAf(int seq, BbsDto dto);
}
