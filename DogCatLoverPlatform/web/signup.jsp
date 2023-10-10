<%-- 
    Document   : signup
    Created on : Oct 2, 2023, 4:34:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cat Dog Lover Sign Up</title>
        
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
        
    </head>
    <body>
        <div class="registry">
            <div class="header">
                <h2 class="active">Sign Up</h2>
            </div>
            <br>
            <form action="" method="post">
                <div>
                    <label for="fullname">Full Name:</label>
                    <input type="text" id="fullname" class="text" name="fullname" required>
                </div>
                <br>
                <br>
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" class="text" name="username" required>
                </div>
                <br>
                <br>
                <div>
                    <label for="phonenumber">Phone Number:</label>
                    <input type="text" id="phonenumber" class="text" name="phonenumber" required>
                </div>
                <br>
                <br>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" class="text" name="password" required>
                </div>
                <br>
                <br>
                <div>
                    <input class="signup" type="submit" value="sign up">
                </div>
            </form>
        </div>
    </body>
</html>
