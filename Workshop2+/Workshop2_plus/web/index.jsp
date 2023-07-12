<%-- 
    Document   : index
    Created on : Jul 11, 2023, 8:24:30 AM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Search</title>
    </head>
    <body>
        <h1>Search Page!</h1>
        <form action="MainServlet" method="post">
            <input hidden name="action" value="1">
            <input type="text" name="txtsearch" value="${param.keyword}" placeholder="Enter car's name">
            <input type="submit" value="Find">
        </form>
        <c:set var="list" value="${requestScope.result}"></c:set>
        <c:if test="${list!=null}">
            <table border="1">
                <c:forEach var="c" items="${list}">
                    <form action="MainServlet" method="post">
                        <input hidden name="action" value="2">
                        <input hidden name="txtcarid" value="${c.id}">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.name}</td>
                            <td>${c.description}</td>
                            <td>${c.price}</td>
                            <td>${c.speed}</td>
                            <td>${c.status}</td>
                            <td><input type="submit" value="Add to cart"></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
        <a href="MainServlet?action=3">View Cart</a>
        <div>
            <c:set var="cookies" value="${request.getCookies()}" />
            <c:if test="${cookies!=null || cookies.length > 0}">
                <c:forEach var="cookie" items="${cookies}">
                    <c:if test="${cookie.getName().equals(\"wishlist\")}">
                        <c:set var="findName" value="${cookie.getValue()}" />
                        <h2>San pham yeu thich cua ban: ${findName} </h2>
                    </c:if>
                </c:forEach>
            </c:if>
    </body>
</html>
