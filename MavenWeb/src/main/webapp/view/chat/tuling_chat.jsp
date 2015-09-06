<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("basePath", basePath.replace(":80/", "/"));
%>
<html>
<head>
    <title>聊天</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%-- <script src="../../js/jquery-2.1.4.js"></script>--%>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .container {
            min-width: 300px;
            max-width: 700px;
            height: 100%;
            margin: 0px auto;
            border: 1px solid rgba(199, 199, 199, 0.5);
            background-color: #f3f3f3;
        }

        .msgWindow {
            width: 90%;
            margin: 0px auto;
            margin-top: 20px;
            padding: 5px;
            height: 250px;
            border: 1px solid #ccc;
            overflow-y: scroll;
            background-color: #fff;
        }

        .get {
            text-align: left;
            margin-top: 5px;
            margin-right: 30%;
        }

        .send {
            text-align: right;
            margin-top: 5px;
            margin-left: 30%;
        }

        .sendMsg {
            max-width: 70%;
            display: inline-block;
            vertical-align: top;
            border: 1px solid rgba(200, 200, 200, 0.5);
            border-radius: 5px;
        }

        .getMsg {
            max-width: 70%;
            display: inline-block;
            vertical-align: top;
            border: 1px solid rgba(200, 200, 200, 0.5);
            border-radius: 5px;
        }
    </style>
    <script src="${basePath}js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
           window.setTimeout(function(){
               createDivAppend(null, "get", getString("亲,T-800竭诚为您服务~", false), $("#result"));
           }, 1000);
        });
        function doSubmit() {
            $("#subBtn").attr('disabled', "true");
            $("#info").attr('readonly', "readonly");
            createDivAppend(null, "send", getString($('#info').val(), true), $("#result"));
            var info = $('#info').val();
            var url = '${basePath}chat/getChatContainer';
            $.get(url, {
                info: info
            }, function (json) {
                if (json != null) {
                    createDivAppend(null, "get", getString(json.text, false), $("#result"));
                    $('#info').val("");
                    $("#result").animate({scrollTop: $('#result')[0].scrollHeight}, 1000);
                }
                $("#subBtn").removeAttr("disabled");
                $("#info").removeAttr("readonly");
            });

        }
        /** 在parentDom中添加一个div，并且是第一个子元素 */
        function createDivPrepend(idStr, classStr, htmlStr, parentDom) {
            $("<div/>", {
                id: idStr,
                class: classStr,
                html: htmlStr
            }).prependTo(parentDom);
        }

        /** 在parentDom中添加一个div，并且是最后子元素 */
        function createDivAppend(idStr, classStr, htmlStr, parentDom) {
            $("<div/>", {
                id: idStr,
                class: classStr,
                html: htmlStr
            }).appendTo(parentDom);
        }

        function getString(txt, flag) {
            if (flag) { //发送方
                return "<div clas='send'><div class='sendMsg'>" + txt + "</div><label style='color: rosybrown;'>&nbsp;我</label></div>";
            } else { //接收数据
                return "<div clas='get'><label style='color: darkseagreen;'>T-800&nbsp;</label><div class='getMsg'>" + txt + "</div></div>";
            }
        }
        /*键盘按下*/
        function doKeyDown(event) {
            var keynum = document.all ? window.event.keyCode : arguments.callee.caller.arguments[0].which;
            if (event.ctrlKey && keynum == 13) {
                doSubmit();
                return false;
            }
        }
    </script>
</head>
<body>
<div id="container" class="container">
    <h2 style="margin-top: 40px; text-align: center;">智能聊天机器人</h2>
    <div style="margin: 0 auto;text-align: center;">
        <input type="range" max="2" min="0" step="1" value="0" style="width: 100%;border: none;">
    </div>
    <div id="result" class="msgWindow">
    </div>
    <div style="width: 90%;margin: 0px auto;text-align: right;margin-top: 1px;">
        <textarea rows="3" placeholder="请输入内容" name="info" id="info" style="width:100%;color:#747474;"
                  onkeydown="return  doKeyDown(event);"></textarea>
        <br>
        <input id="subBtn" type="button" onclick="doSubmit()" value="发送" onkeydown="return  doKeyDown(event);">
    </div>
</div>
</body>
</html>
