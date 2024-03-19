<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 09/03/2024
  Time: 5:42 PM
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
        <td>Tên</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="ms">
        <tr>
            <td>${ms.id}</td>
                <%--            lấy bên entity--%>
            <td>${ms.maMS}</td>
            <td>${ms.tenMS}</td>
            <td>${ms.trangThai==0? "Inactive":"Active"}</td>
            <td>
                <a href="/BTVN_B2_war_exploded/mau-sac/edit?maMS=${ms.maMS}" class="btn btn-outline-success">Update</a>
                <a href="/BTVN_B2_war_exploded/mau-sac/delete?maMS=${ms.maMS}" class="btn btn-outline-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
