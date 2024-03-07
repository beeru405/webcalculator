package mypackage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class Calculator extends HttpServlet {

    public long addFucn(long first, long second) {
        return first + second;
    }

    public long subFunc(long first, long second) {
        return second - first;
    }

    public long mulFucn(long first, long second) {
        return first * second;
    }

    private Connection getDBConnection() throws SQLException {
        // Update with your database connection details
        String jdbcUrl = "jdbc:mysql://192.168.138.114:3306/myDB";
        String jdbcUser = "mysql";
        String jdbcPassword = "mysql";

        // Register the JDBC driver (you might not need this if using JDBC 4.0+)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create and return the connection
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    private void saveToDatabase(String operation, long result) {
        try (Connection connection = getDBConnection()) {
            if (connection != null && !connection.getAutoCommit()) {
                connection.setAutoCommit(false);

                String query = "INSERT INTO calculations (operation, result) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, operation);
                    statement.setLong(2, result);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Data successfully inserted into the database.");
                        connection.commit();
                    } else {
                        System.err.println("Failed to insert data into the database.");
                    }
                }
            } else {
                System.err.println("Failed to establish a database connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            int a1 = Integer.parseInt(request.getHeader("n1"));
            int a2 = Integer.parseInt(request.getHeader("n2"));

            if ("on".equals(request.getHeader("r1"))) {
                long result = addFucn(a1, a2);
                out.println("<h1>Addition</h1>" + result);
                saveToDatabase("Addition", result);
            }
            if ("on".equals(request.getHeader("r2"))) {
                long result = subFunc(a1, a2);
                out.println("<h1>Subtraction</h1>" + result);
                saveToDatabase("Subtraction", result);
            }
            if ("on".equals(request.getHeader("r3"))) {
                long result = mulFucn(a1, a2);
                out.println("<h1>Multiplication</h1>" + result);
                saveToDatabase("Multiplication", result);
            }

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            long resultAdd = calculator.addFucn(5, 3);
            long resultSub = calculator.subFunc(5, 3);
            long resultMul = calculator.mulFucn(5, 3);

            System.out.println("Addition: " + resultAdd);
            System.out.println("Subtraction: " + resultSub);
            System.out.println("Multiplication: " + resultMul);
        } catch (Exception e) {
            System.err.println("An error occurred in the main method.");
            e.printStackTrace();
        }
    }
}
