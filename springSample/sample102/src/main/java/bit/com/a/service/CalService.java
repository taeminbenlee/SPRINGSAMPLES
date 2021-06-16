package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.calParam;

public interface CalService {


	List<CalendarDto> showSchedule(String id);

	boolean calWriteAf(CalendarDto dto);

	boolean calUpdateAf(CalendarDto dto);

	boolean calDelete(CalendarDto dto);

	List<CalendarDto> searchAf(calParam param);



}
