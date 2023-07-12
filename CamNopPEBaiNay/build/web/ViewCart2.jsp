<%-- 
    Document   : ViewCart
    Created on : Jun 7, 2023, 10:42:56 AM
    Author     : overw
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="basicobject.Car"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function warning() {
            var ans = window.confirm("Are you sure?");
            if (ans) {
                return true;
            }
            return false;
        }
    </script>
    <body>
        <c:set var="cart" value="${sessionScope.cart}"/>

        <c:if test="${cart!=null}"> 
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
                <c:set var="sum" value="0"/>
                <c:forEach var="c" items="${cart.keySet()}" >
                    <c:set var="quantity" value="${cart.get(c)}" />
                    <c:set var="sum" value="${sum+quantity*c.price}" />
                    <form action="MainServlet" method="post">
                        <input type="hidden" value="9" name="action" />
                        <input type="hidden" value="${c.id}" name="txtcarid" />
                        <tr>
                            <td>c.id</td>
                            <td>c.name</td>
                            <td>c.price</td>
                            <td><input type="submit" min="1" value="${cart.get(c)}" name="txtquantity" /></td>
                            <td>${quantity * c.price}</td>
                            <td><input type="submit" value="remove" name="btnremove" onclick="return warning()"/>
                                <input type="submit" value="update" /></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
        <jsp:useBean id="d" class="java.util.Date" />
        <h2>order Date: ${d}</h2>
        <h2>shipping date:  du kien giao hang sau 7 ngay</h2>
        <h2>Total money: ${sum}</h2>
        <form action="MainServlet" method="post">
            <input type="hidden" value="10" name="action" />
            <input type="submit" value="checkout" />
        </form>
        <%
            }

            
                else {
                out.print("<h1>Empty</h1>");
            }
        %>
    </body>
</html>
