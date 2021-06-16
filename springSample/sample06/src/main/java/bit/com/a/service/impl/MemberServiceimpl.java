package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;
@Service
public class MemberServiceimpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean idcheck(String id) {
		
		return memberDao.idcheck(id);
	}

	@Override
	public boolean addmember(MemberDto mem) {		
		return memberDao.addmember(mem);		
	}
	@Override
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}
	
	
	//MemberDao
	
	
}
