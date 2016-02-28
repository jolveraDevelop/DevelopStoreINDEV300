<%-- 
    Document   : index
    Created on : 21/02/2016, 11:16:47 AM
    Author     : jr_ro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Inicio</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Inicio</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <td><a href="login.html">Login</a></td>
                            <td><a href="registro_cliente.html">Regístrate</a>
                            </td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <h2>Bienvenido a DEVELOP Store ${sessionScope.cliente.nombre}</h2>
        <h2>Bienvenido a DEVELOP Store <%= request.getSession()
                                            .getAttribute("cliente") %></h2>
        
        Con request: <%= request.getHeader("Accept") %> <br>
        Con EL uso invalido: ${requestScope.header["Accept"]}<br>
        Con EL uso valido como array: ${header["Accept"]}<br> 
        Con EL uso valido como map: ${header.Accept}<br> 
       
        <h3>Clientes</h3>
        <ul>
            <li><a href="lista_productos.view">Ver listado de Productos.</a>
            </li>
        </ul>
    </body>
</html>
