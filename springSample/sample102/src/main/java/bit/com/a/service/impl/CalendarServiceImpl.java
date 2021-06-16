package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarOgDto;
import bit.com.a.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarDao dao;

	@Override
	public List<CalendarOgDto> getCalendarList(CalendarOgDto cal) {		
		return dao.getCalendarList(cal);		
	}
	
	
}
