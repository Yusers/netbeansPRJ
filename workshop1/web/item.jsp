<%-- 
    Document   : item
    Created on : Jun 4, 2023, 2:32:39 PM
    Author     : overw
--%>

<%@page import="dbaccess.TypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Item"%>
<%@page import="basicobject.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>${requestScope.Type}</h1>
        <%
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("Items");
            String type = (String) request.getAttribute("Type");
        %>

        <%
            if (items == null || items.isEmpty()) {
        %>
        <p>List is empty</p>
        <%
        } else {
        %>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>type</th>
                <th>action</th>
            </tr>
            <%
                }
                for (Item i : items) {
            %>
            <tr>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="action" value="5" />
                <input type="hidden" name="txtitemid" value="<%=i.getId()%>" />
                <td><%= i.getId()%></td>
                <td><%= i.getName()%></td>
                <td><%= i.getPrice()%></td>
                <td><%= i.getType()%></td>
                <td><input type="submit" value="edit"/></td>
            </form>
        </tr>
        <%
            }
        %> 
    </table>
    <h1>${requestScope.msg}</h1>
    <%-- Neu la trang dau load item thi back ve list, neu la trang edit thi back ve item list --%>
    <a href="MainServlet?action=">Go back</a>
</body>
</html>
