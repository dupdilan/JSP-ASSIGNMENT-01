package com.jspAssignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Resource(name="jdbc/bookstore")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			myConn = dataSource.getConnection();
			String sql = "select * from book";
			myStmt = myConn.createStatement();
			
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				String title = myRs.getString("title");
				out.println(title);
				String author = myRs.getString("author");
				out.println(author);
				String costPrice = myRs.getString("costPrice");
				out.println(costPrice);
				String salesPrice = myRs.getString("salesPrice");
				out.println(salesPrice);
				
			}
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}


}
