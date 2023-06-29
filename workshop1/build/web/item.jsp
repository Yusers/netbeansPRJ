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
            String editAction = (String) request.getAttribute("editAction");
            Item it = (Item) request.getAttribute("Item");
        %>

        <%
            if (editAction == null) {
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
                for (Item i : items) {
            %>
            <tr>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="action" value="2" />
                <input type="hidden" name="txttype" value="<%=type%>" />
                <input type="hidden" name="txtitemid" value="<%=i.getId()%>" />
                <input type="hidden" name="editAction" value="<%=true%>" />
                <td><%= i.getId()%></td>
                <td><%= i.getName()%></td>
                <td><%= i.getPrice()%></td>
                <td><%= i.getType()%></td>
                <td><input type="submit" value="editt"/></td>
            </form>
        </tr>
        <%
            }
        } else {
            ArrayList<Type> types = (ArrayList<Type>) request.getAttribute("Types");
        %>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>type</th>
                <th>action</th>
            </tr>
            <tr>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="action" value="2"/>
                <input type="hidden" name="update" value="true"/>
                <input type="hidden" name="txtitemid" value="<%=it.getId()%>"/>
                <td><%=it.getId()%></td>
                <td><input type="text" name="txtitemname" value="<%= it.getName()%>" /></td>
                <td><input type="number" name="txtitemprice" value="<%= it.getPrice()%>" /></td>
                <td>
                    <select name="txttype">
                        <%
                            for (Type t : types) {
                        %>
                        <option value="<%= t.getName()%>"><%= t.getName()%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
                <td><input type="submit" value="edit"/></td>
            </form>
            </tr>
        </table>
        <%
            }
        %> 
    </table>
    <h1>${requestScope.msg}</h1>
    <a href="MainServlet?action=">Go back list</a>
</body>
</html>
