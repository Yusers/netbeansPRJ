<%-- 
    Document   : search
    Created on : Jul 12, 2023, 7:30:00 AM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Page!</h1>
        <a href="MainServlet?action=4">View Cart</a>
        <form action="MainServlet" method="post">
            <input type="hidden" name="action" value="1" />
            <input type="text" name="txtsearch" value="" placeholder="Enter car's name" />
            <input type="submit" value="submit" />
        </form>
        <c:set var="listCar" value="${requestScope.ListCar}" />
        <c:if test="${not empty listCar}">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="car" items="${listCar}">
                    <form action="MainServlet" method="post">
                        <input type="hidden" name="action" value="2"/>
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.name}</td>
                            <td>${car.price}</td>
                            <td>${car.status}</td>
                            <td><input type="submit" value="Add to cart" /></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
