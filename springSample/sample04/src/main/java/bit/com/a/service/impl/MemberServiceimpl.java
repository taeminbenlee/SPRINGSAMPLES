package bit.com.a.service.impl;

import java.util.List;

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
	public List<MemberDto> allMember() {
		
		return memberDao.allMember();
	}

}
