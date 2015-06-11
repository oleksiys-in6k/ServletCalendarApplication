package alex.app.writer;

import alex.app.fillMonthCalendar.MonthCalendar;

public interface CalendarWriter {
    String render(MonthCalendar monthCalendar);
}
