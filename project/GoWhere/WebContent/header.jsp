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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--引入头部-->
<div id="header"><!-- 头部 start -->
    <header id="header">
        <div class="top_banner">
            <img src="images/top_banner.jpg" alt="">
        </div>
        <div class="shortcut">
        <c:choose>
        <c:when test="${empty sessionScope.users}">
        <!-- 未登录状态  -->
            <div class="login_out">
                <a href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
                </div>
        </c:when>
        <c:otherwise >
         <!-- 登录状态  -->
            <div class="login">
               <span>欢迎回来，${sessionScope.users.username }</span>
                <a href="users/myfavorite.do" class="collection">我的收藏</a>
                <a href="logout.do">退出</a>
            </div>
        </c:otherwise>  
        </c:choose>   
        </div>
        <div class="header_wrap">
            <div class="topbar">
                <div class="logo">
                    <a href="/"><img src="images/logo.jpg" alt=""></a>
                </div>
                <div class="search">
                 <script type="text/javascript">
                function toSearch(){
                	document.searchForm.submit();
                }
                function toPage(p){
                	document.searchForm.page.value=p;
                	document.searchForm.submit();            
                }
                </script>
                 <form action="routelist.do" methon="post" name="searchForm">
                	<input type="hidden" name="page" value="">
                    <input name="rname" type="text" placeholder="请输入路线名称"  value="${param.rname}" class="search_input" id="search_by" autocomplete="off">
                
                   <a href="javascript:toSearch();" class="search-button" id="qqq">搜索</a>   
                   </form>
                </div>
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9191</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- 头部 end -->
     <!-- 首页导航 -->
    <div class="navitem">
        <ul class="nav">
            <li class="nav-active"><a href="index.do">首页</a></li>
            <li><a href="routelist.do">线路</a></li>
            <li><a href="route_list.jsp">酒店</a></li>
            <li><a href="route_list.jsp">香港车票</a></li>
            <li><a href="route_list.jsp">出境游</a></li>
            <li><a href="route_list.jsp">国内游</a></li>
            <li><a href="route_list.jsp">港澳游</a></li>
            <li><a href="route_list.jsp">抱团定制</a></li>
            <li><a href="route_list.jsp">全球自由行</a></li>
            <li><a href="routesearch.do">收藏排行榜</a></li>
        </ul>
    </div></div>
</body>
</html>