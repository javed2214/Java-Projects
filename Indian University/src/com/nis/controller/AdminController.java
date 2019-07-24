package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.AdminModel;

public class AdminController {
	public static AdminModel checkLogin(String aid,String pwd)
	{try{ Connection cn=DBHelper.openConnection();
	String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
	
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{AdminModel A=new AdminModel();
	A.setAdminid(aid);
	A.setAdminname(rs.getString(2));
	A.setPicture(rs.getString(4));
	return(A);
		
	}
	else
	{return(null);
		
	}
	}catch(Exception e){
	System.out.println("Error [displayAll]:"+e);
	return(null);
	}
	}
	
	
}
