<%-- 
    Document   : index
    Created on : May 31, 2023, 9:50:16 AM
    Author     : overw
--%>

<%@page import="basicobject.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>indexjsp Page</title>
    </head>
    <body>
        <%
            String keyword = request.getParameter("keyword");

        %>

        <a href="MainServlet?action=1">Login</a>
        <a href="MainServlet?action=8">View Cart</a>
        <form action="MainServlet" method="post">
            <input type="hidden" value="6" name="action"/>
            <input type="text" name="txtsearch" value="<%= (keyword != null) ? keyword : ""%>" />
            <input type="submit" value="Find"/>
        </form>

        <!-- cho nay de xuat kq sau khi find -->
        <%
            ArrayList<Car> list = (ArrayList) request.getAttribute("results");
            if (list != null && list.size() > 0) {
        %>
        <table>
            <%
                for (Car c : list) {
            %>
            <form action="MainServlet" method="post">
                <input type="hidden" name="action" value="7"/>
                <input type="hidden" name="txtcarid" value="<%= c.getCarID()%>"/>
                <tr>
                    <td><%= c.getCarID()%></td>
                    <td><%= c.getCarName()%></td>
                    <td><%= c.getPrice()%></td>
                    <td><input type="submit" value="buy"/></td>
                </tr>
            </form>
            <%
                }
            %>
        </table> 
        <%
            }
        %>
        <div>
            <%
                // doc cookie 
                Cookie[] array = request.getCookies();
                if (array != null && array.length > 0) {
                    for(Cookie cookie : array) {
                        if(cookie.getName().equals("wishlist")) {
                            String findName = cookie.getValue();
                            out.print("<h2> San pham iu thich cua ban: " + findName + "</h2>");
                        }
                    }
                }
            %>
        </div>
    </body>
</html>
