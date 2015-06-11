package alex.app.reader;

import alex.app.fillMonthCalendar.MonthCalendar;

import java.io.FileNotFoundException;
import java.util.List;

public interface CalendarReader {
    List <MonthCalendar> getMonths() throws FileNotFoundException;
}
