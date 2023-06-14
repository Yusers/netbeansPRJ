<%-- 
    Document   : page4
    Created on : Jun 14, 2023, 10:15:53 AM
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
        <c:set var="a" value="100" scope="page"/>
        <c:set var="b" value="200" scope="page"/>
        <c:if test="${a<b}">
            <h1>em yeu co</h1>
        </c:if>
        <c:choose>
            <c:when test="${a%2!=0}">
                a la so le
            </c:when>
            <c:when test="${a%2!=0}">
                a la so le
            </c:when>
        </c:choose>
        <c:forEach var="i" begin="1" end="5" step="1">
            <h3>Con 3 tuan la thi PE</h3>
        </c:forEach>
        <c:set var="s" value="anh den tham em dem 30"/>
        <c:forTokens var="word" delims=" " items="${s}">
            <h6>${word}</h6>
        </c:forTokens>
        <c:catch var="e">
             <form>
                <p><input type="text" name="txt1" value="${param.txt1}"/></p>
                <p><input type="text" name="txt2" value="${param.txt2}"/></p>
                <p><input type="submit" value="/" /></p>
            </form>
                result=${param.txt1/param.txt2}
        </c:catch>
        <c:if test="${e!=null}">
            ${e}
        </c:if>
    </body>
</html>
