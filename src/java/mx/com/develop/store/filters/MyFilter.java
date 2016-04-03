package mx.com.develop.store.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter: init(FilterConfig filterConfig)");
    }

    @Override
    public void doFilter(ServletRequest request, 
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("MyFilter: doFilter(ServletRequest request,"
                + " ServletResponse response, FilterChain chain)");
        //request.getRequestDispatcher("login.jsp").forward(request, response);
        System.out.println("PreProcesing");
        System.out.println("Algo: "+request.getAttribute("algo"));
        chain.doFilter(request, response);
        System.out.println("PostProcesing");
        System.out.println("Algo: "+request.getAttribute("algo"));
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter: destroy()");
    }
   
}
