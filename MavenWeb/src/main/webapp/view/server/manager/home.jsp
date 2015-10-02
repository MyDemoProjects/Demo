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
<!doctype html>
<html>
<head id="Head1">
    <base href="${basePath}">
    <title>梦幻空间管理系统</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/staticResource/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/staticResource/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/staticResource/easyui/themes/icon.css"/>

    <script type="text/javascript" src="${basePath}/staticResource/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="${basePath}/staticResource/easyui/jquery.easyui.min.js"></script>
    <!--<script type="text/javascript" src="./../staticResource/js/outlook2.js"></script>-->
    <script type="text/javascript">
        var basePath = "${basePath}";
        $(function () {
            // $('#menu').accordion();
            console.log("用户信息");
           var menus = eval('${menus}');
            initAccordion(menus);
        });

        /*初始化菜单*/
        function initAccordion(menus) {
            $.each(menus, function (index, obj) {
                console.log(index + "  " + this.menuName);
                $("#menus").accordion("add", {
                    title: this.menuName,
                    content: getSubMenu($(this.subMenus)),
                    iconCls: "icon-sys",
                    selected: index == 0 ? true : false
                });
            });
        }

        function getSubMenu(subMenus) {
            var tempStr;
            var menuList = "<ul>";
            var template = "<li><div><a href='[URL]' target='mainFrame'><span class='icon-log icon'></span>[URLTITLE]</a></div></li>";
            $.each(subMenus, function (index, obj) {
                tempStr = template;
                tempStr = tempStr.replace(/\[URL\]/g, this.menuUrl);
                tempStr = tempStr.replace(/\[URLTITLE\]/g, this.menuName);
                menuList += tempStr;
            });
            menuList += "</ul>";
            return menuList;
        }
    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！'/>
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url('') #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
  <span style="float:right; padding-right:20px;" class="head">欢迎来到梦幻空间管理系统
      <a href="#" id="editpass">修改密码</a>
      <a href="#" id="loginOut">安全退出</a>
  </span>
  <span style="padding-left:10px; font-size: 16px; ">
      <img style="border-radius: 50%;" src="${basePath}staticResource/image/common/logo.png" width="20" height="20"
           align="absmiddle"/>
  </span>
</div>
<div region="west" split="true" title="导航菜单" style="width:200px;" id="west">
    <div style="width: 200px; height: 300px; overflow: hidden;" id="menus" border="false" fit="true"
         class="easyui-accordion">
    </div>
</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
            <h1>欢迎来到梦幻空间管理系统</h1>
        </div>
    </div>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    <div class="footer"><strong>梦幻空间</strong> 风雪孤客 Email:<a href="mailto:fengxueguke@yeah.net?subject=关于">fengxueguke@yeah.net</a></div>
</div>
</body>
</html>