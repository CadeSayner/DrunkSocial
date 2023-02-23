package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import database.LoginDao;
import database.RegisterDao;
import database.RegisterDaoMySql;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("txtName");
			String password = request.getParameter("txtPassword");
			String age = request.getParameter("txtAge");
			String numberOfYears = request.getParameter("txtYears");
			System.out.println(name + " " + password);
			loginDao.createUser(name, password, age, numberOfYears);
		} finally {
			response.sendRedirect("login.jsp");
		}
	}

}
