package com.mentCare.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientAdapter
{
	private static Connection myConn;
	public static void connect()
	{
		try
		{
			String host = "jdbc:mysql://localhost:3306/mentcareDB";
			String userName = "root";
			String userPass = "";
			if (myConn != null && !myConn.isClosed())
				myConn.close();
			myConn = DriverManager.getConnection(host, userName, userPass);
			System.out.println("Connection Error");
		}
		catch(SQLException err)
		{
			System.out.println(err.getMessage( ));
		}
	}
	public static void addRow(String tableName, String fieldNames, String values)
	{
		String sql = "INSERT INTO "+tableName+" ("+fieldNames+") VALUES ("+values+");";
		try
		{
			PreparedStatement pr = myConn.prepareStatement(sql);
			pr.execute();
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
	}
	public static void updateRow(String tableName, String values, String userIdNumber)
	{
		//UPDATE [table name] SET [VALUES] WHERE 'idNumber' = "userIdNumber";
		String sql = "UPDATE "+tableName+" SET "+values+" WHERE idNumber = "+userIdNumber+"";
		try
		{
			PreparedStatement pr = myConn.prepareStatement(sql);
			pr.execute();
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
	}
	public static void injection(String injection)
	{
		try
		{
			PreparedStatement pr = myConn.prepareStatement(injection);
			pr.execute();
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
	}

	public static void deleteRow(String tableName, String fieldName, String matching)
	{
		String sql = "DELETE FROM "+tableName+" WHERE "+fieldName+" = '"+matching+"';";
		try
		{
			PreparedStatement pr = myConn.prepareStatement(sql);
			pr.execute();
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
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
	public static ResultSet getResultSetRow(String tableName, String fieldName, String matching)
	{
		ResultSet MyResultSet=null;
		try
		{
			Statement myStat = myConn.createStatement();
			MyResultSet = myStat.executeQuery("SELECT * FROM "+tableName);
			while (MyResultSet.next())
			{
				if (MyResultSet.getString(fieldName).equals(matching))
				{
					MyResultSet.absolute(MyResultSet.getRow());
					break;
				}
			}
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
		return MyResultSet;
	}



	///////////////////////////////////////////////////// NOT USED ////////////////////////////////////////////////////////////////////////////
	public static int getInt(String tableName, String fieldName, String whatever, String searchValue)
	{
		//SELECT * FROM [table name] WHERE [field name] = "whatever";
		int number = 0;
		try
		{
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM "+tableName);
			while (myRs.next())
			{
				if (myRs.getString(fieldName).equals(whatever))
				{
					number = myRs.getInt(searchValue);
					break;
				}
			}
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
		return number;
	}
	public static String getString(String tableName, String fieldName, String whatever, String searchValue)
	{
		//SELECT * FROM [table name] WHERE [field name] = "whatever";
		String str="";
		try
		{
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM "+tableName);
			while (myRs.next())
			{
				if (myRs.getString(fieldName).equals(whatever))
				{
					str = myRs.getString(searchValue);
					break;
				}
			}
		}
		catch (SQLException err)
		{
			System.out.println( err.getMessage( ) );
		}
		return str;
	}
}