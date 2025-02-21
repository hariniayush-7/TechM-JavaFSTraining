package filters;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(
    urlPatterns = {"/WelcomeServlet"}, // Equivalent to <filter-mapping>
    initParams = { @WebInitParam(name = "appUser", value = "ayush") } // Equivalent to <init-param>
)
public class MyFilter implements Filter {
    private FilterConfig filterConfig;
    
    public void init(FilterConfig filterConfig) 
                             throws ServletException {
        this.filterConfig = filterConfig;
    }
public void doFilter(ServletRequest request, 
            ServletResponse response,FilterChain chain) 
                       throws IOException, ServletException {
response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        
        //get parameters from filterConfig object.
        String appUser = filterConfig.getInitParameter("appUser");
if(appUser.equals("ayush")){
            chain.doFilter(request, response);
        }
        else {out.print("Invalid application user.");} }  
    
    public void destroy() { } }

