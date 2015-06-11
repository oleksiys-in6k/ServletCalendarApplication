import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class MonthCalendarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Calendar calendar = Calendar.getInstance();
        if ((request.getParameter("year") != null) && (request.getParameter("month") != null)) {
            calendar.set(
                    Integer.valueOf(request.getParameter("year")),
                    Integer.valueOf(request.getParameter("month")),
                    1);}



    }
}
