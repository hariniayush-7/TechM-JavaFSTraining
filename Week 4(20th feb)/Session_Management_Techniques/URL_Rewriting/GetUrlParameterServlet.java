package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUrlParameterServlet
 */
@WebServlet("/GetUrlParameterServlet")
public class GetUrlParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, 
         HttpServletResponse response)
                  throws ServletException, IOException {
    response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();

//get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();
        
        out.println("Username: " + userName + "");
        out.println("Password: " + password);       
        out.close();    }}