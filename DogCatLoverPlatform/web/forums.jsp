<%-- 
    Document   : forums
    Created on : Oct 2, 2023, 9:36:03 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <!-- Favicon -->
    <link href="img/icons8-pet-lover-16.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Flaticon Font -->
    <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row bg-secondary py-2 px-lg-5">
                <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-white pr-3" href="">FAQs</a>
                        <span class="text-white">|</span>
                        <a class="text-white px-3" href="">Help</a>
                        <span class="text-white">|</span>
                        <a class="text-white pl-3" href="">Support</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-white pl-3" href="login.jsp">
                            <i class="fa fa-user"></i> <br> Log in
                        </a>
                    </div>
                </div>
            </div>
            <div class="row py-3 px-lg-5">
                <div class="col-lg-4">
                    <a href="" class="navbar-brand d-none d-lg-block">
                        <h1 class="m-0 display-5 text-capitalize"><span class="text-primary">Dog&Cat</span>Lover</h1>
                    </a>
                </div>
                <div class="col-lg-8 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <div class="d-inline-flex flex-column text-center pr-3 border-right">
                            <h6>Support Hours</h6>
                            <p class="m-0">8.00AM - 9.00PM</p>
                        </div>
                        <div class="d-inline-flex flex-column text-center px-3 border-right">
                            <h6>Email Us</h6>
                            <p class="m-0">info@gmail.com</p>
                        </div>
                        <div class="d-inline-flex flex-column text-center pl-3">
                            <h6>Call Us</h6>
                            <p class="m-0">+012 345 6789</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar Start -->
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-lg-5">
                <a href="" class="navbar-brand d-block d-lg-none">
                    <h1 class="m-0 display-5 text-capitalize font-italic text-white"><span class="text-primary">Dog&Cat</span>Lover</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="index.jsp" class="nav-item nav-link">Home</a>
                        <a href="about.jsp" class="nav-item nav-link">About</a>
                        <a href="forums.jsp" class="nav-item nav-link active">Forums</a>
                        <a href="tradepage.jsp" class="nav-item nav-link">Trade</a>
                        <!--                        
                        <div class="nav-item dropdown">
                            <a href="tradepage.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown">Trade</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="#" class="dropdown-item">Dog</a>
                                <a href="#" class="dropdown-item">Cat</a>
                                <a href="#" class="dropdown-item">Items</a>
                            </div>
                        </div>
                        -->
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                    </div>

                </div>
            </nav>
        </div>
        <!-- Navbar End -->
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Categories</h5>
                            <ul class="list-group">
                                <li class="list-group-item"><a href="#thread-1">Health and Wellness</a></li>
                                <li class="list-group-item"><a href="#thread-2">Pet Parenthood</a></li>
                                <li class="list-group-item"><a href="#thread-3">Behavior and Training</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-md-9">
                    <!-- Thread cate 1 -->
                    <div id="thread-1" class="card">
                        <div class="card-body">
                            <h5 class="card-title">Health and Wellness</h5>
                            <ul class="list-group">
                                <li class="list-group-item"><a href="thread.jsp">Optimizing Feline Wellness: Health Tips for Cats and Dogs</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Feline Fitness: Exercise and Diet for Cats and Their Canine Companions</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Preventive Care: Building a Foundation for Cat and Dog Health</a></li>
                            </ul>
                        </div>
                    </div>
                    <br/>
                    <!-- Thread cate 2 -->
                    <div id="thread-2" class="card">
                        <div class="card-body">
                            <h5 class="card-title">Pet Parenthood</h5>
                            <ul class="list-group">
                                <li class="list-group-item"><a href="thread.jsp">Welcoming a New Fur Baby: Tips for First-Time Pet Owners</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Pet Routines and Schedules: Finding Balance in Daily Life</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Kitten Chronicles: Adventures in Raising a Playful Purr-ball</a></li>
                            </ul>
                        </div>
                    </div>
                    <br/>
                    <!-- Thread cate 3 -->
                    <div id="thread-3" class="card">
                        <div class="card-body">
                            <h5 class="card-title">Behavior and Training</h5>
                            <ul class="list-group">
                                <li class="list-group-item"><a href="thread.jsp">Social Butterflies: Nurturing Healthy Pet Interactions</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Barking, Meowing, and Beyond: Decoding Pet Communication</a></li>
                                <li class="list-group-item"><a href="thread.jsp">Crate Training Success Stories and Strategies</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
