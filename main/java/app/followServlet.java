package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import database.RegisterDao;

/**
 * Servlet implementation class followServlet
 */
@WebServlet("/follow")
public class followServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao rd;
	public void init()
	{
		rd = new RegisterDao();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			rd.AddFollower((String)session.getAttribute("user_name"), request.getParameter("user_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			response.sendRedirect("feed.jsp");
		}
	}

}
