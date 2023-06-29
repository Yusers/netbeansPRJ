<%-- 
    Document   : admin
    Created on : Jun 24, 2023, 10:43:22 AM
    Author     : overw
--%>

<%@page import="basicobject.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            User us = (User) session.getAttribute("User");
            if (us.getRole() == 1) {
        %>
            <h1>Welcome <%= us.getFullname() %></h1>
        <%  } else {
            out.print("you can not access");
            }
        %>
        <form action="MainServlet" method="Post">
            <input type="hidden" name="action" value="4" />
            <p>Food ID: <br>
                <input type="text" name="txtfoodid" required=""/>
            </p>
            <p>Name: <br>
                <input type="text" name="txtfoodname" required=""/>
            </p>
            <p>description: <br>
                <input type="text" name="txtfooddescr" required=""/>
            </p>
            <p>price: <br>
                <input type="number" name="txtfoodprice" required=""/>
            </p>
            <p>cooking Time: <br>
                <input type="number" name="txtcookingtime" required=""/>
            </p>
            <p>status: <br>
                <label>True</label><input type="radio" name="txtfoodstatus" value="True"/>
                <label>False</label><input type="radio" name="txtfoodstatus" value="False"/>
            </p>
            <p>
                <input type="submit" value="Insert"/>
            </p>
            <%
                String msg = (String) request.getAttribute("msg");
                if(msg!=null) {
            %>
            <p><%=msg%></p>
            <%}%>
        </form>
        <a href="MainServlet?action=3" >Logout</a>
    </body>
</html>
