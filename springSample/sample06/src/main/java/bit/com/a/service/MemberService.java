package bit.com.a.service;

import bit.com.a.dto.MemberDto;

public interface MemberService {
	boolean idcheck(String id);
	boolean addmember(MemberDto mem);
	MemberDto login(MemberDto dto);
}
