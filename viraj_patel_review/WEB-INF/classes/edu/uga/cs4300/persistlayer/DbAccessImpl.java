package edu.uga.cs4300.persistlayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// The DbAccessImpl Class is designed to Connect to a mysql

public class DbAccessImpl extends DbAccessConfiguration implements DbAccessInterface  {

// Connect: Returns a Connection 
	
	
	public static Connection connect() {
		
		// Initialize Connection
		Connection con = null;

		try {
			
			// Generate a new MySQL Driver instance
			Class.forName(DB_DRIVE_NAME).newInstance();
			
			// Get a new connection from the Driver Manager
			con = DriverManager.getConnection(CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);

			// Debugging tool
			System.out.println("Database connection established");

		}

		catch (Exception e) {
			
			// Debugging tool
			System.err.println("Cannot connect to server");

			System.err.println(e);
		}

		return con;

	} // end of connection 
	
	
	
//........................................................................................

	

// disconnect: Closes a connection
public  void disconnect(Connection con) {

		if (con != null) {
			try {

				con.close();
				
				//Debugging tool
				System.out.println("Database connection terminated");

			}
			catch (Exception e) {}
		} // end of if statement 
		
		
	} // end of disconnect
	
	
//........................................................................................

	
	
// Retrieve: Returns a ResultSet 
public static  ResultSet retrieve(Connection con, String query) {

		// Initialize
		ResultSet result = null;

		try {

			// Create Statement Object
			Statement state = con.createStatement();
			
			// Execute the String Query
			result = state.executeQuery(query);

		} catch (SQLException e) {
			System.err.println(e);
		}

		return result;

	} // end of ResultSet


//........................................................................................


// Execute Method: Execute a command in SQL. Returns nothing
public static void execute(Connection conn, String query) throws SQLException {

		//Create Statement
		Statement state;

		try {
			
			// Execute Statement
			state = conn.createStatement();
			state.execute(query);
			state.close();

		} catch (SQLException e) {

			System.err.println(e);
		}
	} // end of execute

//........................................................................................



} // end of class 




