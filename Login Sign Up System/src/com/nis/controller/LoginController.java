package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nis.model.LoginSignUpModel;

public class LoginController {

	static String url="jdbc:mysql://localhost:3306/loginsignupsystem";
	static String uname="root";
	static String pwd="123";

	
	public static LoginSignUpModel checkRecord(String username, String password)
	
	{
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(url, uname, pwd);
			
		//	String query="select * from login where username='"+username+"'";	
		//	String query="select username, password from login where username='"+username+"'";
			
			String query = "select * from login where username='"+ username + "' and password='" + password + "'";
			
			Statement smt=cn.createStatement();
			
			ResultSet rs=smt.executeQuery(query);
			
      				if(rs.next())
					{
      					
      				LoginSignUpModel L=new LoginSignUpModel();
					L.setUsername(rs.getString(3));
					L.setPassword(rs.getString(6));
					
					if(username.equalsIgnoreCase(username)&&password.equals(password))
					{
						return L;
					         }
					else
					{
						return null;
								}
					
					                 }
			
		return null;
			   
			 }
		
		catch(Exception e)
		{
			System.out.println("Error [Login Controller] "+e);
			return null;
			
		}
		
	}
	     }

