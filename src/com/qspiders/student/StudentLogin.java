package com.qspiders.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class StudentLogin  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
 String htmlResponse=null;
 String userName = req.getParameter("username");
 String password = req.getParameter("pwd");
 Connection con = null;
 boolean flag = false;
		 try {
			 
		    Driver driverRef = new Driver();  
		    DriverManager.registerDriver(driverRef);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			Statement sat = con.createStatement();
			ResultSet result = sat.executeQuery("select * from students_info");
					while (result.next()) {
						if(userName.equals(result.getNString(2))) {
							flag = true;
							break;
						}
						
					}
		 }catch (Exception e) {
			
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		 
		 
		 if(flag) {
         htmlResponse = "<html>"+ 
						"<title>date</title>" + 
						"<body>" + 
						"<h1> <font color = 'blue'> Welcome home page</font></h1>" + 
						"<h1> <font color = 'green'>Login is Successfull</font></h1>" + 
						"</body>"+ 
					  "</html>";
		 }else {
         htmlResponse = "<html>"+ 
					"<title>date</title>" + 
					"<body>" + 
					"<h1> <font color = 'red'> Login is failed</font></h1>" + 
					"<a href='http://localhost:8080/QstudentApp/Login.html'>Home</a> "+
					"</body>"+ 
				  "</html>";
		 }
         
         resp.setContentType("text/html");
		   resp.getWriter().write(htmlResponse);
	}

}
