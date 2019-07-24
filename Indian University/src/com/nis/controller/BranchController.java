package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.BranchModel;
import com.nis.model.UniversityModel;

public class BranchController {

	public static boolean addNewRecord(BranchModel B)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into branch(universityid,branchname,semester,icon) values('"
			+B.getUniversity()+"','"+B.getBranchname()+"','"+B.getSemester()+"','"+B.getIcon()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [BranchController addNewRecord]"+e);
			return(false);
		}
		}
	public static boolean deleteRecord(int bid)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="delete from branch where branchid="+bid;
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [BranchController deleteRecord]"+e);
			return(false);
		}
	}
	public static boolean editRecord(BranchModel B)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update branch set Branchname='"+B.getBranchname()+"',semester='"+B.getSemester()
			+"',universityid='"+B.getUniversity()+
					"' where Branchid="+B.getBranchid();
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [BranchController editRecord]"+e);
			return(false);
		}
	}
	public static boolean updatePicture(int bid,String file){
		try{
			Connection cn=DBHelper.openConnection();
			String query="update  branch set icon='"+file+"' where branchid="+bid;
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
			}
		catch(Exception e){
            System.out.println("Error [BranchController   -updatePicture ]");
			return(false);
		}
		}

	public static ResultSet displayAll()
	{try{ Connection cn=DBHelper.openConnection();
	String query="select b.branchid,b.universityid,(select u.universityname from university "
			+ "u where u.universityid=b.universityid)as buniversityname,b.branchname,b.semester,b.icon from"
			+ " branch b";
	ResultSet rs=DBHelper.executeQuery(cn, query);
		return(rs);
	}catch(Exception e){
	System.out.println("Error [displayAll]:"+e);
	return(null);
	}
	}
	public static BranchModel displayById(int bid)
	{try{ Connection cn=DBHelper.openConnection();
	String query="select b.branchid,b.universityid,(select u.universityname from university "
			+ "u where u.universityid=b.universityid)as buniversityname,b.branchname,b.semester,b.icon from"
			+ " branch b where b.branchid="+bid;
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{ BranchModel B=new BranchModel();
	  B.setBranchid(bid);
	  B.setUniversity(rs.getString(2)+","+rs.getString(3));;
      B.setBranchname(rs.getString(4));
	  B.setSemester(rs.getString(5));
      B.setIcon(rs.getString(6));
	  return(B);
	}
	return(null);

	}catch(Exception e){
	System.out.println("Error [displayById]:"+e);
	return(null);
	}
	 	}
public static ResultSet getAllBranch(int universityid){
		try{Connection cn=DBHelper.openConnection();
		ResultSet rs=DBHelper.executeQuery(cn, "select branchid,branchname from branch where universityid="+universityid);
			return rs;}
catch(Exception e){
	System.out.println("Error  [UniversityController - getAllBranch]"+e);
   return null;
}
}

public static ResultSet getSemesterByBranchId(int bid)
{try{ Connection cn=DBHelper.openConnection();
String query="select b.branchid,b.universityid,(select u.universityname from university "
		+ "u where u.universityid=b.universityid)as buniversityname,b.branchname,b.semester,b.icon from"
		+ " branch b where b.branchid="+bid;
ResultSet rs=DBHelper.executeQuery(cn, query);
 
return(rs);

}catch(Exception e){
System.out.println("Error [displayById]:"+e);
return(null);
}
 	}

	}


