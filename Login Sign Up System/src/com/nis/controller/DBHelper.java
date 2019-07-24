package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	
	static String url="jdbc:mysql://localhost:3306/loginsignupsystem";
	static String username="root";
	static String password="123";
	
	public static Connection openConnection()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(url,username,password);
		return cn;
		}
		catch(Exception e)
		{
			System.out.println("Error [Open Connection] "+e);
			return null;
		}
		
	}
	
	public static boolean executeUpdate(Connection cn, String query)
	{
		try{
			Statement smt=cn.createStatement();
			smt.executeUpdate(query);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error [Execute Update] "+e);
			return false;
		}
	}
	
	public static ResultSet executeQuery(Connection cn, String query)
	{
		try
		{
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery(query);
			return rs;
		}
		catch(Exception e)
		{
			System.out.println("Error [Execute Query] "+e);
			return null;
		}
	}
	
}
