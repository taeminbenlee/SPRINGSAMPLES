package bit.com.a.dao;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	boolean idcheck(String id);
	boolean addmember(MemberDto mem);
	MemberDto login(MemberDto dto);
}
