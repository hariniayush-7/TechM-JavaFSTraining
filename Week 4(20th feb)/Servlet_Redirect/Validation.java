package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/loginPage")
public class Validation extends HttpServlet 
{    
   private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, 
     HttpServletResponse response) 
       throws ServletException, IOException 
   {
response.setContentType("text/html");      
       PrintWriter pwriter = response.getWriter();                
       String name=request.getParameter("uname");      
       String pass=request.getParameter("upass");
if(name.equals("ayush") && 
          pass.equals("book"))
       {          
          RequestDispatcher dis=request.getRequestDispatcher("welcome");          
          dis.forward(request, response);      
       }

else
       {      
          pwriter.print("User name or password is incorrect!");          
          RequestDispatcher dis=request.getRequestDispatcher("index.html");          
          dis.include(request, response);                                }}}                       