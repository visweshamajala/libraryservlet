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

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Bookdao dao = new Bookdao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Book book = dao.searchBook(Integer.parseInt(request.getParameter("sbid")));
		if(book!=null)
		{
			out.println("Book Id : "+book.getBookId());
			out.println("Book Name : "+book.getBookName());
			out.println("Author of Book : "+book.getAuthor());
			out.println("Publisher of Book : "+book.getPublisher());
		}
		else {
			out.println("enter valid id");
		}
		
	}

}
