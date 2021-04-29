<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" href="css/register.css">
<!--导入jquery-->
<script src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp"   />
	<!-- 头部 end -->	
	<div class="rg_layout">
		<div class="rg_form clearfix">
			<div class="rg_form_left">
				<p>新用户注册</p>
				<p>USER REGISTER</p>
			</div>
			<div class="rg_form_center">
				<!--注册表单-->
				<form id="registerForm"  action="register.do" method="post"> 
					<!--提交处理请求的标识符-->
					<input type="hidden" name="action" value="register">
					<table style="margin-top: 25px;">
						<tr>
          <td class="td_left" colspan="2">
       <center><text id="error" style ="color:red">用户已存在,请更换用户名!</text></center> 
       </td>
      </tr>
       <td class="td_left"><label for="username">用户名</label></td>
       <td class="td_right">
       <input type="text" id="username" name="username" placeholder="请输入账号" onchange="checkUser()">
       </td>
      </tr>
						<tr>
							<td class="td_left"><label for="password">密码</label></td>
							<td class="td_right"><input type="text" id="password"
								name="password" placeholder="请输入密码"></td>
						</tr>
						<tr>
							<td class="td_left"><label for="email">Email</label></td>
							<td class="td_right"><input type="text" id="email"
								name="email" placeholder="请输入Email"></td>
						</tr>
						<tr>
							<td class="td_left"><label for="name">姓名</label></td>
							<td class="td_right"><input type="text" id="name"
								name="name" placeholder="请输入真实姓名"></td>
						</tr>
						<tr>
							<td class="td_left"><label for="telephone">手机号</label></td>
							<td class="td_right"><input type="text" id="telephone"
								name="telephone" placeholder="请输入您的手机号"></td>
						</tr>
						<tr>
							<td class="td_left"><label for="sex">性别</label></td>
							<td class="td_right gender"><input type="radio" id="sex"
								name="sex" value="男" checked> 男 <input type="radio"
								name="sex" value="女"> 女</td>
						</tr>
					<tr>
							<td class="td_left"><label for="birthday">出生日期</label></td>
							<td class="td_right"><input type="date" id="birthday"
								name="birthday" placeholder="年-月-日"></td>
						</tr>
						<tr>
							<td class="td_left"><label for="check">验证码</label></td>
							<td class="td_right check"><input type="text" id="check"
								name="check" class="check"> <a href="javaScript:randomcode_refresh()"><img id="randomcode_img"  onclick="refreshRandom()"
       					src="randomCode.captcha"  height="30" width="120"></a>
								</td>
						</tr>
						<tr>
							<td class="td_left"></td>
							<td class="td_right check"><input type="submit"
								class="submit" value="注册"> <span id="msg"
								style="color: red;"></span></td>
							 
						</tr>
					</table>
				</form>
			</div>
			<div class="rg_form_right">
				<p>
					已有账号？ <a href="login.jsp">立即登录</a>
				</p>
			</div>
		</div>
	</div>
	<!--引入尾部-->
	<div id="footer">
		<!-- 尾部 start-->
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
				<dd style="margin-right: 0px;">
					<h1>贴心服务</h1>
					<h2>客服全年无休，安心买</h2>
				</dd>
			</dl>
		</div>
		<div class="company">
			<p>北京去哪儿科技股份有限公司 版权所有Copyright 2006-2018, All Rights Reserved</p>
		</div>
		</footer>
	</div>
	<!--导入布局js，共享header和footer-->
	<script type="text/javascript" src="js/include.js"></script>
    <script>
    
    	$("#error").hide();
    	
		function randomcode_refresh() {
			$("#randomcode_img").attr("src",
					"randomCode.captcha?date=" + new Date());
		}
    	
		function checkUser(){
			var username = $("#username").val();
			
			$.get("exist.do",{
				username:username 
			},function(result){ 
				if (result ==1){
					$("#error").show();

				}
				if(result ==0){
					$("#error").hide();
				}
			});
			
		}
		
    	
    </script>
</body>
</html>