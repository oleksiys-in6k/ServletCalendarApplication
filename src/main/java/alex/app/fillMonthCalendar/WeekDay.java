package alex.app.fillMonthCalendar;

import java.util.Calendar;

public class WeekDay {
    private WeekDayType type;
    final private Calendar calendar;

    public WeekDay(Calendar date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date.getTime());

        this.type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1 ];
        this.calendar = c;
    }

    public WeekDayType getType() {
        return type;
    }

    public int getDayInMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekDay weekDay = (WeekDay) o;

        return (calendar.get(Calendar.DAY_OF_MONTH) == weekDay.calendar.get(Calendar.DAY_OF_MONTH)) &&
                (calendar.get(Calendar.MONTH) == weekDay.calendar.get(Calendar.MONTH)) &&
                (calendar.get(Calendar.YEAR) == weekDay.calendar.get(Calendar.YEAR));
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (calendar.hashCode());
        return result;
    }
}

