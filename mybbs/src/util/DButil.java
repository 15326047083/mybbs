package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	private static DButil instance = new DButil();
	
	private Connection connection;
	
	private DButil(){}
	
	public static DButil getInstance(){
		return instance;
	}
	
	public Connection getConnetion() throws SQLException{
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sc", "root", "root");
		return connection;
	}
	
	public void closeConnection(){
		try {
			if(!connection.isClosed()){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
