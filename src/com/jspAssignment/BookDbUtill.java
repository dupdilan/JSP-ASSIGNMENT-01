package com.jspAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class BookDbUtill  {
	
	private DataSource dataSource;
	
    public BookDbUtill(DataSource theDataSource) {
        dataSource = theDataSource;
        // TODO Auto-generated constructor stub
    }
    
    public List<Book> getBooks() throws Exception {
		List<Book> books = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
		//Establishing the connection
			myConn = dataSource.getConnection();
		
		//sql query
			String sql = "select * from book";
			myStmt = myConn.createStatement();
		
		//executing the query
			myRs = myStmt.executeQuery(sql);
		
		//process result set
			while(myRs.next()) {
				
				//recive data
				int id = myRs.getInt("book_id");
				String title = myRs.getString("title");
				String author = myRs.getString("author");
				int cost = myRs.getInt("costPrice");
				int sales = myRs.getInt("salesPrice");
					
				//create a new book object
				Book BookObj = new Book (id,title,author,cost,sales);
					
				//add  it to the list of books 
				books.add(BookObj);
				
			}
					
			
			return books;
		}
		finally {
			
			//close JDBC objects
			close(myConn, myStmt , myRs);
			
			
		}
		
	}
    
    
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		
		try {
			
			if(myRs !=null) {
				myRs.close();
			}
			
			if(myStmt !=null) {
				myStmt.close();
			}
			
			if(myConn !=null) {
				myConn.close();
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
    
    public void addBook(Book theBook) throws Exception{
		// TODO Auto-generated method stub

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into book "
					   + "(title, author, costPrice,salesPrice)"
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theBook.getTitle());
			myStmt.setString(2, theBook.getAuthor());
			myStmt.setInt(3, theBook.getCost());
			myStmt.setInt(4, theBook.getSales());
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}		
		
	}
    
    public void deleteBook(int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from book where book_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, id);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}



}
