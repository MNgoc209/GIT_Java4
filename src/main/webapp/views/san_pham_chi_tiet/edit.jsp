<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 19/03/2024
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/san-pham-chi-tiet/update">
    <div>
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id" value="${spct.id}">
    </div>

    <div>
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="maSPCT" value="${spct.maSPCT}">
    </div>

    <div>
        <label class="form-label">Mã kích thước</label>
        <input type="text" class="form-control" name="maKT" value="${spct.maKT}">
    </div>

    <div>
        <label class="form-label">Mã màu sắc</label>
        <input type="text" class="form-control" name="maMS" value="${spct.maMS}">
    </div>

    <div>
        <label class="form-label">Mã sản phẩm</label>
        <input type="text" class="form-control" name="maSP" value="${spct.maSP}">
    </div>

    <div>
        <label class="form-label">Số lượng</label>
        <input type="text" class="form-control" name="soLuong" value="${spct.soLuong}">
    </div>

    <div>
        <label class="form-label">Đơn giá</label>
        <input type="text" class="form-control" name="donGia" value="${spct.donGia}">
    </div>

    <div>
        <label class="form-label">Trạng thái</label>
        <input type="radio" class="form-radio" name="trangThai" value="1" checked ${spct.trangThai==1?"checked":""}>Còn hàng
        <input type="radio" class="form-radio" name="trangThai" value="0" ${spct.trangThai==0?"checked":""}>Hết hàng
    </div>

    <button class="btn btn-outline-primary">Update</button>
</form>
</body>
</html>
