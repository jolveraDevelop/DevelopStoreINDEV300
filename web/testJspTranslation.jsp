<%-- 
    Document   : testJspTranslation
    Created on : 6/03/2016, 11:53:01 AM
    Author     : jr_ro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%! 
        public void jspInit(){
            System.out.println("jspInit(): testJspTranslation");
        }

        public void jspDestroy(){
            System.out.println("jspDestroy(): testJspTranslation");
        }
        
        %>
        <% 
            //crecion de la variable i
            int i = 4;
        %>
        <%! int i = 9;
            /**
             * @return Retorna un saludo
             */
            public String saludo(){return "hola";}%>
            <% request.getAttribute("hola"); %>
        <%= this.i %>
        <%= saludo()%>
        <%--<%for(int i =0 ; i<5 ;i++){ %>
        <%= new Date() %>
        <p> algun codigo</p>
        <% } %>--%>
        <% request.setAttribute("algo", new String[]{"1","2","3"}); %>
        ${algo["2"]}
        ${true or false}
        <c:import >
    </body>
</html>
