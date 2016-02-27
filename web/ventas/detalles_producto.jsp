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
                    <h3><font color="white">Develop Store: Detalles del Producto</h3>
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
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/<a href="../lista_productos.view">Listado de Productos</a>/Detalles del Producto</a><br/>
    <b>Color:</b> ${producto.color.titulo}</br>
    <b>Precio:</b> ${producto.precio}</br>
    <b>Talla:</b> ${ producto.talla}</br>
    <b>Descripcion:</b> ${producto.descripcion}</br>
    <b>Tipo:</b> ${producto.tipo.titulo}</br>

    <form action="agregar_carrito.do?id=${producto.id}" method="POST">
        <table border="0">        
            <tbody>
                <tr>
                    <td>Cantidad:</td>
                    <td>
                        <select name="cantidad">
                            <%
                                Producto producto = (Producto) request.getAttribute("producto");
                                int disponibles = producto.getDisponibles();
                                for (int i = 1; i <= disponibles; i++) {
                            %>
                            <option><%=i%></option>
                            <%}%>    
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Agregar a carrito" /></td>
                </tr>
            </tbody>
        </table>


    </form>
</body>
</html>
