<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 08/03/2024
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/mau-sac/store">
    <div>
        <label class="form-label">ID</label>
        <input type="text" name="id" class="form-control">
    </div>

    <div>
        <label class="form-label">Mã</label>
        <input type="text" name="maMS" class="form-control">
    </div>

    <div>
        <label class="form-label">Tên</label>
        <input type="text" name="tenMS" class="form-control">
    </div>

    <div>
        <label class="form-label">Trạng thái</label>
        <input type="radio" name="trangThai" value="1" checked class="form-radio">Active
        <input type="radio" name="trangThai" value="0" class="form-radio">Inactive
    </div>

    <div>
        <button class="btn btn-primary">Thêm</button>
    </div>
</form>
</body>
</html>
