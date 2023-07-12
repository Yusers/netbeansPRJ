<%-- 
    Document   : viewcart
    Created on : Jul 12, 2023, 9:11:03 AM
    Author     : overw
--%>

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
        <h1>Hello World!</h1>
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
                        <input type="hidden" value="3" name="action" />
                        <input type="hidden" value="${c.id}" name="txtcarid" />
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.name}</td>
                            <td>${c.price}</td>
                            <td><input type="submit" min="1" value="${cart.get(c)}" name="txtquantity" /></td>
                            <td>${quantity * c.price}</td>
                            <td><input type="submit" value="remove" name="btnremove" onclick="return warning()"/></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
