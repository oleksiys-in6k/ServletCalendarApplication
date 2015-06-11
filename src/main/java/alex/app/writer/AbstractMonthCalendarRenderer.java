package alex.app.writer;


import alex.app.fillMonthCalendar.MonthCalendar;
import alex.app.fillMonthCalendar.Week;
import alex.app.fillMonthCalendar.WeekDay;
import alex.app.fillMonthCalendar.WeekDayType;

import java.util.Calendar;

public abstract class AbstractMonthCalendarRenderer implements CalendarWriter {


    public String render(MonthCalendar monthCalendar) {

        String result = "";
        result += getOpenMonthToken();
        result += getOpenWeekToken();
        result += renderHeader();
        result += getCloseWeekToken();
        result += renderWeeks(monthCalendar);

        result += renderPreviousButton(monthCalendar);
        result += renderNextButton(monthCalendar);

        result += getCloseMonthToken();
        return result;
    }

    private String renderNextButton(MonthCalendar monthCalendar) {
        Calendar nextCalendar = monthCalendar.getCalendar();
        nextCalendar.add(Calendar.MONTH, 1);

        String result = "";
        result += openLink();
        result += getNextCalendar(nextCalendar);
        result += textNext();
        result += closeLink();
        return result;
    }

    private String getNextCalendar(Calendar calendar) {
        return "?year=" + calendar.get(Calendar.YEAR) +
                "&month=" + (calendar.get(Calendar.MONTH)+1);
    }

    private String renderPreviousButton(MonthCalendar monthCalendar) {
        Calendar prevCalendar = monthCalendar.getCalendar();
        prevCalendar.add(Calendar.MONTH, - 1);

        String result = "";
        result += openLink();
        result += getPrevCalendar(prevCalendar);
        result += textPrev();
        result += closeLink();
        return result;
    }

    private String getPrevCalendar(Calendar prevCalendar) {
        return "?year=" + prevCalendar.get(Calendar.YEAR) +
                "&month=" + (prevCalendar.get(Calendar.MONTH));
    }

    private String renderWeeks(MonthCalendar monthCalendar) {
        String result = "";

        for (Week week : monthCalendar.getWeeks()) {
            result += getOpenWeekToken();
            result += renderDay(week);
            result += getCloseWeekToken();
        }
        return result;
    }

    private String renderHeader() {
        String result = "";
        for (WeekDayType weekDayType : WeekDayType.values()) {
            result += getOpenTitleToken();
            result += weekDayType.getTitle();

            result += getCloseTitleToken();
        }
        return result;
    }

    private String renderDay(Week week) {
        String result = "";
        for (WeekDay weekDay : week.getDays()) {
            result += getOpenDayToken(weekDay.getType());
            result += weekDay.getDayInMonth(); //
            result += getCloseDayToken();
        }
        return result;
    }

    public abstract String getOpenDayToken(WeekDayType weekDay);

    public abstract String getCloseDayToken();

    public abstract String getOpenWeekToken();

    public abstract String getCloseWeekToken();

    public abstract String getOpenMonthToken();

    public abstract String getCloseMonthToken();

    public abstract String getOpenTitleToken();

    public abstract String getCloseTitleToken();

    public abstract String closeLink();

    public abstract String openLink();

    protected abstract String textNext();

    protected abstract String textPrev();


}
