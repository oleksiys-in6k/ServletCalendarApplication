package alex.app.fillMonthCalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Week {

    public static final int DAYS_IN_WEEK = 7;
    final List<WeekDay> weekDays = new ArrayList<WeekDay>();
    Calendar calendar;
    private static SimpleDateFormat format  = new SimpleDateFormat("MMM dd, yyyy");

    public Week(Calendar calendar) {
        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());
        this.calendar = c;
        populateWeekDays();
    }

    private void populateWeekDays() {
        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());

        int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        c.add(Calendar.DAY_OF_YEAR, -(currentDayOfWeek - 1));

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            weekDays.add(new WeekDay(c));
            c.add(Calendar.DAY_OF_YEAR, 1 );
        }
    }

    public Week createNextWeek(){
        Calendar c = Calendar.getInstance();

        c.setTime(weekDays.get(6).getCalendar().getTime());
        c.add(Calendar.DAY_OF_YEAR, 1);

        return new Week(c);
    }

    public boolean isCurrentMonth() {
        return getCalendarByDayOfWeek(Calendar.SUNDAY).get(Calendar.MONTH) ==
                getCalendarByDayOfWeek(Calendar.SATURDAY).get(Calendar.MONTH);
    }

    private Calendar getCalendarByDayOfWeek(int day) {
        return weekDays.get(day - 1 ).getCalendar();
    }


    public List <WeekDay> getDays() {
        return weekDays;
    }
    public boolean isLastDayOfMonth() {
        return weekDays.get(6).getCalendar().get(Calendar.DAY_OF_MONTH) ==
                weekDays.get(6).getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Week week = (Week) o;

        return weekDays.equals(week.weekDays);
    }

    @Override
    public String toString() {
        return format.format(calendar.getTime());
    }

    @Override
    public int hashCode() {
        int result = weekDays != null ? weekDays.hashCode() : 0;
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        return result;
    }
}
