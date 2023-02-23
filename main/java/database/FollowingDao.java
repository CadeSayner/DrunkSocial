package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FollowingDao {
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
