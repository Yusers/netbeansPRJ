<%-- 
    Document   : login
    Created on : Jun 24, 2023, 10:15:57 AM
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
        <h1>Hello World!</h1>
        <form action="MainServlet" method="POST">
            <input type="hidden" value="1" name="action" />
            <p>
                user ID: <br>
                <input type="text" name="txtuserid" /></p>
            <p>
                Password: <br> 
                <input type="password" name="txtpassword" value=""/></p>
            <p><input type="submit" value="Login"/></p>
            <%
                String msg = (String) request.getAttribute("ERROR");
                if(msg != null) {
                %> <p><%=msg%></p> <%
                    }
            %>
        </form>
    </body>
</html>
