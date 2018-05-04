package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class CreateConnection {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/cdw_sapp?SSL=false";	
	static final String USER = "root";
	static final String PASS = "password";
	protected Connection con = null;
	protected PreparedStatement st;
	protected ResultSet rs; 	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// PreparedStatement st;
	
	
	public void createConnection() {
	  try {
		// Register JDBC DRIVER
	  Class.forName(JDBC_DRIVER);
	  // Open a connection
	 con = DriverManager.getConnection(DB_URL, USER, PASS);
	  
	  }
	  catch (ClassNotFoundException e) {
		// handle exception
		  System.out.println("class not found fo driver");
	  }
	  catch (SQLException e) {
		// handle exception
		  System.out.println("SQL exception found");
	  }	 
	}
	
	
	public void closeallconnection() {
		try {
		con.close();
		}
		catch (SQLException e) {
		 // handle exception
			System.out.println("db closed");
		}
	}
}



