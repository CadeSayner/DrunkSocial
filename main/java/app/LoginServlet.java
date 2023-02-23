package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.LoginDao;
import database.LoginDaoMySql;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    
    public void init()
    {
    	loginDao = new LoginDao();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	
			String name = request.getParameter("txtName");
			String password = request.getParameter("txtPassword");
		
			if (loginDao.validate(name, password))
			{
				// Add username to the session
				HttpSession session = request.getSession();
				session.setAttribute("user_name", name);
				response.sendRedirect("home.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		};
	}
}

