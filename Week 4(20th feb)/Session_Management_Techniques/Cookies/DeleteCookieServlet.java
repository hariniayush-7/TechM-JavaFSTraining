package Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {
  
    protected void doPost(HttpServletRequest request, 
       HttpServletResponse response)
                    throws ServletException, IOException {
    response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
try{
            Cookie cookies[] = request.getCookies();
            out.print("Deleted cookie are:");
            for(Cookie cookie : cookies){
               cookie.setMaxAge(0);
               out.println("Cookie name: " + cookie.getName());}
            out.close();  
        }catch(Exception e){
            e.printStackTrace();}}}