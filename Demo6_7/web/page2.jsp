<%-- 
    Document   : page2
    Created on : Jun 14, 2023, 9:54:29 AM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="it" class="myobject.Item" scope="session" />
        <jsp:getProperty name="it" property="id" />
        <jsp:getProperty name="it" property="name" />
        <jsp:forward page="page3.jsp">
            <jsp:param name="msg" value="ee" />
        </jsp:forward>
    </body>
</html>
