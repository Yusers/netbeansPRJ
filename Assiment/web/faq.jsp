<%-- 
    Document   : faq
    Created on : Jul 9, 2023, 9:08:54 PM
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
        <span>Choose the item to get FAQs: </span>
        <c:set var="it" value="${requestScope.Item}" />
        <c:set var="items" value="${requestScope.Items}" />
        <c:if test="${not empty items}">
            <form style="display: inline" action="MainServlet">
                <input type="hidden" name="action" value="7" />
                <select name="faqItem">
                    <c:forEach var="item" items="${items}">
                        <option value="${item.id}">${item.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="submit" />
            </form>

        </c:if>
        <c:set var="faqs" value="${requestScope.Faqs}" />
        <c:set var="cate" value="${requestScope.Cate}" />
        <c:if test="${not empty faqs}">
            <h3>Item name: ${it.name}</h3>
            <c:forEach var="faq" items="${faqs}">
                <ul>
                    <li><h3>Content: ${faq.cuscontent}</h3></li>
                    <li><p>customer name: ${faq.cusname}</p></li>
                    <br/><br/>
                </ul>
            </c:forEach>
        </c:if>
        <c:if test="${empty faqs}">
            <c:if test="${not empty requestScope.FaqsEmp}">
                <h1>Don't have FAQS about this</h1>
                <ul>
                    <li>ID: ${it.id}</li>
                    <li>Name: ${it.name}</li>
                    <li>Price: ${it.price}</li>
                    <li>CateID: ${it.cateid}</li>
                </ul>
            </c:if>
            <c:if test="${empty requestScope.FaqsEmp}">
                <h1>Please choose items to get FAQS</h1>
            </c:if>
        </c:if>
    </body>
</html>
