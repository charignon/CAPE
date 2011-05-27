package com.sdz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisconnectServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		request.getSession().invalidate();
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}	
	
}
