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
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
  <title>梦幻空间管理系统</title>
  <link href="${basePath}staticResource/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
 <%-- <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />--%>
  <link rel="stylesheet" type="text/css" href="${basePath}staticResource/easyui/themes/icon.css" />

  <script type="text/javascript" src="${basePath}staticResource/js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="${basePath}staticResource/easyui/jquery.easyui.min.js"></script>

 <%-- <script type="text/javascript" src='js/outlook2.js'> </script>--%>

  <script type="text/javascript">
    var _menus = {"menus":[
      {"menuid":"1","icon":"icon-sys","menuname":"系统管理",
        "menus":[{"menuname":"菜单管理","icon":"icon-nav","url":"http://www.16sucai.com"},
          {"menuname":"添加用户","icon":"icon-add","url":"demo.html"},
          {"menuname":"用户管理","icon":"icon-users","url":"demo2.html"},
          {"menuname":"角色管理","icon":"icon-role","url":"demo2.html"},
          {"menuname":"权限设置","icon":"icon-set","url":"demo.html"},
          {"menuname":"系统日志","icon":"icon-log","url":"demo.html"}
        ]
      },{"menuid":"8","icon":"icon-sys","menuname":"员工管理",
        "menus":[{"menuname":"员工列表","icon":"icon-nav","url":"demo.html"},
          {"menuname":"视频监控","icon":"icon-nav","url":"demo1.html"}
        ]
      },{"menuid":"56","icon":"icon-sys","menuname":"部门管理",
        "menus":[{"menuname":"添加部门","icon":"icon-nav","url":"demo1.html"},
          {"menuname":"部门列表","icon":"icon-nav","url":"demo2.html"}
        ]
      },{"menuid":"28","icon":"icon-sys","menuname":"财务管理",
        "menus":[{"menuname":"收支分类","icon":"icon-nav","url":"demo.html"},
          {"menuname":"报表统计","icon":"icon-nav","url":"demo1.html"},
          {"menuname":"添加支出","icon":"icon-nav","url":"demo.html"}
        ]
      },{"menuid":"39","icon":"icon-sys","menuname":"商城管理",
        "menus":[{"menuname":"商品分","icon":"icon-nav","url":"/shop/productcatagory.aspx"},
          {"menuname":"商品列表","icon":"icon-nav","url":"/shop/product.aspx"},
          {"menuname":"商品订单","icon":"icon-nav","url":"/shop/orders.aspx"}
        ]
      }
    ]};
    //设置登录窗口
    function openPwd() {
      $('#w').window({
        title: '修改密码',
        width: 300,
        modal: true,
        shadow: true,
        closed: true,
        height: 160,
        resizable:false
      });
    }
    //关闭登录窗口
    function close() {
      $('#w').window('close');
    }



    //修改密码
    function serverLogin() {
      var $newpass = $('#txtNewPass');
      var $rePass = $('#txtRePass');

      if ($newpass.val() == '') {
        msgShow('系统提示', '请输入密码！', 'warning');
        return false;
      }
      if ($rePass.val() == '') {
        msgShow('系统提示', '请在一次输入密码！', 'warning');
        return false;
      }

      if ($newpass.val() != $rePass.val()) {
        msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
        return false;
      }

      $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
        msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
        $newpass.val('');
        $rePass.val('');
        close();
      })

    }

    $(function() {

      openPwd();
      //
      $('#editpass').click(function() {
        $('#w').window('open');
      });

      $('#btnEp').click(function() {
        serverLogin();
      })



      $('#loginOut').click(function() {
        $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

          if (r) {
            location.href = '/ajax/loginout.ashx';
          }
        });

      })



    });



  </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
  <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
  </div></noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
  <span style="float:right; padding-right:20px;" class="head">欢迎 16素材 <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
  <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" /> 16素材网  www.16sucai.com</span>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
  <div class="footer">By 疯狂秀才 Email:bjhxl@59ibox.cn</div>
</div>
<div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
  <div class="easyui-accordion" fit="true" border="false">
    <!--  导航内容 -->

  </div>

</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
  <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">

      <h1>Welcome to jQuery UI!</h1>

    </div>
  </div>
</div>


<!--修改密码窗口-->
<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
     maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
  <div class="easyui-layout" fit="true">
    <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
      <table cellpadding=3>
        <tr>
          <td>新密码：</td>
          <td><input id="txtNewPass" type="Password" class="txt01" /></td>
        </tr>
        <tr>
          <td>确认密码：</td>
          <td><input id="txtRePass" type="Password" class="txt01" /></td>
        </tr>
      </table>
    </div>
    <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
      <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
        确定</a> <a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)"
                  onclick="closeLogin()">取消</a>
    </div>
  </div>
</div>

<div id="mm" class="easyui-menu" style="width:150px;">
  <div id="mm-tabclose">关闭</div>
  <div id="mm-tabcloseall">全部关闭</div>
  <div id="mm-tabcloseother">除此之外全部关闭</div>
  <div class="menu-sep"></div>
  <div id="mm-tabcloseright">当前页右侧全部关闭</div>
  <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
  <div class="menu-sep"></div>
  <div id="mm-exit">退出</div>
</div>


</body>
</html>