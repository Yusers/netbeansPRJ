<%-- 
    Document   : admin.jsp
    Created on : Jun 30, 2023, 9:30:23 PM
    Author     : overw
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Food"%>
<%@page import="basicobject.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 5px;
            }
            
            h1 {
                text-align: center;
            }
            
            form {
                display: inline-block;
                width: 50%;
                margin-right: 0px;
            }
            
            .add_foods {
                display: inline;
                width: 50%;
                float: right;
            }
            
            input, textarea {
                width: 300px;
            }
            
            #submitbtn {
                width: 80px;
            }
            
            .list_foods {
                display: inline-block;
                width: 50%;
            }
            
            h3 {
                margin: 0;
                padding-top: 100px;
                text-align: center;
                display: inline-block;
                float: right;
                width: 50%;
            }
            
        </style>
    </head>
    <body>
        <%
            User us = (User) session.getAttribute("us");
            ArrayList<Food> listFood = (ArrayList<Food>) request.getAttribute("listFood");
            boolean flag = false;
            if (us != null) {
                if (us.getRole().equals("AD")) {
        %>
        <h1>Welcome <%= us.getFullname()%></h1>
        <div class="list_foods">
            <h1> list Food </h1>
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>description</th>
                    <th>price</th>
                    <th>cooking Time</th>
                    <th>status</th>
                    <th>action</th>
                </tr>
                <%
                    for (Food f : listFood) {
                %>    
                <tr>
                    <td><%= f.getId()%></td>  
                    <td><%= f.getName()%></td>  
                    <td><%= f.getDescription()%></td>  
                    <td><%= f.getPrice()%></td>  
                    <td><%= f.getCookingtime()%></td>  
                    <td><%= f.isStatus()%></td>  
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <div class="add_foods">
            <h1>Add food</h1>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="action" value="3" />
                <p><input type="text" name="txtfoodid" required="" placeholder="Food id"/></p>
                <p><input type="text" name="txtfoodname" required="" placeholder="Food name"/></p>
                <p><textarea name="txtDescription" cols="30" rows="5" placeholder="Description"></textarea></p>
                Price <br>
                <input type="number" value="0" min="0" name="txtfoodprice" />
                <br>
                <br>
                Cooking Time <br>
                <input type="number" value="0" min="0" name="txtfoodcooktime" />
                <br>
                <br>
                Status<br>
                <select name="txtfoodstatus">
                    <option selected>False</option>
                    <option>True</option>
                </select>
                <br>
                <br>
                <input id="submitbtn" type="submit" value="submit"/>
            </form>
            <h3>${requestScope.msg}</h3>
        </div>
        <%
                } else {
                    out.print("you cannot access to this!");
                }
            } else {
                request.getRequestDispatcher("MainServlet?action=&msg=denied").forward(request, response);
            }
        %>
    </body>
</html>
