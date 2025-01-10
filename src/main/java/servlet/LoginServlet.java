package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.ConnectionFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Check if user is already logged in
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("home.jsp");
            return;
        }
        // If not logged in, show login page
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Input validation
        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Username and password are required");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try (Connection connection = ConnectionFactory.getConnection()) {
            if (validateUser(connection, username, password)) {
                // Create session
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                session.setMaxInactiveInterval(30 * 60); // 30 minutes

                // Log successful login
                System.out.println("User logged in successfully: " + username);
                
                // Redirect to dashboard
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Log the error
            System.err.println("Database error during login: " + e.getMessage());
            request.setAttribute("error", "A system error occurred. Please try again later.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean validateUser(Connection connection, String username, String password) 
            throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password); // In production, use password hashing
            
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if user exists
            }
        }
    }
}
