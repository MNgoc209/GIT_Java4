<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 16/03/2024
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/fontawesome.min.css">
</head>
<body>
<%--đầu trang--%>
<%--<div class="p-5 bg-danger-subtle text-danger-emphasis text-center">--%>
<%--    <h1>TR & RH</h1>--%>
<%--</div>--%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/BTVN_B2_war_exploded/ban-hang/index">
            <img src="../img/tap1.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            TR & RH --- Tokyo Revengers
        </a>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="/BTVN_B2_war_exploded/san-pham/index">Quản lý Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a href="/BTVN_B2_war_exploded/mau-sac/index">Quản lý Màu sắc</a>
                </li>
                <li class="nav-item">
                    <a href="/BTVN_B2_war_exploded/kich-thuoc/index">Quản lý Kích thước</a>
                </li>
                <li class="nav-item">
                    <a href="/BTVN_B2_war_exploded/nhan-vien/index">Quản lý Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a href="/BTVN_B2_war_exploded/khach-hang/index">Quản lý Khách hàng</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--thân--%>
<div class="container">
    <h2 class="text-center">SẢN PHẨM BÁN CHẠY</h2>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card h-80" style="width: 18rem">
                <%--                <img src="..." class="card-img-top  img-fluid" alt="...">--%>
                <a href="#"><img src="../img/tap1.jpg" class="card-img-top"></a>
                <div class="card-body">
                    <h5 class="card-title">Tokyo Revengers Tập 1</h5>
                    <a href="#" class="btn btn-primary">Thêm vào giỏ</a>
                    <a href="#" class="btn btn-outline-success">Mua hàng</a>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card h-80" style="width: 18rem">
                <a href="#"><img src="../img/tap2.jpg" class="card-img-top"></a>
                <div class="card-body">
                    <h5 class="card-title">Tokyo Revengers Tập 2</h5>
                    <a href="#" class="btn btn-primary">Thêm vào giỏ</a>
                    <a href="#" class="btn btn-outline-success">Mua hàng</a>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card h-100">
                <img src="../img/tap3.webp" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">Tokyo Revengers Tập 3</h5>
                    <a href="#" class="btn btn-primary">Thêm vào giỏ</a>
                    <a href="#" class="btn btn-outline-success">Mua hàng</a>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card h-100">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card h-100">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card h-100">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                </div>
            </div>
        </div>
    </div>
</div>

<%--Footer--%>
<div class="mt-5 p-4 bg-danger p-2 bg-opacity-25 text-danger-emphasis max-height=auto">
    <h5 class="container"><strong>Địa chỉ: nhà A, Hà Nội</strong></h5>
    <i class="fa-brands fa-facebook fa-bounce fa-2xs" style="color: #B197FC;">
        <a href="https://www.facebook.com/ngoc209203"></a>
    </i>
</div>
</body>
</html>
