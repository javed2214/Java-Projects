package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class StateCityController {
	 
    public static  ResultSet getAllStates()
    {try{
    	Connection cn=DBHelper.openConnection();
    	
    	ResultSet rs=DBHelper.executeQuery(cn,"select * from states");
         return rs;
    }catch(Exception e){
    System.out.println(e);
    return null;
    }
    }
    	
    public static  ResultSet getAllCities(int stateid)
    {try{
    	Connection cn=DBHelper.openConnection();
    	
    	ResultSet rs=DBHelper.executeQuery(cn,"select * from cities where stateid="+stateid);
         return rs;
    }catch(Exception e){
    System.out.println(e);
    return null;
    } 	
    
    
    }

}
