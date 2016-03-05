<%-- 
    Document   : lista_productos
    Created on : Apr 11, 2014, 11:30:31 AM
    Author     : Humberto
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="mx.com.develop.store.model.Carrito"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="java.util.List"%>
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
                    <h3><font color="white">Develop Store: Carrito de compras.</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                Usuario: ${cliente.nombre} <a href="../logout.do">Salir</a>
                            </td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/Carrito de compras
        de Productos        
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
                    <th>Cantidad</th>
                    <th></th>

                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    Carrito venta = (Carrito) session.getAttribute("carrito");
                    if (venta != null) {
                        Map<Producto, Integer> productosVenta = venta.getProductos();
                        Collection<Producto> productos = productosVenta.keySet();
                        for (Producto producto : productos) {
                            i++;
                %>
                <tr id="td">
                    <td><%= i%></td>
                    <td><%= producto.getDescripcion()%></td>
                    <td><%= producto.getTipo().getTitulo()%></td>
                    <td><%= producto.getColor().getTitulo()%></td>
                    <td><%= producto.getTalla()%></td>
                    <td>$<%= producto.getPrecio()%></td>
                    <td><%= productosVenta.get(producto)%></td>
                    <td>     
                        <a href="">Modificar</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <p> <a href="../lista_productos.view">Seguir comprando</a></p>
        <p> <a href="./completar_compra.do">Completar compra.</a></p>
    </body>
</html>
