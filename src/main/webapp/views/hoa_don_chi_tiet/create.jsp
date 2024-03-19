<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 19/03/2024
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/hoa-don-chi-tiet/store">
    <div>
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id">
    </div>

    <div>
        <label class="form-label">Mã hóa đơn</label>
        <input type="text" class="form-control" name="maHD">
    </div>

    <div>
        <label class="form-label">Mã SPCT</label>
        <input type="text" class="form-control" name="maSPCT">
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
        <input type="radio" class="form-radio" name="trangThai" value="1" checked>Đã thanh toán
        <input type="radio" class="form-radio" name="trangThai" value="0">Chưa thanh toán
    </div>
    <button class="btn btn-outline-primary">Add</button>
</form>
</body>
</html>
