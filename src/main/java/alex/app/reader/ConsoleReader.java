package alex.app.reader;

import alex.app.fillMonthCalendar.MonthCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements CalendarReader {
    @Override
    public List<MonthCalendar> getMonths() {

        System.out.println("Enter Year");
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.next());
        System.out.println("Enter month");
        int month = Integer.parseInt(scanner.next());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, month - 1 );
        calendar.set(Calendar.YEAR, year);

        MonthCalendar monthCalendar = new MonthCalendar(calendar);
        List <MonthCalendar> list = new ArrayList <MonthCalendar> ();
        list.add(monthCalendar);

        return list;
    }
}
