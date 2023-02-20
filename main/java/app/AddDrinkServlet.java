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
 * Servlet implementation class AddDrinkServlet
 */
public class AddDrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao registerDao;

	public void init() {
		registerDao = new RegisterDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int DrinkQuantity = Integer.parseInt(request.getParameter("txtNoOfDrinks"));
			
			registerDao.AddDrinks(DrinkQuantity, (String)request.getSession().getAttribute("name"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			response.sendRedirect("userLoginLandingPage.jsp");
		}
	}
}
