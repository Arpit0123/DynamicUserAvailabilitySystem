<%
    if (session.getAttribute("userId") == null || !"employee".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.scheduling.model.TimeSlot" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard</title>
</head>
<body>
    <h1>Your Available Time Slots</h1>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
        </tr>
        <%
            List<TimeSlot> timeSlots = (List<TimeSlot>) request.getAttribute("timeSlots");
            for (TimeSlot slot : timeSlots) {
        %>
        <tr>
            <td><%= slot.getDate() %></td>
            <td><%= slot.getStartTime() %></td>
            <td><%= slot.getEndTime() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
