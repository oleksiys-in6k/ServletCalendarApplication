package alex.app.fillMonthCalendar;

import java.util.Calendar;

public enum WeekDayType {
    SUNDAY("Sun", Calendar.SUNDAY,true),
    MONDAY("Mon",Calendar.MONDAY,false),
    TUESDAY("Tue",Calendar.TUESDAY,false),
    WEDNESDAY("Wed",Calendar.WEDNESDAY,false),
    THURSDAY("Thu",Calendar.THURSDAY,false),
    FRIDAY("Fri",Calendar.FRIDAY,false),
    SATURDAY("Sat",Calendar.SATURDAY,true);

    private String title;
    private int id;
    private boolean weekendsDay;

    public String getTitle() {
        return title;
    }

    public boolean isWeekendsDay() {
        return weekendsDay;
    }

    WeekDayType(String title, int id, boolean weekendsDay) {
        this.title = title;
        this.id = id;
        this.weekendsDay = weekendsDay;
    }
}
