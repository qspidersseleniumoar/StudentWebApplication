package com.qspiders.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Date extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   String currentDate = new java.util.Date().toString();
		   
		   String htmlResponse = "<html>"+ 
		   							"<title>date</title>" + 
		   							"<body>" + 
		   							"<h1>System Date is :  <font color = 'red'>"+currentDate+"</font></h1>" + 
		   							"</body>"+ 
		   						"</html>";
		   resp.setHeader("refresh", "1");
		   resp.setContentType("text/html");
		   resp.getWriter().write(htmlResponse);
	}

}
