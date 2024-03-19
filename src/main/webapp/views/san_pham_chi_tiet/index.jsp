<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 13/03/2024
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Mã</td>
        <td>Mã kích thước</td>
        <td>Mã màu sắc</td>
        <td>Mã sản phẩm</td>
        <td>Số lượng</td>
        <td>Đơn giá</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="spct">
        <tr>
            <td>${spct.id}</td>
            <td>${spct.maSPCT}</td>
            <td>${spct.maKT}</td>
            <td>${spct.maMS}</td>
            <td>${spct.maSP}</td>
            <td>${spct.soLuong}</td>
            <td>${spct.donGia}</td>
            <td>${spct.trangThai == 1?"Còn hàng":"Hết hàng"}</td>
            <td>
                <a href="/BTVN_B2_war_exploded/san-pham-chi-tiet/edit?maSPCT=${spct.maSPCT}" class="btn btn-outline-success">Update</a>
                <a href="/BTVN_B2_war_exploded/san-pham-chi-tiet/delete?maSPCT=${spct.maSPCT}" class="btn btn-outline-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
