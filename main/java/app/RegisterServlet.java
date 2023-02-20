package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import database.RegisterDao;
import database.RegisterDaoMySql;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao registerDao;

	public void init() {
		registerDao = new RegisterDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("txtName");
			String password = request.getParameter("txtPassword");
			String age = request.getParameter("txtAge");
			String numberOfYears = request.getParameter("txtYears");
			System.out.println(name + " " + password);
			registerDao.createUser(name, password, age, numberOfYears);
		} finally {
			response.sendRedirect("login.jsp");
		}
	}

}
