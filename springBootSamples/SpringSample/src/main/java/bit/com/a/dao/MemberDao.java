package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {

	public MemberDto loginAf(String id, String pwd);

	public int idcheck(String id);

	public boolean addmember(MemberDto dto);
	
	
}
