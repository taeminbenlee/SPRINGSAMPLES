package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;
@Repository
public class PdsDaoImpl implements PdsDao {
	@Autowired
	SqlSession session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> getPdsList() {
		return session.selectList(ns+"getPdsList");
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		int n = session.insert(ns +"uploadPds",dto);
		return n>0?true:false;
	}

	@Override
	public PdsDto getDetail(int seq) {
		session.update(ns+"readcount", seq);
		return session.selectOne(ns+"pdsdetail", seq);
	}

	@Override
	public boolean deletePds(int seq) {
		int n = session.delete(ns +"deletePds", seq);
		return n>0?true:false;
	}

	@Override
	public PdsDto downcount(int seq) {
		session.update(ns+"downcount", seq);
		PdsDto dto = null;
		return dto;
	}

	@Override
	public boolean updateAf(PdsDto pdsdto) {
		int n = session.insert(ns +"updateAf",pdsdto);
		return n>0?true:false;
	}

	@Override
	public int getPdsCount(PdsParam param) {
		return session.selectOne(ns + "getPdsCount", param);
	
	}

	@Override
	public List<PdsDto> getPdslist(PdsParam param) {
		return session.selectList(ns + "pdslist", param);
	}
}
