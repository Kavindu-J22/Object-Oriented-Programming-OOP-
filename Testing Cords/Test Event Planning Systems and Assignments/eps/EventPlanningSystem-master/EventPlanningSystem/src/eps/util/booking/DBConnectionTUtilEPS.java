package eps.util.booking;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTUtilEPS extends CommonUtilEPS {
	private static Connection connection;

	// This works according to singleton pattern
	private DBConnectionTUtilEPS(){
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstantsEPS.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(CommonConstantsEPS.URL),
					properties.getProperty(CommonConstantsEPS.USERNAME), properties.getProperty(CommonConstantsEPS.PASSWORD));
		}
		return connection;
	}

}
