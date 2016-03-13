<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Login</title>
    </head>
    <body>
        <c:if test="${sessionScope.cliente ne null}">
             <%--<c:redirect url="lista_productos.view"/>--%>
             <jsp:forward page="lista_productos.view" />
        </c:if>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Login</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <b>Usted está aquí:</b> <a href="index.jsp">Inicio</a>/Login
                </td> 
            </tr> 
        </table>
        
        <form action="login.do" method="POST">
            <table border="0">
                <tr>                
                    <td>Usuario: </td>
                    <td><input type="text" id="usuario" name="usuario" value="" size="20" /></td>
                </tr>
                <tr>
                    <td>Contraseña: </td>
                    <td><input type="password" name="contrasenia" value="" size="20" /></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Ingresar"  />
        </form>
    </body>
</html>
