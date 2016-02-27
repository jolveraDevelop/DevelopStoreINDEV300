package mx.com.develop.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("Parametro de inicio roberto: "+
                 this.getServletConfig().getInitParameter("roberto"));
          System.out.println("version: "+
                this.getServletContext().getInitParameter("version"));
        //validar usurio y contraseña
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        Enumeration<String> usuariosValidos 
                = this.getServletConfig().getInitParameterNames();
        while (usuariosValidos.hasMoreElements()) {
            String nextElement = usuariosValidos.nextElement();
            if(nextElement.equalsIgnoreCase(usuario)){
                if(this.getServletConfig().getInitParameter(usuario)
                        .equals(contrasenia)){
                    request.setAttribute("userName", usuario);
                    request.getRequestDispatcher("index.jsp").
                            forward(request, response);
                }
            }
        }
//      redirigir a error login
        
    }
    
    

}
