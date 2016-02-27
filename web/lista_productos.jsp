<%-- 
    Document   : lista_productos
    Created on : 7/02/2016, 11:09:33 AM
    Author     : jr_ro
--%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Listado de Productos</title>
        <style type="text/css">
            #table { 
                border-collapse: collapse; 
            }
        </style>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Listado de Productos</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>

                            <td>Usuario: </td>
                            <td>${user.nombre}</td>
                            <%--<td><%= request.getAttribute("userName") %></td>--%>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="index.html">Inicio</a>/Listado de Productos        
        <h2>Lista de Productos:</h2>
        <table border="1" width="800" id="table">
            <thead>
                <tr bgcolor='#3882C7'>
                    <th>No.</th>
                    <th>Descripción</th>
                    <th>Tipo</th>
                    <th>Color</th>
                    <th>Talla</th>
                    <th>Precio</th>
                    <th>Disponibles</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> prods = (List<Producto>)request.getAttribute("productos");
                    for(Producto prodActual : prods){
                %>
                <tr>
                    <td><%= prodActual.getId() %></td>
                    <td><%= prodActual.getDescripcion()%>.</td>
                    <td><%= prodActual.getTipo().getTitulo()%></td>
                    <td><%= prodActual.getColor().getTitulo()%></td>
                    <td><%= prodActual.getTalla().getTitulo()%></td>
                    <td>$<%= prodActual.getPrecio()%></td>
                    <td></td>
                    <td><a href="./ventas/detalles_producto.view?id=<%= prodActual.getId() %>">
                            <img src="/imagen/carrito.png" width="40" height="40"
                             alt="carrito" /></a>
                    </td>
                </tr>
                <%
                    }
                %>
                
            </tbody>
        </table>
    </body>
</html>
