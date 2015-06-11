package alex.app.reader;

import alex.app.fillMonthCalendar.MonthCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodayReader implements CalendarReader {

    @Override
    public List<MonthCalendar> getMonths() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);

        MonthCalendar monthCalendar = new MonthCalendar(calendar);
        List <MonthCalendar> list = new ArrayList <MonthCalendar> ();
        list.add(0,monthCalendar);

        return list;
    }
}
