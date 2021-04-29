<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>去哪儿网-登录</title>  
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      <!--导入angularJS文件-->
    <script src="js/angular.min.js"></script>
	<!--导入jquery-->
	<script src="js/jquery-3.3.1.js"></script>
</head>

<body>
	<jsp:include page="/header.jsp"   />
    <!-- 头部 end -->
    <section id="login_wrap">
        <div class="fullscreen-bg" style="background: url(images/login_bg.png);height: 532px;">
        	
        </div>
        <div class="login-box">
        	<div class="title">
        		<img src="images/login_logo.png" alt="">
        		<span>欢迎登录去哪儿旅游账户</span>
        	</div>
        	<div class="login_inner">
				
				<!--登录错误提示消息-->
        		<div id="errorMsg" class="alert alert-danger" >用户名不存在！</div>
        		
				<form id="loginForm" action="userlogin.do?rid=${requestScope.rid }" method="post" accept-charset="utf-8">
        			<input type="hidden" name="action" value="login"/>
					<input id="username" name="username" type="text" placeholder="请输入账号"  onchange="checkUser()" autocomplete="off">
        			<input name="password" type="text" placeholder="请输入密码" autocomplete="off">
        			  <input name="randomCode" type="text" placeholder="请输入验证码" autocomplete="off">
                      <a href="javaScript:randomcode_refresh()"><img id="randomcode_img"  onclick="refreshRandom()" 
                      src="randomCode.captcha"  height="30" width="120"></a>
             

                     <tr>
							<td class="td_left"></td>
							<td class="td_right check"><input type="submit"
								class="submit" value="登录"> </td>
						</tr>
        		</form>
        		<div class="reg">没有账户？<a href="register.jsp;">立即注册</a></div>
        	</div>
        </div>
    </section>
    <!--引入尾部-->
    <div id="footer"> <!-- 尾部 start-->
 
    <footer id="footer">
        <div class="why_select">
            <dl>
                <dt class="fl">
                    <img src="images/icon_1.jpg" alt="">
                </dt>
                <dd>
                    <h1>产品齐全</h1>
                    <h2>产品全自主选，随心买</h2>
                </dd>
            </dl>
            <dl>
                <dt class="fl">
                    <img src="images/icon_2.jpg" alt="">
                </dt>
                <dd>
                    <h1>便利快捷</h1>
                    <h2>24小时不打烊，随时买</h2>
                </dd>
            </dl>
            <dl>
                <dt class="fl">
                    <img src="images/icon_3.jpg" alt="">
                </dt>
                <dd>
                    <h1>安全支付</h1>
                    <h2>知名支付工具，放心买</h2>
                </dd>
            </dl>
            <dl>
                <dt class="fl">
                    <img src="images/icon_4.jpg" alt="">
                </dt>
                <dd style="margin-right:0px;">
                    <h1>贴心服务</h1>
                    <h2>客服全年无休，安心买</h2>
                </dd>
            </dl>
        </div>
        <div class="company">
            <p>北京去哪儿科技股份有限公司 版权所有Copyright 2006-2018, All Rights Reserved </p>
        </div>
    </footer></div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
    <script>
        $("#errorMsg").hide();
		function randomcode_refresh(){
			$("#randomcode_img").attr("src",
					"randomCode.captcha?date=" + new Date());
		}
		function checkUser(){
			var username = $("#username").val();
			
			$.get("exist.do",{
				username:username 
			},function(result){ 
				if (result ==0){
					$("#errorMsg").show();

				}
				if (result ==1){
					$("#errorMsg").hide();
				}
			});
		}
    	 	
    </script>

</body>

</html>