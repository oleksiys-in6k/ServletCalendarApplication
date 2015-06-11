package alex.app.creatingCalendar;

import alex.app.fillMonthCalendar.MonthCalendar;

import java.util.Calendar;
import java.util.*;

public class Year implements Comparable {

    public static final int COUNT_OF_MONTH = 12;
    int year;
    List<MonthCalendar> months = new LinkedList<MonthCalendar>();

    public Year(int year, LinkedList<String> sMonths) {
        this.year = year;
        fillMonths(sMonths);
    }

    private void fillMonths(LinkedList<String> sMonths) {
        if (sMonths.size() == 0)
            inputAllMonths();
        else {
            sortingMonths(sMonths);
            inputExistingMonth(sMonths);
        }
    }

    private void sortingMonths(LinkedList<String> sMonths) {
        List <Integer> listOfMonthsIndex = new LinkedList();
        for (String sMonth : sMonths)
            listOfMonthsIndex.add(new SwitchesOfMonth().getMonthIndexByName(sMonth));

        Collections.sort(listOfMonthsIndex);
        sMonths.clear();

        for (Integer aListOfMonthsIndex : listOfMonthsIndex) {
            String currMonth = new SwitchesOfMonth().getMonthNameByIndex(aListOfMonthsIndex);
            sMonths.add(currMonth);
        }
    }

    private void inputExistingMonth(LinkedList<String> sMonths) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (String curMonth : sMonths) {
            c.set(Calendar.MONTH, new SwitchesOfMonth().getMonthIndexByName(curMonth));
            months.add(new MonthCalendarFile(c));
        }
    }

    private void inputAllMonths() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (int monthNumber = 0; monthNumber < COUNT_OF_MONTH; monthNumber++  ) {
            c.set(Calendar.MONTH, monthNumber);
            months.add(new MonthCalendarFile(c));
        }
    }

    public List<MonthCalendar> getMonths() {
        return months;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(year, ((Year) o).year);
    }
}
