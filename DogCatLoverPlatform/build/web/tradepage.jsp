<%-- 
    Document   : tradepage
    Created on : Oct 4, 2023, 12:19:15 AM
    Author     : overw
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
    <link href="/assets/css/trade.css" rel="stylesheet">
    
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
                        <a href="forums.jsp" class="nav-item nav-link">Forums</a>
                        <a href="tradepage.jsp" class="nav-item nav-link active">Trade</a>
<!--                        <div class="nav-item dropdown">
                            <a href="tradepage.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown">Trade</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="#" class="dropdown-item">Dog</a>
                                <a href="#" class="dropdown-item">Cat</a>
                                <a href="#" class="dropdown-item">Items</a>
                            </div>
                        </div>-->
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                    </div>

                </div>
            </nav>
        </div>
        <!-- Navbar End -->
        <div class="container mt-4">

            <!-- Page Title -->
            <h1>Cat & Dog Trading</h1>

            <!-- Item Listings -->
            <div class="row pb-3">
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/cat-1.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">American Cat</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=Nguyen&email=nguyen@gmail.com">Nguyên</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#">Cat</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/cat-2.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">British Longhair Cat</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=An&email=an@gmail.com">An</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#Cat">Cat</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/cat-3.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">Munchkin Cat</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=Kiet&email=kiet@gmail.com">Kiệt</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#Cat">Cat</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/dog-1.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">Pug Dog</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=Tan&email=tan@gmail.com">Tân</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#Dog">Dog</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/dog-2.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">Alaska Dog</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=Khang&email=khang@gmail.com">Khang</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#Dog">Dog</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top img-fluid" src="assets/img/dog-3.jpg" alt="">
                        <div class="card-body bg-light p-4">
                            <h4 class="card-title text-truncate">Corgi Dog</h4>
                            <div class="d-flex mb-3">
                                <small class="mr-2"><i class="fa fa-user text-muted"></i> <a href="viewprofile.jsp?username=Phuoc&email=phuoc@gmail.com">Phước</a></small>
                                <small class="mr-2"><i class="fa fa-folder text-muted"></i> <a href="#Dog">Dog</a></small>
                                <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                            </div>
                            <p>Welcome to our thread dedicated to keeping our furry friends in the best possible health!...</p>
                            <a class="font-weight-bold" href="thread.jsp">Contact</a>
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

