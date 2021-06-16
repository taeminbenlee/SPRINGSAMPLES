package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Bbs.";
		
	@Override
	public List<BbsDto> getBbslist(BbsParam bbs) {		
		return session.selectList(ns + "bbslist", bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {		
		return session.selectOne(ns + "getBbsCount", bbs);
	}

	@Override
	public boolean bbsWriteAf(BbsDto dto) {
		int n = session.insert(ns+"add", dto );
		return n>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {
		session.update(ns+"readcount", seq);
		return session.selectOne(ns+"bbsdetail", seq);
	}

	@Override
	public boolean bbsanswerAf(BbsDto dto, int seq) {
		int n = session.insert(ns+"bbsanswer", dto );
		n = session.update(ns +"bbsStepIncrease", seq);
		return n>0?true:false;
	}

	@Override
	public boolean deleteBbs(int seq) {
		int n = session.delete(ns+"bbsdelete", seq);
		return n>0?true:false;
	
	}

	@Override
	public boolean updateBbs(BbsDto bbs) {
		int n = session.update(ns+"bbsupdate", bbs);
		return n>0?true:false;
	}


	
	
}








