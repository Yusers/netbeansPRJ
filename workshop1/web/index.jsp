<%-- 
    Document   : index
    Created on : Jun 4, 2023, 12:26:21 PM
    Author     : overw
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Type> listType = (ArrayList<Type>) request.getAttribute("listType");
            if (listType != null) {
                for (Type type : listType) {
        %><a href="MainServlet?action=2&txttype=<%=type.getName()%>" style="margin-left: 20px; text-decoration: none"> <%=type.getName()%> </a> <% }
        } else {
        %> <h1>DATABASE IS EMPTY OR SOMETHING WRONG!</h1> <%
            }
        %>
    </body>
</html>
