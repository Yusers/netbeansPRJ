<%-- 
    Document   : loginpage
    Created on : May 28, 2023, 10:09:29 PM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSP PAGE</h1>
        <form action="loginpage.jsp" method="post">
            <p><input type="text" name="txtidstudent" placeholder="enter idStudent" required=""/></p>
            <p><input type="text" name="txtfullname" placeholder="enter fullname" required=""/></p>
            <p>
                <input type="radio" id="male" name="txtsex" value="male">
                <label for="male">Male</label><br>
                <input type="radio" id="female" name="txtsex" value="female">
                <label for="female">Female</label><br>
            </p>
            <p><input type="submit" value="submit"></p>
        </form>
        <%
            String idStudent = request.getParameter("txtidstudent");
            String fullname = request.getParameter("txtfullname");
            String sex = request.getParameter("txtsex");

            out.print("<h1> Your Profile </h1>");
            out.print("<p>ID Student: " + idStudent + "</p>");
            out.print("<p>fullname: " + fullname + "</p>");
            out.print("<p>sex: " + sex + "</p>");
        %>
    </body>
</html>
