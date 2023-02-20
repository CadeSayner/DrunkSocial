package database;

public interface LoginDao {
	public boolean validate(String name, String username) throws ClassNotFoundException;
}
