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
        <td>Mã nhân viên</td>
        <td>Mã khách hàng</td>
        <td>Ngày mua hàng</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="hd">
        <tr>
            <td>${hd.id}</td>
            <td>${hd.maHD}</td>
            <td>${hd.maNV}</td>
            <td>${hd.maKH}</td>
            <td>${hd.ngayMuaHang}</td>
            <td>${hd.trangThai == 1?"Đã thanh toán":"Chưa thanh toán"}</td>
            <td>
                <a href="/BTVN_B2_war_exploded/hoa-don/edit?maHD=${hd.maHD}" class="btn btn-outline-success">Update</a>
                <a href="/BTVN_B2_war_exploded/hoa-don/delete?maHD=${hd.maHD}" class="btn btn-outline-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
