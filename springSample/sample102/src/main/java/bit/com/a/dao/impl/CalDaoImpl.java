package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CalDao;
import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.calParam;
@Repository
public class CalDaoImpl implements CalDao {

	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Cal.";
	
	
	


	@Override
	public List<CalendarDto> showSchedule(String id) {
		return session.selectList(ns + "showSchedule", id);
	}





	@Override
	public boolean calWriteAf(CalendarDto dto) {
		int n = session.insert(ns+"addSchedule", dto );
		return n>0?true:false;
	}





	@Override
	public boolean calUpdateAf(CalendarDto dto) {
		int n = session.insert(ns+"updateSchedule", dto );
		return n>0?true:false;
	}





	@Override
	public boolean calDelete(CalendarDto dto) {
		int n = session.delete(ns+"deleteSchedule", dto );
		return n>0?true:false;
	}





	@Override
	public List<CalendarDto> searchAf(calParam param) {
		return session.selectList(ns + "searchSchedule", param);
	}

}
