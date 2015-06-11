<%@ page import="alex.app.fillMonthCalendar.MonthCalendar" %>
<%@ page import="alex.app.fillMonthCalendar.Week" %>
<%@ page import="alex.app.fillMonthCalendar.WeekDay" %>
<%@ page import="alex.app.fillMonthCalendar.WeekDayType" %>
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
<% int year = Integer.parseInt(request.getParameter("year"));
    int month = Integer.parseInt(request.getParameter("month"));
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);

    calendar.set(Calendar.DAY_OF_MONTH, 1);
%>


<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)-1%>">previous</a>
<%--<%calendar.add(Calendar.MONTH, 2);%>--%>

<br>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)+1%>">next</a>
<%--<%calendar.set(Calendar.MONTH, month + 1);%>--%>

<br>

<%
//    calendar.set(Calendar.MONTH, month + 1);
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
