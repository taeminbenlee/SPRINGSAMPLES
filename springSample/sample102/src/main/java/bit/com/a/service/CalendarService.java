package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarOgDto;

public interface CalendarService {

	List<CalendarOgDto> getCalendarList(CalendarOgDto cal);
}
