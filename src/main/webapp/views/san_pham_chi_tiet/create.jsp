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
<form method="post" action="/BTVN_B2_war_exploded/san-pham-chi-tiet/store">
    <div>
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id">
    </div>

    <div>
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="maSPCT">
    </div>

    <div>
        <label class="form-label">Mã kích thước</label>
        <input type="text" class="form-control" name="maKT">
    </div>

    <div>
        <label class="form-label">Mã màu sắc<</label>
        <input type="text" class="form-control" name="maMS">
    </div>

    <div>
        <label class="form-label">Mã sản phẩm</label>
        <input type="text" class="form-control" name="maSP">
    </div>

    <div>
        <label class="form-label">Số lượng</label>
        <input type="text" class="form-control" name="soLuong">
    </div>

    <div>
        <label class="form-label">Đơn giá</label>
        <input type="text" class="form-control" name="donGia">
    </div>

    <div>
        <label class="form-label">Trạng thái</label>
        <input type="radio" class="form-radio" name="trangThai" value="1" checked>Còn hàng
        <input type="radio" class="form-radio" name="trangThai" value="0">Hết hàng
    </div>

    <button class="btn btn-outline-primary">Thêm</button>
</form>
</body>
</html>
