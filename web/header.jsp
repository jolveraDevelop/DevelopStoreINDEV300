<%-- 
    Document   : header
    Created on : 6/03/2016, 10:35:36 AM
    Author     : jr_ro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ds" uri="/store.develop.com.mx" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: ${param.titulo}</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <ds:if test="${sessionScope.cliente ne null}">
                                <ds:then>
                                    <td><a href="ventas/lista_carrito.jsp">Ver carrtio</a></td>
                                </ds:then>
                                <ds:else>
                                    <td><a href="login.jsp">Login</a></td>
                                </ds:else>
                            </ds:if >
                            <td>Usuario: </td>
                            <td><c:out value="${cliente.nombre}" escapeXml="false"><b>Invitado</b></c:out></td>
                            <%--<td><%= request.getAttribute("userName") %></td>--%>
                            <td><a href="logout.do">Cerrar sesion</a></td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>