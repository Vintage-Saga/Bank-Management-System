package servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BankDAOImpl;
import models.Message;
import models.Role;
import models.User;
import util.ConnectionFactory;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode = om.readTree(request.getReader());

        String username = jsonNode.get("username").asText();
        String password = jsonNode.get("password").asText();
        String firstName = jsonNode.get("firstName").asText();
        String lastName = jsonNode.get("lastName").asText();
        String email = jsonNode.get("email").asText();
        int roleId = jsonNode.get("roleId").asInt(); // Assuming roleId is passed from the client

        try (Connection conn = ConnectionFactory.getConnection()) {
            BankDAOImpl bDao = new BankDAOImpl(conn);
            User newUser  = new User(0, username, password, firstName, lastName, email, new Role(roleId, "User  Role"));
            int insertId = bDao.insertUser (newUser );

            if (insertId > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", bDao.getUserById(insertId));
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write(om.writeValueAsString(newUser ));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(om.writeValueAsString(new Message("Registration failed. Please try again.")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(om.writeValueAsString(new Message("An error occurred during registration.")));
        }
    }
}