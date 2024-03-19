<%--
  Created by IntelliJ IDEA.
  User: ngocb
  Date: 14/03/2024
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form method="post" action="/BTVN_B2_war_exploded/mau-sac/update">
  <div>
    <label class="form-label">ID</label>
    <input type="text" name="id" class="form-control" value="${ms.id}">
  </div>

  <div>
    <label class="form-label">Mã</label>
    <input type="text" name="maMS" class="form-control" value="${ms.maMS}">
  </div>

  <div>
    <label class="form-label">Tên</label>
    <input type="text" name="tenMS" class="form-control" value="${ms.tenMS}">
  </div>

  <div>
    <label class="form-label">Trạng thái</label>
    <input type="radio" name="trangThai" value="1" checked class="form-radio" ${ms.trangThai == 1? "checked":""}>Active
    <input type="radio" name="trangThai" value="0" class="form-radio" ${ms.trangThai == 0? "checked":""}>Inactive
  </div>

  <div>
    <button class="btn btn-primary">Update</button>
  </div>
</form>
</body>
</html>
