package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;


public class BbsDaoimpl implements BbsDao {

	@Autowired			// -> new 	: Dependency Injection
	SqlSession sqlSession;
	
	String namespace = "Member.";
	@Override
	public List<BbsDto> allBbs() {
		List<BbsDto> list = sqlSession.selectList(namespace + "allBbs");
		return list;
	}

}
