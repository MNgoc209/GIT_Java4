<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 14/03/2024
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/kich-thuoc/update">
    <div>
        <label class="form-label">ID</label>
        <input type="text" name="id" class="form-control" value="${kt.id}">
    </div>

    <div>
        <label class="form-label">Mã</label>
        <input type="text" name="maKT" class="form-control" value="${kt.maKT}">
    </div>

    <div>
        <label class="form-label">Tên</label>
        <input type="text" name="tenKT" class="form-control" value="${kt.tenKT}">
    </div>

    <div>
        <label class="form-label">Trạng thái</label>
        <input type="radio" name="trangThai" value="1" checked class="form-radio" ${kt.trangThai == 1?"checked":""}>Còn hàng
        <input type="radio" name="trangThai" value="0" class="form-radio" ${kt.trangThai == 0?"checked":""}>Hết hàng
    </div>

    <div>
        <button class="btn btn-primary">Update</button>
    </div>
</form>
</body>
</html>