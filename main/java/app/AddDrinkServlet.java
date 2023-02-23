package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import database.PostsDao;
import database.RegisterDao;
import database.RegisterDaoMySql;
import database.UsersDao;

/**
 * Servlet implementation class AddDrinkServlet
 */
public class AddDrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private PostsDao postsDao;

	public void init() {
		usersDao = new UsersDao();
		postsDao = new PostsDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int DrinkQuantity = Integer.parseInt(request.getParameter("txtNumberOfDrinks"));
			String DrinkName = request.getParameter("txtNameOfDrink");
			String DrinkLocation = request.getParameter("txtLocationOfPost");
			usersDao.AddDrinks(DrinkQuantity, (String)request.getSession().getAttribute("user_name"));
			postsDao.AddPost((String)request.getSession().getAttribute("user_name"), DrinkName, DrinkQuantity, DrinkLocation);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			response.sendRedirect("home.jsp");
		}
	}
}
