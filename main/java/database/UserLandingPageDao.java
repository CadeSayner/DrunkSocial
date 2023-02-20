package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mysql.cj.xdevapi.Statement;
import jakarta.servlet.http.HttpSession;

public class UserLandingPageDao {
	public HashMap<String, String> getData(String name)
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
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		
		return data;
	}
}
