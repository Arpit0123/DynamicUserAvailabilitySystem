package com.scheduling.model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date; // Correct import for java.util.Date
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT u.username, t.date, t.start_time, t.end_time FROM Users u JOIN TimeSlots t ON u.id = t.employee_id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            ArrayList<EmployeeTimeSlot> employeeTimeSlots = new ArrayList<>();
            while (rs.next()) {
                EmployeeTimeSlot ets = new EmployeeTimeSlot();
                ets.setUsername(rs.getString("username"));
                ets.setDate(rs.getDate("date")); // Assuming the date column is in SQL DATE format
                ets.setStartTime(rs.getString("start_time"));
                ets.setEndTime(rs.getString("end_time"));
                employeeTimeSlots.add(ets);
            }

            request.setAttribute("employeeTimeSlots", employeeTimeSlots);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Database error");
        }
    }
}

class EmployeeTimeSlot {
    private String username;
    private Date date; // Importing java.util.Date
    private String startTime;
    private String endTime;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
