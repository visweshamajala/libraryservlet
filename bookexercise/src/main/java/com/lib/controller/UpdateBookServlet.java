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
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Bookdao dao = new Bookdao();
		
		int bookId = Integer.parseInt(request.getParameter("upId"));
		Book book=dao.searchBook(bookId);
		String updatedBookName = request.getParameter("upName");
		String updatedAuth = request.getParameter("upAuthor");
		String updatedPub = request.getParameter("upPublish");
		out.println("<html>");
		out.println("<body>");
		Book updateBook = dao.updateBookDetails(bookId, updatedBookName, updatedAuth, updatedPub);
		out.println("Name : " + updateBook.getBookName());
		out.print("<br>");
		out.println("Author : " + updateBook.getAuthor());
		out.print("<br>");
		out.println("Publisher Name : " + updateBook.getPublisher());
		out.print("<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
