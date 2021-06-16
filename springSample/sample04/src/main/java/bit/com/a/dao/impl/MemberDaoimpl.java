package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

//db와 대화하는 클래스
@Repository
public class MemberDaoimpl implements MemberDao {

	@Autowired			// -> new 	: Dependency Injection
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public List<MemberDto> allMember() {
														//Member.allMember
		List<MemberDto> list = sqlSession.selectList(namespace + "allMember");
		
		
		return list;
	}
	
	
	
}





