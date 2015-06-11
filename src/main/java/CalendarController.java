import alex.app.fillMonthCalendar.MonthCalendar;
import alex.app.writer.CalendarWriter;
import alex.app.writer.HTMLCalendarWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;


public class CalendarController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        ServletOutputStream out = response.getOutputStream();
        CalendarWriter calendarWriter = new HTMLCalendarWriter();

        out.println(calendarWriter.render(new MonthCalendar(calendar)));

        response.getWriter().flush();
    }
}
