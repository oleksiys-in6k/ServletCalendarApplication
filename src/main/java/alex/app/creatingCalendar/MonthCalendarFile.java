package alex.app.creatingCalendar;

import alex.app.fillMonthCalendar.MonthCalendar;
import alex.app.writer.ConsoleCalendarWriter;
import alex.app.writer.HTMLCalendarWriter;
import alex.app.writer.CalendarWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MonthCalendarFile extends MonthCalendar {
    public static CalendarWriter calendarWriter;

    public static final String OUTPUT_DIR = "output";
    private static final String HTMLEXTENSION = ".html";

    private Calendar calendar = Calendar.getInstance();
    private MonthCalendar monthCalendar;
    private File file;

    public MonthCalendarFile(Calendar calendar) {
        this.calendar.setTime(calendar.getTime());
        this.monthCalendar = new MonthCalendar(calendar);
        this.file = new File(getPathToFile(calendar));

        deleteOutputDirectory( new File(OUTPUT_DIR));
    }

    private void deleteOutputDirectory(File directory) {
        if (directory.isDirectory()) {
            String[] children = directory.list();
            for (String aChildren : children) {
                File susItem = new File(directory, aChildren);
                deleteOutputDirectory(susItem);
            }
            directory.delete();
        } else directory.delete();
    }

    private String getPathToFile(Calendar c) {
        return OUTPUT_DIR
                + File.separator
                + c.get(Calendar.YEAR)
                + File.separator
                + new SwitchesOfMonth().getMonthNameByIndex((c.get(Calendar.MONTH)))
                + HTMLEXTENSION;
    }

    public void writeToFile(MonthCalendarFile previous, MonthCalendarFile next) throws FileNotFoundException {
        File directory = new File(file.getParent() + File.separator);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        PrintWriter writer = new PrintWriter(file);

        if (previous != null) {
            writer.println(previous.getLink());
        }
        if (next != null) {
            writer.println(next.getLink());
        }

        calendarWriter = new HTMLCalendarWriter();
        writer.println("<h1>" + getMonthTitle() + "</h1>");
        writer.println(calendarWriter.render(monthCalendar));
        writer.close();
    }

    public void writeToConsole (MonthCalendarFile previous, MonthCalendarFile next) {
        calendarWriter = new ConsoleCalendarWriter();
        System.out.println(getMonthTitle() );
        System.out.println(calendarWriter.render(monthCalendar));

    }

    private String getLink() {
        String pathToIndex = getPathToFile(calendar);
        String s = "<a href=\"../../" + pathToIndex + "\">"+ getMonthTitle() + "</a>" ;
        return s;
    }

    private String getMonthTitle() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM YYYY");
        return format.format(calendar.getTime());
    }

}
