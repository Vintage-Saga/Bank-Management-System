package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home {
	public static void getHomePage(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(false);
			if (session != null) {
				RequestDispatcher redir = req.getRequestDispatcher("login.jsp");
				redir.forward(req, res);
			} else {
				res.sendRedirect("register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
