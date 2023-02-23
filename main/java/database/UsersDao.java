package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UsersDao {
	public HashMap<String, String> getUserData(String name)
	{
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
			java.sql.Statement stmt = con.createStatement();
			String StrStatement = "select * from users where user_name = " + "\"" + name + "\"";
			ResultSet rs = stmt.executeQuery(StrStatement);
			
			while(rs.next())
			{
				data.put("Drinks", ((Integer)rs.getInt("user_num_drinks_total")).toString());
				data.put("DrinkYears", ((Integer)rs.getInt("user_num_drink_years")).toString());
				data.put("Age", ((Integer)rs.getInt("user_age")).toString());
				data.put("Weight Class", rs.getString("user_weightclass"));
			}
			System.out.println(data);
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		
		return data;
	}
	
	public int AddDrinks(int noDrinks, String name) throws SQLException
	{	
		int status = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("update users set user_num_drinks_total = user_num_drinks_total + ? where user_name = ? ");
		ps.setInt(1, noDrinks);
		ps.setString(2, name);
		status = ps.executeUpdate();
		return status;
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
}
