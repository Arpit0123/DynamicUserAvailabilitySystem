<%
    if (session.getAttribute("userId") == null || !"admin".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>


<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.scheduling.model.EmployeeTimeSlot" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Employee Time Slots</h1>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
        </tr>
        <%
            List<EmployeeTimeSlot> employeeTimeSlots = (List<EmployeeTimeSlot>) request.getAttribute("employeeTimeSlots");
            for (EmployeeTimeSlot ets : employeeTimeSlots) {
        %>
        <tr>
            <td><%= ets.getUsername() %></td>
            <td><%= ets.getDate() %></td>
            <td><%= ets.getStartTime() %></td>
            <td><%= ets.getEndTime() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
