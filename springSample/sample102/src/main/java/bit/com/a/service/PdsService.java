package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;

public interface PdsService {

	List<PdsDto> getPdsList();
	boolean uploadPds(PdsDto dto);
	PdsDto getDetail(int seq);
	boolean deletePds(int seq);
	PdsDto downcount(int seq);
	boolean updateAf(PdsDto pdsdto);
	int getPdsCount(PdsParam param);
	List<PdsDto> getPdslist(PdsParam param);

}
