package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

public class SubjectController {
	public static boolean addNewRecord(SubjectModel S)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into subject(branchid,subjectname,semester,remark) values('"
					+S.getBranchid()+"','"+S.getSubjectname()+
					"','"+S.getSemester()+"','"+S.getRemark()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [SubjectController addNewRecord] "+e);
			return(false);
		}
	}

	public static boolean deleteRecord(int sid)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="delete from subject where subjectid="+sid;
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [SubjectController deleteRecord]"+e);
			return(false);
		}
	}
	public static boolean editRecord(SubjectModel S)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update subject set subjectname='"+S.getSubjectname()+"',semester='"+S.getSemester()
			+"',remark='"+S.getRemark()+"',branchid='"+S.getBranchid()+
					"' where Subjectid="+S.getSubjectid();
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [SubjectController editRecord]"+e);
			return(false);
		}
	}
	
	public static ResultSet displayAll()
	{try{ Connection cn=DBHelper.openConnection();
	String query="select s.subjectid,s.subjectname,s.branchid,(select b.branchname from branch "
			+ "b where b.branchid=s.branchid)as bname,s.semester,s.remark from"
			+ " subject s";
	ResultSet rs=DBHelper.executeQuery(cn, query);
		return(rs);
	}catch(Exception e){
	System.out.println("Error [displayAll]:"+e);
	return(null);
	}
	}
	public static SubjectModel displayById(int sid)
	{try{ Connection cn=DBHelper.openConnection();
	String query="select s.subjectid,s.subjectname,s.branchid,(select b.branchname from branch "
			+ "b where b.branchid=s.branchid)as bname,s.semester,s.remark from"
			+ " subject s where s.subjectid="+sid;
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{ SubjectModel S=new SubjectModel();
	  S.setSubjectid(sid);
	 S.setSubjectname(rs.getString(2));
      S.setBranchid(rs.getString(3)+","+rs.getString(4));
	  S.setSemester(rs.getString(5));
	  S.setRemark(rs.getString(6));
	  
	  return(S);
	}
	return(null);

	}catch(Exception e){
	System.out.println("Error [SubjectController displayById]:"+e);
	return(null);
	}
}
	public static ResultSet displaySubjectBySem(int ssem,int bid)
	{try{ Connection cn=DBHelper.openConnection();
	String query="select s.subjectid,s.subjectname from"
			+ " subject s where s.semester="+ssem+" and s.branchid="+bid;
	ResultSet rs=DBHelper.executeQuery(cn, query);
		return(rs);
	}catch(Exception e){
	System.out.println("Error [displayAll]:"+e);
	return(null);
	}
	}
	
	
}