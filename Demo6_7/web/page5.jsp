<%-- 
    Document   : page5
    Created on : Jun 14, 2023, 10:34:50 AM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="list" value="${requestScope.result}"/>
        <c:if test="${list!=null}">
            <table>
                <c:forEach var="it" items="${list}">
                    <tr>
                        <td>${it.id}</td>
                        <td>${it.name}</td>
                        <td>${it.price}</td>
                        <td>${it.active}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <form>
            <input type='text' name='txt' />
            <input type='submit' value="go" />
        </form>
        <c:url var="mypage" value="${param.txt}" />
        <a href="${mypage}">click me</a>
    </body>
</html>
