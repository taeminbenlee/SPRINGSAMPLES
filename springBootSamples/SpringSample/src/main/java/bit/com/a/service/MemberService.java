package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberDao dao;

	public MemberDto loginAf(String id, String pwd) {
		return dao.loginAf(id, pwd);
	}

	public int idcheck(String id) {
		return dao.idcheck(id);
	}

	public boolean addmember(MemberDto dto) {
		return dao.addmember(dto);
	}
	
	
}
