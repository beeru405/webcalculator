package mypackage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(request.getReader());

            int a1 = jsonNode.get("n1").asInt();
            int a2 = jsonNode.get("n2").asInt();

            if (jsonNode.has("r1") && jsonNode.get("r1").asBoolean()) {
                long result = addFucn(a1, a2);
                out.println("{\"operation\": \"Addition\", \"result\": " + result + "}");
                saveToDatabase("Addition", result);
            }
            if (jsonNode.has("r2") && jsonNode.get("r2").asBoolean()) {
                long result = subFunc(a1, a2);
                out.println("{\"operation\": \"Subtraction\", \"result\": " + result + "}");
                saveToDatabase("Subtraction", result);
            }
            if (jsonNode.has("r3") && jsonNode.get("r3").asBoolean()) {
                long result = mulFucn(a1, a2);
                out.println("{\"operation\": \"Multiplication\", \"result\": " + result + "}");
                saveToDatabase("Multiplication", result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
