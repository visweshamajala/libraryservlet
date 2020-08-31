package com.lib.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.Bookdao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bookdao dao = new Bookdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		dao.deleteBook(Integer.parseInt(request.getParameter("delid")));
		out.println("Book Deleted");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
