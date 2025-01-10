package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BankDAOImpl;
import service.DeleteRequestHelper;
import service.GetRequestHelper;
import service.PostRequestHelper;
import service.PutRequestHelper;

@WebServlet(
		urlPatterns = {
			"/accountlinks",
			"/accounts",
			"/accounts/*",
			"/currentuser",
			"/home",
			"/login",
			"/logout",
			"/passTime",
			"/register",
			"/roles",
			"/statuses",
			"/types",
			"/users",
			"/users/*"
		}
	)
public class MasterServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	 BankDAOImpl dao;
	 public MasterServlet() {
		 super();
	 }
	 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			GetRequestHelper.process(req, res);
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().write("An error occurred while processing the GET request: " + e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PostRequestHelper.process(req, res);
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().write("An error occurred while processing the POST request: " + e.getMessage());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PutRequestHelper.process(req, res);
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().write("An error occurred while processing the PUT request: " + e.getMessage());
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			DeleteRequestHelper.process(req, res);
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().write("An error occurred while processing the DELETE request: " + e.getMessage());
		}
	}
}