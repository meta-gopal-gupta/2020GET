package com.metacube.training.session;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Session extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse responce) throws IOException{
//		HttpSession session=request.getSession();  
//		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		try {
//			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
//			Statement stmt = con.createStatement();
//			ResultSet result = stmt.executeQuery(String.format("SELECT * FROM user WHERE 	email='%s' AND password='%s'",email,password));
//			
//			session.setAttribute("userId",result.getString("id"));
//	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
