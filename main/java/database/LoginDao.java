package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public boolean validate(String name, String password) throws ClassNotFoundException {
		boolean status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
			PreparedStatement ps = con.prepareStatement("select * from login where user_name=? and user_password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			return status;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return status;
	}
	
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
}
