<!DOCTYPE html>
<%@ page contentType="text/html;charsetUTF-8" language="java" pageEncoding="utf-8"%>
<html lang="xzz">
<meta http-equiv="Content-Type" charset="UTF-8">

<head>
    <meta charset="utf-8">
    <title>Admin | Shop Bánh Kem</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="admin/css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <% String error = (String) request.getAttribute("Error");%>
        <!-- Sign Up Start -->
        <div class="container-fluid bg_signin_signup">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <form class="bg-pink rounded p-4 p-sm-5 my-4 mx-3" action="Signup" method="post">
                        <h2 class="title-sg">Đăng ký</h2>
                        <div class="form-floating mb-3">
                            <input name="name" type="text" class="form-control" id="floatingText" placeholder="jhondoe">
                            <label for="floatingText">Tạo tên đăng nhập</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input onchange="check(this.value)" name="email" type="email"  class="form-control" id="floatingInput" placeholder="name@example.com">
                            <label for="floatingInput">Địa chỉ email</label>
                        </div>
                        <div class="form-floating mb-4">
                            <input name="pass" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                            <label for="floatingPassword">Tạo mật khẩu</label>
                        </div>
                        <div class="form-floating mb-4">
                            <input name="repass" type="password" class="form-control" id="floatingPassword1" placeholder="Password">
                            <label for="floatingPassword">Nhập lại mật khẩu</label>
                        </div>
                        <span id="insertTextHere"><%= error != null ? error:""%></span>
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <div class="form-check">
                                <input name="save-login" type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Lưu đăng nhập</label>
                            </div>

                        </div>
                        <button o type="submit" class="btn btn-primary py-3 w-100 mb-4">Đăng ký</button>
                        <p class="text-center mb-0">Bạn đã có tài khoản? <a href="signin.jsp">Đăng nhập</a></p>
                    </form>
                </div>
            </div>
        </div>
        <!-- Sign Up End -->
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="admin/lib/chart/chart.min.js"></script>
    <script src="admin/lib/easing/easing.min.js"></script>
    <script src="admin/lib/waypoints/waypoints.min.js"></script>
    <script src="admin/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="admin/lib/tempusdominus/js/moment.min.js"></script>
    <script src="admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Template Javascript -->
    <script src="admin/js/main.js"></script>
    <script src="js/main.js"></script>
</body>

</html>