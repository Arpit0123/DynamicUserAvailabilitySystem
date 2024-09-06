README;-

Setup and Installation:-

Prerequisites :-

Oracle Database installed and running.
Oracle JDBC Driver added to your project’s classpath.

Configuration :-

Update the DBConnection class with your database URL, username, and password.

Deployment :-
Deploy the application to a servlet container like Apache Tomcat.

Access :-
Open your web browser and navigate to the login page.

Usage :-
Login: Use login.jsp to authenticate. Users will be redirected to their respective dashboards based on their roles.
Admin Dashboard: Accessible via adminDashboard.jsp. Shows all employees' time slots.
Employee Dashboard: Accessible via employeeDashboard.jsp. Shows time slots for the logged-in employee.

Error Handling :-
Login Errors: Errors during login are displayed on the login page.
Database Errors: Database-related issues are shown with appropriate messages.