package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.RegisterDao;
import database.UsersDao;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDao rd;
	public void init() {
		rd = new UsersDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ArrayList<String> SearchResults = rd.getSearchResult(request.getParameter("txtSearch"));
			System.out.println(SearchResults);
			HttpSession session = request.getSession();
			session.setAttribute("searchResults", SearchResults);
			response.sendRedirect("searchResults.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
