package com.lib.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.Bookdao;
import com.lib.model.Book;
import com.lib.model.Library;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/add")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bookdao dao = new Bookdao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String libname = request.getParameter("library");
		Library library = dao.getLibrary(libname);
		 
		Book b = new Book();
		
		b.setLibrary(library);
		b.setBookId(Integer.parseInt(request.getParameter("bid")));
		b.setBookName(request.getParameter("bname"));
		b.setAuthor(request.getParameter("auth"));
		b.setPublisher(request.getParameter("publish"));
		
		dao.addBook(b);
		out.println("added book to db");
	}

}
