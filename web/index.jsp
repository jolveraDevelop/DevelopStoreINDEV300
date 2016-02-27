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
        <h2>Bienvenido a DEVELOP Store ${userName}</h2>
        <h3>Clientes</h3>
        <ul>
            <li><a href="lista_productos.html">Ver listado de Productos.</a>
            </li>
        </ul>
    </body>
</html>
