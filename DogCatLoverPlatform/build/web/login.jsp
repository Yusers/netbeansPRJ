<%-- 
    Document   : Login.jsp
    Created on : Oct 1, 2023, 6:46:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cat Dog Lover Log In</title>

        <link rel="stylesheet" type="text/css" href="css/login.css">
        <!-- Google Web Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet"> 
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Favicon -->
       <link href="icon/icons8-pet-lover-96.png" rel="icon">
        <!-- Flaticon Font -->
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

        <style>
            .a{
                transition: transform 0.3s ease;
            }
            .a:hover{
                transform: scale(1.5);
            }
        </style>

    </head>
    <body>
        <div class="login">
            <div class="header">
                <h2 class="active">log in</h2>
            </div>
            <br>
            <form action="" method="post">
                <input type="text" class="text" name="username" id="username" required="">
                <label for="username"><span>username</span></label>
                <br>
                <br>
                <input type="password" class="text" name="password" id="password" required="">
                <label for="password"><span>password</span></label>
                <br>
                <div>
                    <input class="signin" type="submit" value="log in">
                </div>
                <hr>
                <a href="#">Forgot Password?</a>
                <br>
                <a href="signup.jsp">Sign Up</a>
            </form>

        </div>
    </body>
</html>

