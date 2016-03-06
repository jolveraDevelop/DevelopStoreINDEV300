<%-- 
    Document   : completar_compra
    Created on : Jun 10, 2014, 12:58:26 PM
    Author     : Humberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="mx.com.develop.store.model.Carrito"%>
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
                    <h3><font color="white">Develop Store: Detalles de la compra.</h3>
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
        <b>Usted está aquí:</b> <a href="../index.html">Inicio</a>/Detalles de la compra.
        <h2>La compra se realizó con éxito, aquí los detalles:</h2>
        <br/>
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
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    Carrito venta = (Carrito) request.getAttribute("venta");
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
                </tr>
                <%
                        }
                    }
                %>
                <c:catch var="ex">
                <c:set var="total" value="${factura.total}" scope="page" />
                <c:set var="subtotal" value="${total div 1.16}" scope="page" />
                <c:set var="iva" value="${total - subtotal}" scope="page" />
                <c:set target="${factura}" property="subtotal" value="${subtotal}"/>
                <c:set target="${factura}" property="iva" value="${iva}"/> 
                <c:set target="${factura}" property="otra" value="${iva}"/>
                <c:remove var="iva" scope="page" />
                </c:catch>
                error al asignar propiedades a factura: ${ex}
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><b>Iva</b></td>
                    <td>$ ${iva}</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><b>SubTotal:</b></td>
                    <td>$ ${subtotal}</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><b>Total:</b></td>
                    <td>$ ${total}</td>
                </tr>
            </tbody>
        </table>
        <p>Detalle de la factura:</p>
        Cliente: ${cliente.nombre} <br>
        Iva: ${factura.iva} <br>
        SubTotal: ${factura.subtotal} <br>
        Total: ${factura.total} <br>
        
        
        <p>Los siguientes cupones tienen descuentos en tus próximas compras:</p>
        <c:forTokens delims="," items="${cupones}" var="cupon">
            ${cupon} <br/>
        </c:forTokens>
        <p> <a href="../lista_productos.view">Seguir comprando</a></p>
    </body>
</html>
