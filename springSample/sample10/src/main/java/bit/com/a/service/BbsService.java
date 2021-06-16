package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getBbslist(BbsParam bbs);
	int getBbsCount(BbsParam bbs);
}
