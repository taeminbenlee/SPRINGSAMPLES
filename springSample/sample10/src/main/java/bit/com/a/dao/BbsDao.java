package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {

	List<BbsDto> getBbslist(BbsParam bbs);	
	int getBbsCount(BbsParam bbs);
}
