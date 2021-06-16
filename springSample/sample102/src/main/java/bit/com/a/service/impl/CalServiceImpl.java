package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalDao;
import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.calParam;
import bit.com.a.service.CalService;

@Service
public class CalServiceImpl implements CalService{
	@Autowired
	CalDao dao;
	
	

	@Override
	public List<CalendarDto> showSchedule(String id) {
		return dao.showSchedule(id);
	}



	@Override
	public boolean calWriteAf(CalendarDto dto) {
		return dao.calWriteAf(dto);
	}



	@Override
	public boolean calUpdateAf(CalendarDto dto) {
		return dao.calUpdateAf(dto);
	}



	@Override
	public boolean calDelete(CalendarDto dto) {
		return dao.calDelete(dto);
	}



	@Override
	public List<CalendarDto> searchAf(calParam param) {
		return dao.searchAf(param);
	}
	
	
	

}
