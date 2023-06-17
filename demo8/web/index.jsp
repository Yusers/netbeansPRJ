<%-- 
    Document   : index
    Created on : Jun 17, 2023, 9:58:02 AM
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
        <form action="saveAccountServlet">
            <p><input type="text" name="txtemail" required=""/></p>
            <p><input type="password" name="txtpassword" required=""/></p>
            <p>...</p>
            <p><input type="submit" value="submit" /></p>
        </form>
            <p>${requestScope.ERROR}</p>
            <a href="Servlet1">call servlet 1</a>
            <a href="Servlet2">call servlet 2</a>
            <a href="GoodbyeServlet">call Goodbye Servlet</a>
    </body>
</html>
