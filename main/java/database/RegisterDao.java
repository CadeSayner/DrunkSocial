package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDao {

	public int createUser(String username, String password, String age, String numberOfYears) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
			// Insert into the login table
			PreparedStatement ps = con.prepareStatement("insert into login(user_name, user_password) values(?,?)");
			//TODO: check that the username is unique and can actually go in the database!!!!
			ps.setString(1, username);
			ps.setString(2, password);
			status = ps.executeUpdate();
			
			// Insert into the users table
			ps = con.prepareStatement("insert into users(user_name, user_num_drinks_total, user_num_drink_years, user_age, user_weightclass) values(?,?,?,?,?)");
			ps.setString(1, username);
			ps.setInt(2, 0);
			ps.setInt(3, Integer.parseInt(numberOfYears));
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, "novice");
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return status;
	}
	
	public int AddDrinks(int noDrinks, String name) throws SQLException
	{	
		int status = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("update users set drinks = drinks + ? where uname = ? ");
		ps.setInt(1, noDrinks);
		ps.setString(2, name);
		status = ps.executeUpdate();
		return status;
	}
	
	public ArrayList<String> getFollowing(String uname) throws SQLException
	{
		ArrayList<String> followings = new ArrayList<String>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("select user_name_following from following where user_name = ?");
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			followings.add(rs.getString("user_name_following"));
		}
		return followings;
	}
	
	public ArrayList<String> getSearchResult(String search) throws SQLException
	{
		ArrayList<String> sr = new ArrayList<String>();
		System.out.println("The search query is " + search);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("select user_name from users where user_name = ?");
		ps.setString(1, search);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			sr.add(rs.getString("user_name"));

		}
		return sr;
	}
	
	public int AddFollower(String user_name, String usernameOfFollowing) throws SQLException
	{	
		int status = 0;
		System.out.println("Username trying to add to is" + user_name);
		System.out.println("Username tryying to follow is" + usernameOfFollowing);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("insert into following values(?, ?)");
		ps.setString(1, user_name);
		ps.setString(2, usernameOfFollowing);
		status = ps.executeUpdate();
		return status;
	}
}
