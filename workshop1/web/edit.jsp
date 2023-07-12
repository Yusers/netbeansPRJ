<%-- 
    Document   : edit
    Created on : Jul 12, 2023, 9:54:23 AM
    Author     : overw
--%>

<%@page import="basicobject.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${requestScope.Type}</h1>
        <%
            Item i = (Item) request.getAttribute("Item");
            String type = (String) request.getAttribute("Type");
        %>

        <%
            if (i == null) {
        %>
        <p>Item is empty</p>
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
            %>
            <tr>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="action" value="5" />
                <td><input type="number" name="txtid" value="<%= i.getId()%>" /></td>
                <td><input type="text" name="txtname" value="<%= i.getName()%>" /></td>
                <td><input type="number" name="txtprice" value="<%= i.getPrice()%>" /></td>
                <td><input type="number" name="txttype" value="<%= i.getType()%>" /></td>
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
