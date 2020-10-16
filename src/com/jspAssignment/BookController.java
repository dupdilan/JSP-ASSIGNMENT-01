package com.jspAssignment;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;


/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookDbUtill bookDbUtil;
	
	@Resource(name="jdbc/bookstore")
	private DataSource dataSource;
	
    
    @Override
	public void init() throws ServletException {	
		super.init();
		try {
			
			bookDbUtil = new BookDbUtill(dataSource);
			
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			// read the "command" parameter
						String theCommand = request.getParameter("command");
									
									// if the command is missing, then default to listing Books
									if (theCommand == null) {
										theCommand = "LIST";									
									}
									
									// route to the appropriate method
									switch (theCommand) {
									
									case "LIST":
										listBooks(request, response);
										break;
										
									case "ADD":
										addBook(request, response);
										break;
										
									case "DELETE":
										deleteBook(request, response);
										break;
									default:
										listBooks(request, response);
									}
									
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int id1=Integer.parseInt(id);
		
		// delete Book from database
					bookDbUtil.deleteBook(id1);
					
					// send back to main page
					listBooks(request, response);
	}


	private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("txtBookTitle");
		String author = request.getParameter("txtBookAuthor");
		String cost = request.getParameter("txtCostPrice");
		int cost1=Integer.parseInt(cost); 
		String sales = request.getParameter("txtSalesPrice");
		int sales1=Integer.parseInt(sales); 
				// create a new book object
		Book theBook = new Book(title,author,cost1,sales1);
				// add the book to the database
		
			bookDbUtil.addBook(theBook);
								
				// send back to main page
		listBooks(request, response);
		
	}


	private void listBooks(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			//get Books from dbutill
			List<Book> books = bookDbUtil.getBooks();
			
			//add books to the request
			request.setAttribute("BOOK_LIST", books);
			
			//send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-books.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
