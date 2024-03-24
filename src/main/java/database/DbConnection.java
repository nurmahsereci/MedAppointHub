package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class representing database connection utility
public class DbConnection {
	
	// Static connection instance to ensure single connection throughout the application
	private static Connection connection;
	
	// Private constructor to prevent instantiation of the class
	private DbConnection() {
		
	}
	
	// Static method to return JDBC connection for database tasks
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
		
        // Load MySQL JDBC driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Check if connection is null or closed, then create a new connection
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project" , "root","password");
        }
        
        // Return the database connection
        return connection;
	}
}
