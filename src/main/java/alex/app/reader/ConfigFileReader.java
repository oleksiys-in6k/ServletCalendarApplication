package alex.app.reader;

import alex.app.fillMonthCalendar.MonthCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ConfigFileReader implements CalendarReader {

    @Override
    public List<MonthCalendar> getMonths() throws FileNotFoundException {

//        InputConfigReader config = new InputConfigReader();
        List<MonthCalendar> years = getMonthsFromConfig();

        System.out.println(years);

        return years;

    }

    public List<MonthCalendar> getMonthsFromConfig() throws FileNotFoundException {
        List<MonthCalendar> result = new ArrayList<MonthCalendar>();

        Scanner in = new Scanner(new File("config.txt"));

//        while (in.hasNextLine()) {
//            Calendar calendar = Calendar.getInstance();
//            int year = 0;
//            LinkedList<MonthCalendar> listOfMonth = new LinkedList<>();
//
//            if (in.hasNextInt()) {
//                year = calendar.get(Calendar.YEAR);
//            }
//            if (!in.hasNextInt()) {
//                String s = in.nextLine().trim();
//                listOfMonth.add(Arrays.asList(s));
//                result.addAll(listOfMonth);
//            }
//
//            Collections.sort(result);
//        }

        return null;
    }
}
