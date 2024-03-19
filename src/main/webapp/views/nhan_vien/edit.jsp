<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 15/03/2024
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/nhan-vien/update">
    <div>
        <label class="form-label">ID</label>
        <input type="text" name="id" class="form-control" value="${nv.id}">
    </div>

    <div>
        <label class="form-label">Tên</label>
        <input type="text" name="tenNV" class="form-control" value="${nv.tenNV}">
    </div>

    <div>
        <label class="form-label">Mã</label>
        <input type="text" name="maNV" class="form-control" value="${nv.maNV}">
    </div>

    <div>
        <label class="form-label">Username</label>
        <input type="text" name="tenDangNhap" class="form-control" value="${nv.tenDangNhap}">
    </div>

    <div>
        <label class="form-label">Password</label>
        <input type="text" name="matKhau" class="form-control" value="${nv.matKhau}">
    </div>

    <div>
        <label class="form-label">Trạng thái</label>
        <input type="radio" name="trangThai" value="1" checked class="form-radio" ${nv.trangThai == 1? "checked":""}>Đang làm việc
        <input type="radio" name="trangThai" value="0" class="form-radio" ${nv.trangThai == 0? "checked":""}>Nghỉ việc
    </div>

    <button class="btn btn-outline-primary">Update</button>
</form>
</body>
</html>