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
        <td>Tên khách hàng</td>
        <td>Số điện thoại</td>
        <td>Mã khách hàng</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.tenKH}</td>
            <td>${kh.soDienThoai}</td>
            <td>${kh.maKH}</td>
            <td>${kh.trangThai == 1?"Khách hàng cũ":"Khách hàng mới"}</td>
            <td>
                <a href="/BTVN_B2_war_exploded/khach-hang/edit?maKH=${kh.maKH}" class="btn btn-outline-success">Update</a>
                <a href="/BTVN_B2_war_exploded/khach-hang/delete?maKH=${kh.maKH}" class="btn btn-outline-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
