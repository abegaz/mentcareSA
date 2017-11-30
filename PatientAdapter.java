package com.mentCare.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientAdapter
{
	private static Connection myConn;
	private static final String USERNAME = "root";
	//password is "dumb" for me. Probably different for you
	private static final String PASSWORD = "dumb";
	private static final String CONN_STRING = "jdbc:mysql://localhost/mentcareDB";

	// connection  method that connects us to the MySQL database
	public static Connection getConnection() throws SQLException{
		System.out.println("Connected to MentCare database successfully!");
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}

	// method that displays our errors in more detail if connection fails
	public static void displayException(SQLException ex){

		System.err.println("Error Message: " + ex.getMessage());
		System.err.println("Error Code: " + ex.getErrorCode());
		System.err.println("SQL Status: " + ex.getSQLState());

	}
	public static void connect()
	{
		try
		{
//			String host = "jdbc:mysql://localhost/mentcareDB";
//			String userName = "root";
//			String userPass = "dumb";
//			if (myConn != null && !myConn.isClosed())
//				myConn.close();
		Connection myConn = getConnection();
		
		}
		catch(SQLException err)
		{
			System.out.println(err.getMessage( ));
		}
	}
	public static ResultSet getResultSet(String tableName)
	{
		ResultSet MyResultSet=null;
		try
		{
			Statement myStat = myConn.createStatement();
			MyResultSet = myStat.executeQuery("SELECT * FROM "+tableName);
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
		return MyResultSet;
	}
}