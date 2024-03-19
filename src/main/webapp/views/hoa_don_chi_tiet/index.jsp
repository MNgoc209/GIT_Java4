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
        <td>Mã hóa đơn</td>
        <td>Mã sản phẩm chi tiết</td>
        <td>Số lượng</td>
        <td>Đơn giá</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="hdct">
        <tr>
            <td>${hdct.id}</td>
            <td>${hdct.maHD}</td>
            <td>${hdct.maSPCT}</td>
            <td>${hdct.soLuong}</td>
            <td>${hdct.donGia}</td>
            <td>${hdct.trangThai == 1?"Đã thanh toán":"Chưa thanh toán"}</td>
            <td>
                <a href="/BTVN_B2_war_exploded/hoa-don-chi-tiet/edit?id=${hdct.id}" class="btn btn-outline-success">Update</a>
                <a href="/BTVN_B2_war_exploded/hoa-don-chi-tiet/delete?id=${hdct.id}" class="btn btn-outline-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
