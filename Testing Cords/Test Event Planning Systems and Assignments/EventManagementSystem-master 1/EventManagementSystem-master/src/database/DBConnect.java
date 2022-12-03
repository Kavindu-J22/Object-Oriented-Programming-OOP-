package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class creates the connection to the database.
 * @author blazing squad
 */
public class DBConnect {
	
	private static Connection createConnection() {
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/eventsmgmtsystem";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); /*Load MySQL Java driver*/
			
			try {
		        connection = DriverManager.getConnection(url, username, password); /*Establish Java MySQL connection*/
		    } catch (SQLException e) {
		        System.out.println("ERROR: Unable to Connect to Database.");
		    }
			
	    } catch (ClassNotFoundException e) {
	    	System.out.println("ERROR: Database Driver not found.");
	    	e.printStackTrace();
	    }
	  
	    return connection;
	}  
	
	public static Connection getConnection() {
	    return createConnection();
	}
}
