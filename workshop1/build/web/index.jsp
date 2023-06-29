<%-- 
    Document   : index
    Created on : Jun 4, 2023, 12:26:21 PM
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
        <%
            String list = (String) request.getAttribute("listType");
            list = list.replace("[", "").replace("]", "");
            if (list != null) {
                String[] allType = (list.split(","));
                for (String type : allType) {
        %><a href="MainServlet?action=2&txttype=<%=type%>" style="margin-left: 20px; text-decoration: none"> <%=type%> </a> <% }
        } else {
        %> <h1>wrong</h1> <%
            }
        %>
    </body>
</html>
