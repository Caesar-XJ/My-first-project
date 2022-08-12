<%--
  Created by IntelliJ IDEA.
  User: 13415
  Date: 2022/8/12
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="../include/header.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
            <form role="form">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" />
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" />
                <button type="submit" class="btn btn-default">登录</button>
            </form>
</body>
</html>
