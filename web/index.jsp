<%@ page import="alex.app.fillMonthCalendar.MonthCalendar" %>
<%@ page import="alex.app.fillMonthCalendar.Week" %>
<%@ page import="alex.app.fillMonthCalendar.WeekDay" %>
<%@ page import="alex.app.fillMonthCalendar.WeekDayType" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 6/11/15
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Calendar calendar = Calendar.getInstance();
    if ((request.getParameter("year") != null) && (request.getParameter("month") != null)) {
        calendar.set(Integer.valueOf(request.getParameter("year")),
                Integer.valueOf(request.getParameter("month")),
                1);}
%>

<%
    Calendar prevMonth = (Calendar) calendar.clone();
    prevMonth.add(Calendar.MONTH, -1);
%>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=prevMonth.get(Calendar.MONTH)%>">
    <%=new SimpleDateFormat("YYYY MMM").format(prevMonth.getTime())%>
</a>

<%
    Calendar nextMonth = (Calendar) calendar.clone();
    nextMonth.add(Calendar.MONTH, 1);
%>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=nextMonth.get(Calendar.MONTH)%>">
    <%=new SimpleDateFormat("YYYY MMM").format(nextMonth.getTime())%>
</a>
<br>

<%
    MonthCalendar monthCalendar = new MonthCalendar(calendar);
%>

<table border=1>
    <tr>
        <%
            for (WeekDayType dayOfWeek : WeekDayType.values()) {
        %>
        <th>
            <%=dayOfWeek.getTitle()%>
        </th>
        <%}%>
    </tr>
    <%
        for (Week week : monthCalendar.getWeeks()) {
    %>
    <tr>
        <%
            for (WeekDay day : week.getDays()) {
        %>
        <td>
            <%=day.getDayInMonth()%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
