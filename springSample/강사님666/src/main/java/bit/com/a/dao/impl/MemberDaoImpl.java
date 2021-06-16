package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	// sqlSession
	@Autowired
	SqlSession sqlSession;		
	
	String namespace = "Member.";
	
	@Override
	public int getId(MemberDto mem) {
		return sqlSession.selectOne(namespace + "getId", mem);
	}

	@Override
	public boolean addmember(MemberDto mem) {
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}

	
	
	
}
