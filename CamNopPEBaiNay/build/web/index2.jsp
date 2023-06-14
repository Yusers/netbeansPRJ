<%-- 
    Document   : index
    Created on : May 31, 2023, 9:50:16 AM
    Author     : overw
--%>

<%@page import="basicobject.Car"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>indexjsp Page</title>
    </head>
    <body>

        <a href="MainServlet?action=1">Login</a>
        <a href="MainServlet?action=8">View Cart</a>
        <form action="MainServlet" method="post">
            <input type="hidden" value="6" name="action"/>
            <input type="text" name="txtsearch" value="${param.keyword}" />
            <input type="submit" value="Find"/>
        </form>

        <!-- cho nay de xuat kq sau khi find -->
        <c:set var="list" value="${requestScope.result}" />
        <c:if test="${list!=null}" >
        <table>
            <c:forEach var="c" items="${list}">
            <form action="MainServlet" method="post">
                <input type="hidden" name="action" value="7"/>
                <input type="hidden" name="txtcarid" value="${c.id}"/>
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.price}</td>
                    <td><input type="submit" value="buy"/></td>
                </tr>
            </form>
            </c:forEach>
        </table> 
        </c:if>
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
