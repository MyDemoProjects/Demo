<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("basePath", basePath.replace(":80/", "/"));
%>
<!doctype html>
<html>
<head>
    <base href="${basePath}">
    <title>首页</title>
    <script type="text/javascript" src="${basePath}staticResource/js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#vidDiv").height($(window).height());
            $("#vidDiv").width(document.documentElement.clientWidth);
            $("#barDiv").css("left", ($(document).width() - $("#barDiv").width())/2);
            $("#barDiv").css("top", (getClientHeight() - $("#barDiv").height())/2);
        });

        function getClientHeight() {
            var clientHeight = 0;
            if (document.body.clientHeight && document.documentElement.clientHeight) {
                clientHeight = Math.min(document.body.clientHeight,
                        document.documentElement.clientHeight);
            } else {
                clientHeight = Math.max(document.body.clientHeight,
                        document.documentElement.clientHeight);
            }
            return clientHeight;
        }

        function getMyClientHeight() {
            return document.documentElement.clientHeight;
        }


        function getMyClientWidth() {
            return document.documentElement.clientWidth;
        }
    </script>
    <style>
        *{
            padding: 0px;
            margin: 0px;
        }
        .videoStyle {
            width: 100%;
            height: 100%;
            padding: 0px;
            margin: 0px;
        }
        .mask {
            position: fixed;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            background-color: #000;
            opacity: .4;
        }

        #barDiv {
            position: absolute;
            opacity: 1;
        }

        .btnStyle {
            height: 40px;
            width: 100px;
            line-height: 40px;
            font-size: 20px;
            margin-right: 50px;
            text-align: center;
            display: inline-block;
            border: 1px solid #3CC;
            background-color: #fff;
            color: #000;
            text-decoration: none;
        }

        a:hover {
            color: #fff;
            background-color: grey;
            border: 1px solid #F0F;
        }
    </style>
</head>
<video id="vidDiv" src="${basePath}staticResource/video/bgVideo.mp4" autoplay loop class="videoStyle">
    <p>暂不支持视频</p>
</video>
<div id="mask" class="mask">
    <div id="barDiv">
        <a class="btnStyle" href="${basePath}clientHome/">登&nbsp;陆</a>
        <a class="btnStyle" href="javascript:;">注&nbsp;册</a>
    </div>
</div>
<body>
</body>
</html>