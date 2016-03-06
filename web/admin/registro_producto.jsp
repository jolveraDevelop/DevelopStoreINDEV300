<%-- 
    Document   : registro_producto
    Created on : Jun 2, 2014, 2:09:50 PM
    Author     : Humberto BanueloS
    Author-Mail: hbanuelos@7i.com.mx
    Company    : Develop
--%>

<%@page import="mx.com.develop.store.model.TipoProducto"%>
<%@page import="mx.com.develop.store.model.Talla"%>
<%@page import="mx.com.develop.store.model.Color"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Registro Productos</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Registro Productos</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <td><a href="../login.jsp">Login</a></td>
                            <td><a href="../registro_cliente.html">Regístrate</a></td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/<a href="index.html">Admin</a>/Registro Productos
        <p>Los campos marcados con * son obligatorios:</p>
        <form method="POST" action="registro_producto.do">
            <table border="0">
                <tr>
                    <td>* Color:</td>
                    <td>                        
                        <select name="color">
                            <option>Selecciona...</option>
                            <%
                                Color colores[] = Color.values();
                                for (Color color : colores) {
                            %>
                            <option value="<%= color%>"><%= color.getTitulo()%></option>
                            <%}%>                            
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>* Precio:</td>
                    <td><input type="text" name="precio"/></td>
                </tr>
                <tr>
                    <td>* Talla:</td>
                    <td>
                        <select name="talla">                            
                            <option>Selecciona...</option>
                            <%
                                Talla tallas[] = Talla.values();
                                for (Talla talla : tallas) {
                            %>
                            <option value="<%= talla%>"><%= talla%></option>
                            <%}%>
                        </select>                        
                    </td>
                </tr>
                <tr>
                    <td>Descripción:</td>
                    <td>
                        <textarea name="descripcion" rows="6" cols="30"></textarea>                         
                    </td>
                </tr>
                <tr>
                    <td>* Tipo:</td>
                    <td><select name="tipo">
                            <option>Selecciona...</option>
                            <%
                                TipoProducto tipos[] = TipoProducto.values();
                                for (TipoProducto tipo : tipos) {
                            %>
                            <option value="<%= tipo%>"><%= tipo.getTitulo()%></option>
                            <%}%>
                        </select>                         
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Registrar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

