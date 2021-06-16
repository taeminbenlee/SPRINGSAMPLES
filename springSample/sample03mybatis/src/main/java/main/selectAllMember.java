package main;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.MemberDto;

public class selectAllMember {

	public static void main(String[] args) throws Exception{
		
		
		//mybatis 설정파일을 읽어드리는 작업
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		//sqlSessionFactory로 오브젝트 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//sqlsession을 취득하는 과정...세션은 오브젝트를 저장함.. 세션 객체를 취득
		SqlSession session = factory.openSession(); // session에 factory라고 하는 오브젝트를 저장함.
		
		
		//selectall
		List<MemberDto>list = session.selectList("allData");
		for(MemberDto m : list) {
			System.out.println(m.toString());
		}
		
		
		
	}

}
