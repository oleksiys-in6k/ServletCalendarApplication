package alex.app.writer;

import alex.app.fillMonthCalendar.WeekDayType;

public class ConsoleCalendarWriter extends AbstractMonthCalendarRenderer {

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String TAB = "\t";
    private static final String ENTER = "\n";
    private static final String EMPTY = "";

    @Override
    public String getOpenDayToken(WeekDayType dayType) {
        return dayType.isWeekendsDay()
        ? TAB + RED
        : TAB + BLACK;
    }

    @Override
    public String getCloseDayToken() {
        return TAB;
    }

    @Override
    public String getOpenWeekToken() {
        return EMPTY;
    }

    @Override
    public String getCloseWeekToken() {
        return ENTER;
    }

    @Override
    public String getOpenMonthToken() {
        return EMPTY;
    }

    @Override
    public String getCloseMonthToken() {
        return EMPTY;
    }

    @Override
    public String getOpenTitleToken() {
        return YELLOW + TAB;
    }

    @Override
    public String getCloseTitleToken() {
        return BLACK + TAB ;
    }

    @Override
    public String closeLink() {
        return null;
    }

    @Override
    public String openLink() {
        return null;
    }

    @Override
    protected String textNext() {
        return null;
    }

    @Override
    protected String textPrev() {
        return null;
    }

}
