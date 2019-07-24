package com.nis.model;

public class LoginSignUpModel {
	
	static String name;
	static String username;
	static String dob;
	static String emailid;
	static String password;
	static String conpassword;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		LoginSignUpModel.name = name;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		LoginSignUpModel.username = username;
	}
	public static String getDob() {
		return dob;
	}
	public static void setDob(String dob) {
		LoginSignUpModel.dob = dob;
	}
	public static String getEmailid() {
		return emailid;
	}
	public static void setEmailid(String emailid) {
		LoginSignUpModel.emailid = emailid;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		LoginSignUpModel.password = password;
	}
	public static String getConpassword() {
		return conpassword;
	}
	public static void setConpassword(String conpassword) {
		LoginSignUpModel.conpassword = conpassword;
	}
	
}