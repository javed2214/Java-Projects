package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


import com.nis.controller.DBHelper;
import com.nis.controller.SubjectController;

/**
 * Servlet implementation class GetAllSubjectsJSON
 */
@WebServlet("/GetAllSubjectsJSON")
public class GetAllSubjectsJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllSubjectsJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=SubjectController.displaySubjectBySem(Integer.parseInt(request.getParameter("semester")),Integer.parseInt(request.getParameter("bid")));
		ArrayList<JSONObject> S=DBHelper.JsonEngine(rs);
		out.println(S);
	}

}
