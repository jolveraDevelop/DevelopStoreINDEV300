package mx.com.develop.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jr_ro
 */
public class RegistroCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        PrintWriter out = response.getWriter();
       
            out.println("<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>Develop Store: Registro</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table border='0' cellpadding='5' cellspacing='0' width='800'> \n" +
"            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> \n" +
"                <td>\n" +
"                    <h3><font color=\"white\">Develop Store: Registro de clientes.</h3>\n" +
"                </td> \n" +
"            </tr> \n" +
"            <tr align='right'> \n" +
"                <td>\n" +
"                    <b>Usted está aquí:</b> <a href=\"index.html\">Inicio</a>/Registro \n" +
"                </td> \n" +
"            </tr> \n" +
"        </table>\n" +
"        \n" +
"        <form action=\"Registro.do\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tr>\n" +
"                    <td>Nombre: </td>\n" +
"                    <td><input type=\"text\" name=\"nombre\" value=\"\" size=\"20\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Edad: </td>\n" +
"                    <td><input type=\"text\" name=\"edad\" value=\"\" size=\"3\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +"<tr>\n" +
"                    <td>Genero: </td>\n" +
"                    <td>\n" +
"                        <select name=\"genero\">\n" +
"                            <option>Masculino</option>\n" +
"                            <option>Femenino</option>\n" +
"                            <option>Otro</option>\n" +
"                        </select>\n" +
"                    </td>\n" +
"                </tr>"+
"                    <td>Dirección: </td>\n" +
"                    <td><input type=\"text\" name=\"direccion\" value=\"\" size=\"40\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Teléfono: </td>\n" +
"                    <td><input type=\"text\" name=\"telefono\" value=\"\" size=\"15\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Usuario: </td>\n" +
"                    <td><input type=\"text\" name=\"usuario\" value=\"\" size=\"20\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Contraseña: </td>\n" +
"                    <td><input type=\"password\" name=\"contrasenia\" value=\"\" size=\"20\" /></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"            <br>\n" +
"            <input type=\"submit\" value=\"Registrarse\" name=\"submit\" />\n" +
"        </form>\n" +
"    </body>\n" +
"</html>");
            
        
            out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
}
