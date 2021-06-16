package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarOgDto;

public interface CalendarDao {

	List<CalendarOgDto> getCalendarList(CalendarOgDto cal);
}
