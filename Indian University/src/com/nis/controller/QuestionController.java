package com.nis.controller;

import java.sql.Connection;

import com.nis.model.QuestionModel;

public class QuestionController {

	public static boolean addNewRecord(QuestionModel Q)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into questions(subjectid,year,questionno,q1,q2,q3) values("+Q.getSubjectid()+","+Q.getYear()+","+Q.getQuestionno()+",'"+Q.getQ1()+"','"+Q.getQ2()+"','"+Q.getQ3()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("Error  [QuestionController addNewRecord]"+e);
			return(false);
		}
		}
	
}
