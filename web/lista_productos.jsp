<%-- 
    Document   : lista_productos
    Created on : 7/02/2016, 11:09:33 AM
    Author     : jr_ro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ds" uri="/store.develop.com.mx" %>
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
    
    <body onload="setInterval(getMessages, 1000)">
        <ds:header titulo="Lista de Productos" />
        <%--<%@include file="header.jsp" %>
         aqui termina priemer header--%>
        <%--<c:import url="header.jsp" >
            <c:param name="titulo" value="Lista de Productos" />
        </c:import>--%>
        <%
            //if(1==1){
            //  throw new RuntimeException("Ocurrio un error en lista_productos.jsp");
            //}
        %>
        <b>Usted está aquí:</b> <a href="index.jsp">Inicio</a>/Listado de Productos        
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
                <ds:mostrarProductos columnas="1,2,3,4,5,6,7,8"/>

            </tbody>
           

        </table>
             <div id="content"></div>
    </body>
    <script>
        var messagesWaiting = false;
        var i = 10;
        function getMessages() {
            if (!messagesWaiting) {
                messagesWaiting = true;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        messagesWaiting = false;
                        var contentElement = 
                                document.getElementById("content");
                        contentElement.innerHTML = xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET", "resultado.jsp", true);
                xmlhttp.send();
            }
        }
        
    </script>
</html>
<%--<ds:ForEachTag items="${requestScope.productos}"
               var="prod"
               varStatus="count">
    <tr>
        <td>${count}</td>
        <td>${prod.descripcion}</td>
        <td>${prod.tipo.titulo}</td>
        <td>${prod.color.titulo}</td>
        <td>${prod.talla.titulo}</td>
        <td>${prod.precio}</td>
        <td>${prod.disponibles}</td>
        <td><a href="./ventas/detalles_producto.view?id=${prod.id}" >
                <img src="./imagenes/carrito.png" width="40" height="40"
                     alt="carrito" />
            </a>
        </td>
    </tr>
</ds:ForEachTag>
--%>
<%--
<c:forEach items="${requestScope.productos}" begin="0"
           step="1" var="producto" varStatus="index">
    <tr>
        <td>${index.count}</td>
        <td>${producto.descripcion}</td>
        <td>${producto.tipo.titulo}</td>
        <td>${producto.color.titulo}</td>
        <td>${producto.talla.titulo}</td>
        <td>${producto.precio}</td>
        <td>${producto.disponibles}</td>
        <td><a href="./ventas/detalles_producto.view?id=${producto.id}" >
                <img src="./imagenes/carrito.png" width="40" height="40"
                     alt="carrito" />
            </a>
        </td>
    </tr>
</c:forEach>
--%>

<!-- <%--<%
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
    <td><%= prodActual.getDisponibles()%></td>
    <td><a href="<%=response.encodeRedirectURL("./ventas/detalles_producto.view?id="+prodActual.getId()) %> " >
            <img src="./imagenes/carrito.png" width="40" height="40"
             alt="carrito" />
        </a>
    </td>
</tr>
<%
    }
%>
--%>
--%>
-
</tbody>
</table>
</body>
</html>
