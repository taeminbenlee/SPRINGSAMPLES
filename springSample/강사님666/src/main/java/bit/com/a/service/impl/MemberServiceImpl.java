package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	// MemberDao
	@Autowired			
	MemberDao memberDao;
	
	@Override
	public int getId(MemberDto mem) {		
		return memberDao.getId(mem);		
	}
	
	@Override
	public boolean addmember(MemberDto mem) {		
		return memberDao.addmember(mem);		
	}
}
