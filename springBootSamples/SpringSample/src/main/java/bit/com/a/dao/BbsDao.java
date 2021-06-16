package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {

	List<BbsDto> bbslistData(BbsParam param);

	int bbslistCount(BbsParam param);

	BbsDto bbsdetail(int seq);

	void readcount(int seq);

	boolean bbswriteAf(BbsDto dto);

	boolean bbsupdateAf(BbsDto dto);

	boolean answerAf(BbsDto dto);

	void stepIncrease(BbsDto dto);

}
