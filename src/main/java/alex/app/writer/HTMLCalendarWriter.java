package alex.app.writer;

import alex.app.fillMonthCalendar.WeekDayType;

public class HTMLCalendarWriter extends AbstractMonthCalendarRenderer {


    public static final String MONTH_OPEN = "<html>\n<head>\n</head>\n<body>\n<table border=1>";
    public static final String MONTH_CLOSE = "</table>\n</body>\n</html>";

    private static final String TAB = "\t";
    private static final String ENTER = "\n";
    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = ">";

    private static final String END_TAG = "</";
    private static final String TD = "td";
    private static final String TH = "th";
    private static final String TR = "tr";

    private static final String SPACE = " ";

    private static final String COLOR = "bgcolor=";
    private static final String RED = "\"#FF0000\"";
    private static final String BLACK = "\"#000000\"";

    private static final String OPEN_LINK = "<a href=\"";
    private static final String CLOSE_LINK = "</a>";


    @Override
    public String getOpenDayToken(WeekDayType weekDayType) {
        return weekDayType.isWeekendsDay()
            ? OPEN_TAG + TD + SPACE + COLOR + RED + CLOSE_TAG
            :  OPEN_TAG + TD + CLOSE_TAG;
    }

    @Override
    public String getCloseDayToken() {
        return END_TAG + TD + SPACE + COLOR + BLACK + CLOSE_TAG;
    }

    @Override
    public String getOpenWeekToken() {
        return OPEN_TAG + TR + CLOSE_TAG ;
    }

    @Override
    public String getCloseWeekToken() {
        return END_TAG + TR + CLOSE_TAG + ENTER;
    }

    @Override
    public String getOpenMonthToken() {
        return MONTH_OPEN ;
    }

    @Override
    public String getCloseMonthToken() {
        return MONTH_CLOSE + ENTER;
    }

    @Override
    public String getOpenTitleToken() {
        return OPEN_TAG + TH + CLOSE_TAG;
    }

    @Override
    public String getCloseTitleToken() {
        return END_TAG + TH + CLOSE_TAG;
    }

    @Override
    public String closeLink() {
        return CLOSE_LINK;
    }

    @Override
    public String openLink() {
        return OPEN_LINK;
    }

    @Override
    protected String textNext() {
        return "\">" + "\t next \t";
    }

    @Override
    protected String textPrev() {
        return "\">" + "\t prev \t";
    }

}
