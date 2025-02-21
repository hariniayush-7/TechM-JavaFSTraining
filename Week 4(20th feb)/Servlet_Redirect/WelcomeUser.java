package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class WelcomeUser extends HttpServlet { 
	 
	 private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
	 HttpServletResponse response) 
	 throws ServletException, IOException 
	 {

	
	response.setContentType("text/html"); 
	    PrintWriter pwriter = response.getWriter(); 
	 
	    String name=request.getParameter("uname"); 
	    pwriter.print("Hello "+name+"!");
	    pwriter.print(" Welcome to Beginnersbook.com");}}