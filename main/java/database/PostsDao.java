package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.ResultSet;

public class PostsDao {
	public JSONArray getFeedPosts(String user_name) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("select * from following as f inner join posts as p on (f.user_name_following = p.user_name and f.user_name=?)");
		ps.setString(1, user_name);
		ResultSet rs = ps.executeQuery();
		return convert(rs);
	}
		
	public JSONArray convert(ResultSet resultSet) throws Exception {
	 
	    JSONArray jsonArray = new JSONArray();
	 
	    while (resultSet.next()) {
	 
	        int columns = resultSet.getMetaData().getColumnCount();
	        JSONObject obj = new JSONObject();
	 
	        for (int i = 0; i < columns; i++)
	            obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
	 
	        jsonArray.put(obj);
	    }
	    return jsonArray;
	}
	
	public int AddPost(String username, String nameOfDrink, int drinkQty, String loc) throws SQLException
	{	
		int status = 0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasted", "root", "Kakkakkak@123");
		PreparedStatement ps = con.prepareStatement("insert into posts (user_name, post_date_time, post_drink, post_drink_quantity, post_location) values (?, ?, ?, ?, ?);");
		ps.setString(1, username);
		ps.setString(2, new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
		ps.setString(3, nameOfDrink);
		ps.setInt(4, drinkQty);
		ps.setString(5, loc);
		status = ps.executeUpdate();
		return status;
	}
}
