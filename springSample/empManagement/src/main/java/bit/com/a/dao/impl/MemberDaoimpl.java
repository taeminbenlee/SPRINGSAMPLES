package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
@Repository
public class MemberDaoimpl implements MemberDao {

	@Autowired			// -> new 	: Dependency Injection
	SqlSession sqlSession;
	
	String namespace = "Member.";
	@Override
	public boolean idcheck(String id) {
		
		boolean findid;
		int idchk = sqlSession.selectOne(namespace+"idcheck", id);
		
		if (idchk == 0) {
			findid = true;
		} else {
			findid = false;
		}
	
		return findid;
	}
	@Override
	public boolean addmember(MemberDto mem) {
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}
	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto mem = sqlSession.selectOne(namespace + "login", dto);
		return mem;
		
	}
}
