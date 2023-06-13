<%-- 
    Document   : ViewCart
    Created on : Jun 7, 2023, 10:42:56 AM
    Author     : overw
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="basicobject.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function warning() {
            var ans = window.confirm("aus?");
            if(ans) {
                return true;
            }
            return false;
        }
    </script>
    <body>
        <%
            HashMap<Car, Integer> cart = (HashMap) session.getAttribute("cart");
            if (cart != null && cart.size() > 0) {
        %> 
        <h1>Your cart</h1>
        <table> 
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>quantity</th>
                <th>total</th>
                <th>action</th>
            </tr>
            <%
                double sum = 0;
                for (Car c : cart.keySet()) {
                    int quantity = cart.get(c);
                    sum= sum+quantity*c.getPrice();
            %>
            <form action="MainServlet" method="post">
                <input type="hidden" value="9" name="action" />
                <input type="hidden" value="<%= c.getCarID() %>" name="txtcarid" />
                <tr>
                    <td><%=c.getCarID()%></td>
                    <td><%=c.getCarName()%></td>
                    <td><%=c.getPrice()%></td>
                    <td><input type="submit" min="1" value="<%= quantity%>" name="txtquantity" /></td>
                    <td><%= quantity * c.getPrice()%></td>
                    <td><input type="submit" value="remove" name="btnremove" onclick="return warning()"/>
                        <input type="submit" value="update" /></td>
                </tr>
            </form>
            <%
                }
            %>
        </table>
        <h2>order date: <%=(new Date().toString())%></h2>
        <h2>shipping date:  du kien giao hang sau 7 ngay</h2>
        <h2>Total money: <%=sum %></h2>
        <form action="MainServlet" method="post">
            <input type="hidden" value="10" name="action" />
            <input type="submit" value="checkout" />
        </form>
        <%
            } else {
                out.print("<h1>Empty</h1>");
            }
        %>
    </body>
</html>
