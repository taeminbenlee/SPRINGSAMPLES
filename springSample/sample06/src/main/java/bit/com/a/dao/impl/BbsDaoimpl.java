package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoimpl implements BbsDao {
	@Autowired			// -> new 	: Dependency Injection
	SqlSession sqlSession;
	
	String ns = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList() {
		return sqlSession.selectList(ns+"bbslist");
	}

	@Override
	public List<BbsDto> getBbsPagingList(BbsParam bbs) {
		return sqlSession.selectList(ns + "pagingsearchbbslist", bbs);
	}

	@Override
	public int getAllBbs(BbsParam bbs) {	
		return sqlSession.selectOne(ns + "getallbbs", bbs);
	}

	@Override
	public BbsDto getBbsDetail(int seq) {
		return sqlSession.selectOne(ns+"getBbsDetail", seq);
	}

	@Override
	public boolean bbsWriteAf(BbsDto dto) {
		int n = sqlSession.insert(ns+"add", dto );
		return n>0?true:false;
	}

	@Override
	public boolean bbsUpdateAf(BbsDto dto) {
		int n = sqlSession.update(ns+"bbsupdate", dto);
		return n>0?true:false;
	}

	@Override
	public boolean deleteBbs(int seq) {
		int n = sqlSession.update(ns+"bbsdelete", seq);
		return n>0?true:false;
	}

	@Override
	public boolean answerAf(int seq, BbsDto dto) {
		int n = sqlSession.update(ns+"bbsStepIncrease", seq);
			n =	sqlSession.insert(ns+"bbsanswer", dto);
		return n>0?true:false;
	}
	
}
