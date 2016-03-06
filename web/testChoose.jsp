<%-- 
    Document   : testChoose
    Created on : 6/03/2016, 09:29:15 AM
    Author     : jr_ro
--%>

<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="horaActual" value="<%= new Date().getHours() %>" />
        <c:choose>
            <c:when test="${horaActual lt 12}">
                <c:set var="saludo" value="Buenos dias"/>
            </c:when>
            <c:when test="${horaActual lt 18}">
                <c:set var="saludo" value="Buenos tardes"/>
            </c:when>
            <c:when test="${horaActual lt 22}">
                <c:set var="saludo" value="Buenos noches"/>
            </c:when>
            <c:otherwise>
                <c:set var="saludo" value="Buenas madrugadas"/>
            </c:otherwise>
        </c:choose>
        <h1>Saludo: ${saludo}</h1>
    </body>
</html>
