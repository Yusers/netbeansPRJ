<%-- 
    Document   : page1
    Created on : Jun 14, 2023, 9:36:05 AM
    Author     : overw
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="d" class="java.util.Date" scope="session" />
        <h1>${d.toString()}</h1>
        <jsp:useBean id="it" class="myobject.Item" scope="session" >
            <jsp:setProperty name="it" property="id" value="1" />
            <jsp:setProperty name="it" property="name" value="rau" />
            <jsp:setProperty name="it" property="price" value="10000" />
            <jsp:setProperty name="it" property="active" value="true" />
        </jsp:useBean>
        <a href="page2.jsp">open page2</a><br/>
        <a href="Servlet1">open page5</a>
    </body>
</html>
