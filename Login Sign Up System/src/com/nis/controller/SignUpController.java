package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import com.nis.model.LoginSignUpModel;

public class SignUpController {

	static String url="jdbc:mysql://localhost:3306/loginsignupsystem";
	static String username="root";
	static String password="123";
	
	public static boolean addRecord(LoginSignUpModel L)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(url, username, password);
			String query="insert into login (name,username,dob,emailid,password) values('"+L.getName()+"','"+L.getUsername()+"','"+L.getDob()+"','"+L.getEmailid()+"','"+L.getPassword()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Error[Add Record] "+e);
			return false;
		}
	}
	
}
