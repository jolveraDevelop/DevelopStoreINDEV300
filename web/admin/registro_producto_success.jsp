<%-- 
    Document   : registro_productos_correcto
    Created on : Apr 11, 2014, 2:13:39 PM
    Author     : Humberto
--%>

<%@page import="mx.com.develop.store.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Correcto</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Correcto</h3>
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
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/<a href="index.jsp">Admin</a>/<a href="registro_producto.jsp">Registro Productos</a>/Correcto
        <h3>Tu producto ha sido registrado satisfactoriamente:</h3>
        <b>Color:</b> ${producto.color.titulo}</br>
        <b>Precio:</b> ${producto.precio}</br>
        <b>Talla:</b> ${ producto.talla}</br>
        <b>Descripcion:</b> ${roducto.descripcion}</br>
        <b>Tipo:</b> ${producto.tipo.titulo}</br>
    </body>
</html>
