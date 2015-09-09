<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("basePath", basePath.replace(":80/", "/"));
%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${basePath}staticResource/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}staticResource/css/login.css"/>

    <script type="text/javascript" src="${basePath}staticResource/js/jquery-2.1.4.js"></script>

    <script>
        var submitForm = function () {
            var sysUser = {
                account: $("#username").val().trim(),
                password: $("#password").val()
            }
            $.ajax({
                type: 'post',
                url: '${basePath}clientHome/login',
                data: sysUser,
                cache: false,
                dataType: 'json',
                success: function (result) {
                    if(result.id == 0) {
                        alert(result.msg);
                    } else if(result.id == 1) {
                       /* window.location.href = "${basePath}clientManager/index";*/
                        $("#myForm").submit();
                    } else {
                        alert("没有返回值啊");
                    }
                }
            });

        }

    </script>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="${basePath}clientManager/index" method="post" id="myForm">
            <h1>Login Form</h1>

            <div>
                <input type="text" placeholder="您的邮箱" required="" id="username" name="account"/>
            </div>
            <div>
                <input type="password" placeholder="您的密码" required="" id="password" name="password"/>
            </div>
            <div>
                <input type="button" value="Log in" onclick="submitForm();"/>
                <a href="#">Lost your password?</a>
                <a href="#">Register</a>
            </div>
        </form>
    </section>
</div>
</body>
</html>