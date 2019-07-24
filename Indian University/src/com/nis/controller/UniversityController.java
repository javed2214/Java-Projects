package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.UniversityModel;

public class UniversityController {

public static boolean addNewRecord(UniversityModel U)
{ try{
   Connection cn=DBHelper.openConnection();
   String query="insert into university(universityname,estyear,address,state,city,contactperson,mobileno,emailid,description,logo) values('"+U.getUniversityname()+"','"+U.getEstyear()+"','"+U.getAddress()+"','"+U.getState()+"','"+U.getCity()+"','"+U.getContactperson()+"','"+U.getMobileno()+"','"+U.getEmailid()+"','"+U.getDescription()+"','"+U.getLogo()+"')";
   boolean st=DBHelper.executeUpdate(cn, query);
   return(st);
}catch(Exception e){
 System.out.println("Error [addNewRecord] "+e);	
 return(false);
}}
public static ResultSet displayAll()
{try{ Connection cn=DBHelper.openConnection();
String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state)as ustate,u.city,(select c.cityname from cities c where c.cityid=u.city) as ucity,u.contactperson,u.mobileno,u.emailid,u.description,u.logo from university u";
ResultSet rs=DBHelper.executeQuery(cn, query);
	return(rs);
}catch(Exception e){
System.out.println("Error [displayAll]:"+e);
return(null);
}
}
public static UniversityModel displayById(int uid)
{try{ Connection cn=DBHelper.openConnection();
String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state)as ustate,u.city,(select c.cityname from cities c where c.cityid=u.city) as ucity,u.contactperson,u.mobileno,u.emailid,u.description,u.logo from university u where u.universityid="+uid;
ResultSet rs=DBHelper.executeQuery(cn, query);
if(rs.next())
{ UniversityModel U=new UniversityModel();
  U.setUniversityid(uid);
  U.setUniversityname(rs.getString(2));
  U.setEstyear(rs.getString(3));
  U.setAddress(rs.getString(4));
  U.setState(rs.getString(5)+","+rs.getString(6));
  U.setCity(rs.getString(7)+","+rs.getString(8));
  U.setContactperson(rs.getString(9));
  U.setMobileno(rs.getString(10));
  U.setEmailid(rs.getString(11));
  U.setDescription(rs.getString(12));
  U.setLogo(rs.getString(13));
  return(U);
}
return(null);

}catch(Exception e){
System.out.println("Error [displayAll]:"+e);
return(null);
}
 	}
public static boolean editRecord(UniversityModel U)
{ try{
   Connection cn=DBHelper.openConnection();
    String query="update university set universityname='"+U.getUniversityname()+"',estyear='"+U.getEstyear()+"',address='"+U.getAddress()+"',state='"+U.getState()+"',city='"+U.getCity()+"',contactperson='"+U.getContactperson()+"',mobileno='"+U.getMobileno()+"',emailid='"+U.getEmailid()+"',description='"+U.getDescription()+"' where universityid="+U.getUniversityid();
    
   boolean st=DBHelper.executeUpdate(cn, query);
   return(st);
}catch(Exception e){
 System.out.println("Error [editRecord] "+e);	
 return(false);
}}
public static boolean deleteRecord(int uid)
{ try{
   Connection cn=DBHelper.openConnection();
    String query="delete from university where universityid="+uid;
    System.out.println(query);
   boolean st=DBHelper.executeUpdate(cn, query);
   return(st);
}catch(Exception e){
 System.out.println("Error [deleteRecord] "+e);	
 return(false);
}}
public static boolean updatePicture(int uid,String file)
{ try{
   Connection cn=DBHelper.openConnection();
    String query="update  university set logo='"+file+"' where universityid="+uid;
    System.out.println(query);
   boolean st=DBHelper.executeUpdate(cn, query);
   return(st);
}catch(Exception e){
 System.out.println("Error [UpdatePicture] "+e);	
 return(false);
}}

public static ResultSet displayByPattern(String pat)
{try{ Connection cn=DBHelper.openConnection();
String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state)as ustate,u.city,(select c.cityname from cities c where c.cityid=u.city) as ucity,u.contactperson,u.mobileno,u.emailid,u.description,u.logo from university u where u.universityname like '%"+pat+"%'";
//or u.ucity like '%"+pat+"%'";
ResultSet rs=DBHelper.executeQuery(cn, query);
	return(rs);
}catch(Exception e){
System.out.println("Error [displayAll]:"+e);
return(null);
}
}

 }


