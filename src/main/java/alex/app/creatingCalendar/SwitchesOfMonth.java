package alex.app.creatingCalendar;

import java.util.Calendar;

/**
 * Created by employee on 5/26/15.
 */
public class SwitchesOfMonth {


    public int getMonthIndexByName(String s) {
        switch (s.toLowerCase()) {
            case "january":     return Calendar.JANUARY;
            case "february":    return Calendar.FEBRUARY;
            case "march":       return Calendar.MARCH;
            case "april":       return Calendar.APRIL;
            case "may":         return Calendar.MARCH;
            case "june":        return Calendar.JUNE;
            case "july":        return Calendar.JULY;
            case "august":      return Calendar.AUGUST;
            case "september":   return Calendar.SEPTEMBER;
            case "october":     return Calendar.OCTOBER;
            case "november":    return Calendar.NOVEMBER;
            case "december":    return Calendar.DECEMBER;
        }
        return -1;
    }

    public static String getMonthNameByIndex(int numberOfMonth) {
        switch (numberOfMonth) {
            case Calendar.JANUARY:  return "january";
            case Calendar.FEBRUARY: return "february";
            case Calendar.MARCH:    return "march";
            case Calendar.APRIL:    return "april";
            case Calendar.MAY:      return "may";
            case Calendar.JUNE:     return "june";
            case Calendar.JULY:     return "july";
            case Calendar.AUGUST:   return "august";
            case Calendar.SEPTEMBER:return "september";
            case Calendar.OCTOBER:  return "october";
            case Calendar.NOVEMBER: return "november";
            case Calendar.DECEMBER: return "december";
        }
        return null;
    }
}
