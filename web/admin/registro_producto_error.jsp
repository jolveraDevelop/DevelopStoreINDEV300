<%-- 
    Document   : registro_productos_error
    Created on : Apr 11, 2014, 2:45:04 PM
    Author     : Humberto
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Error </title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Error</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <td><a href="">Login</a></td>
                            <td><a href="">Regístrate</a></td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/<a href="index.jsp">Admin</a>/<a href="registro_producto.jsp">Registro Productos</a>/Error
        <h3>Corrige los siguientes errores:</h3>
        <% List<String> listaErrores = (List<String>) request.getAttribute("listaErrores");%>
        <font color="red">
        <ul>
            <%
                for (String error : listaErrores) {
            %>
            <li>
                <%=error%>
            </li>
            <%}%>
        </ul>
        </font>
    </body>
</html>
