package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.calParam;

public interface CalDao {

	

	List<CalendarDto> showSchedule(String id);

	boolean calWriteAf(CalendarDto dto);

	boolean calUpdateAf(CalendarDto dto);

	boolean calDelete(CalendarDto dto);

	List<CalendarDto> searchAf(calParam param);

}
