<%-- 
    Document   : viewcart
    Created on : Jul 11, 2023, 10:40:34 AM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
        function warning() {
            if (window.confirm("Are you sure?: ")) {
                return true;
            } else {
                return false;
            }
        }
        </script>
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.cart}"></c:set>
        <c:if test="${empty cart}">
                <h1>Empty Cart</h1>
        </c:if>
        <c:if test="${not empty cart}">
            <h1>Your cart</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                <c:set var="sum" value="0" />
                <c:set var="totalCars" value="0" />
                <c:forEach items="${cart}" var="cartEntry">
                    <c:set var="car" value="${cartEntry.key}" />
                    <c:set var="quantity" value="${cartEntry.value}" />
                    <c:set var="total" value="${quantity * car.price}" />
                    <c:set var="sum" value="${sum + total}" />
                    <c:set var="totalCars" value="${totalCars + quantity}" />
                    <form action="MainServlet" method="post">
                        <input type="hidden" value="4" name="action">
                        <input type="hidden" value="${car.id}" name="txtcarid">
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.name}</td>
                            <td>${car.price}</td>
                            <td>${quantity}</td>
                            <td>${total}</td>
                            <td>
                                <input value="remove" type="submit" name="btnremove" onclick="return warning()">
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
            <p>Total cars: ${totalCars}</p>
            <p>Total money paid: ${sum} USD</p>
        </c:if>
        <a href="MainServlet?action=">back</a>
    </body>
</html>
