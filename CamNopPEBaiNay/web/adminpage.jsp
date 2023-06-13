<%-- 
    Document   : adminpage
    Created on : May 31, 2023, 10:20:44 AM
    Author     : overw
--%>

<%@page import="basicobject.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User us = (User) session.getAttribute("loginedUser");
            if (us != null) {
        %>
            <h2>Welcome <%= us.getFullname()%></h2>
            <h2><a href="MainServlet?action=5" >Logout</h2>
        <%
            } else {
                response.sendRedirect("MainServlet");
            }
        %>
    </body>
</html>
