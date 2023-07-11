<%-- 
    Document   : login
    Created on : Jun 30, 2023, 9:22:26 PM
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
        <form action="MainServlet" method="post">
            <input type="hidden" value="1" name="action" />
            <p><input type="text" name="txtuserid" placeholder="enter userid" required="" />*</p>
            <p><input type="password" name="txtpassword" placeholder="enter password" required="" />*</p>
            <p><input type="submit" value="login"/></p>
        </form>
        <%
            String msg = (String) request.getAttribute("msg");
            if(msg != null) {
        %> 
        <h2 style="color: red"><%= msg %></h2>
        <%
            }
        %>
    </body>
</html>
