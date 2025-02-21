package Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response)
                      throws ServletException, IOException {
    response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
try{
           Cookie cookies[] = request.getCookies();
           for(Cookie cookie : cookies){
            out.println("Cookie Name: " + cookie.getName());
            out.println("Cookie Value: " + cookie.getValue());
            out.println("");
out.println("Click on the below button to delete cookies.");
          out.print("<form action=DeleteCookieServlet method=POST>");
          out.print("<input type=submit value=Delete Cookies>");
          out.print("</form>");
          out.close();
          }}
           
           catch(Exception e){
            e.printStackTrace();} }}