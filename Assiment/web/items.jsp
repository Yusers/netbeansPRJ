<%-- 
    Document   : items
    Created on : Jul 4, 2023, 4:43:29 PM
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
        <h1>Items DashBoard!</h1>
        <c:set var="items" value="${requestScope.Items}" />
        <c:set var="edit" value="${requestScope.Item}" />
        <c:choose>
            <c:when test="${empty edit}">
                <!-- Thực hiện khi điều kiện đúng -->
                <c:if test="${not empty items}" >
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>CateID</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="item" items="${items}" >
                            <form action="MainServlet">
                                <input type="hidden" name="action" value="1" />
                                <input type="hidden" name="itemid" value="${item.getId()}" />
                                <input type="hidden" name="cateid" value="${item.getCateid()}" />
                                <tr>
                                    <td>${item.getId()}</td>
                                    <td>${item.getName()}</td>
                                    <td>${item.getPrice()}</td>
                                    <td>${item.getCateid()}</td>
                                    <td style="text-align: center">
                                        <input type="submit" value="Edit" name="editAction"/>
                                        <input type="submit" value="Delete" name="deleteAction"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                    <h1 style="color: red">${requestScope.msg}</h1>
                </c:if>
                <h1>${requestScope.Items==null ? "List is empty" : ""}</h1>
                <hr/>
                <h1>// CREATE</h1>
                <c:set var="createAction" value="${requestScope.CREATE}"/>
                <c:set var="tracking" value="${requestScope.TrackingItem}"/>
                <c:if test="${not empty createAction}">
                    <table border="1">
                        <form action="MainServlet" method="POST">
                            <input type="hidden" name="action" value="5" />
                            <tr>
                                <th>ID</th>
                                <td><input type="text" name="id" required="" value="${tracking.id}"/></td>
                            </tr>
                            <tr>
                                <th>Name</th>  
                                <td><input type="text" name="name" required="" value="${tracking.name}"/></td>
                            </tr>  
                            <tr>
                                <th>Price</th>
                                <td><input type="number" min="0" name="price" value="${tracking.price}" required=""/></td>
                            </tr>
                            <tr>
                                <th>CateID</th>
                                <td>
                                    <c:set var="listCate" value="${requestScope.ListCate}" />
                                    <select name="cateid">
                                        <c:forEach var="cate" items="${listCate}">
                                            <option value="${cate.id}">${cate.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center" colspan="4">
                                    <input type="submit" style="width: 100%" value="Create"/>
                                </td>
                            </tr>
                        </form>
                    </table>
                    <br/>
                    <a href="MainServlet?action=5&createAction=">Hide Create Item</a>
                </c:if>
                <c:if test="${empty createAction}">
                    <a href="MainServlet?action=5&createAction=1">Show Create Item</a>
                </c:if>
                <hr/>
                <br/>
                <br/>
                <a href="MainServlet">Go Back</a>
            </c:when>
            <c:otherwise>
                <!-- Thực hiện khi điều kiện sai -->
                <table border="1">
                    <form action="MainServlet" method="POST">
                        <input type="hidden" name="action" value="3" />
                        <input type="hidden" name="oldId" value="${edit.getId()}" />
                        <tr>
                            <th>ID</th>
                            <td><input type="text" name="newId" value="${edit.getId()}" required=""/></td>
                        </tr>
                        <tr>
                            <th>Name</th>  
                            <td><input type="text" name="name" value="${edit.getName()}" required=""/></td>
                        </tr>  
                        <tr>
                            <th>Price</th>
                            <td><input type="number" min="0" name="price" value="${edit.getPrice()}" required=""/></td>
                        </tr>
                        <tr>
                            <th>CateID</th>
                            <td>
                                <c:set var="listCate" value="${requestScope.ListCate}" />
                                <select name="cateid">
                                    <c:forEach var="cate" items="${listCate}">
                                        <option value="${cate.id}">${cate.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center" colspan="4">
                                <input type="submit" style="width: 100%" value="Save"/>
                            </td>
                        </tr>
                    </form>
                </table>
                <h1>${requestScope.msg}</h1>
                <br/>
                <a href="MainServlet?action=1">Go Back</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>
