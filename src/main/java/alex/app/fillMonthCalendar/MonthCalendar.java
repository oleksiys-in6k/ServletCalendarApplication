package alex.app.fillMonthCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthCalendar {

    private List<Week> weeks = new ArrayList<Week>();

    Calendar calendar;

    public MonthCalendar(Calendar calendar) {

        this.calendar = calendar;

        Week week = new Week(calendar);
        weeks.add(week);

        do {
            week = week.createNextWeek();
            weeks.add(week);
        } while (week.isCurrentMonth() && !week.isLastDayOfMonth());
    }

    public MonthCalendar() {
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthCalendar that = (MonthCalendar) o;

        return !(weeks != null ? !weeks.equals(that.weeks) : that.weeks != null);

    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public int hashCode() {
        return weeks != null ? weeks.hashCode() : 0;
    }
}
