<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fn" uri ="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
>
<title>收藏排行榜</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/ranking-list.css">
<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
function BtoSearch(p){
	document.rankForm.page.value = p;//为表单中的page设置值。
	document.rankForm.submit();//提交
}</script>
</head>
    <body>
		<jsp:include page="/header.jsp"/>
        <div class="contant">
        <form name = "rankForm" action ="routesearch.do" method="post">
            <div class="shaixuan">
        
                <span>线路名称</span>
                <input type="text" name="routeName" value="${param.routeName }">
                <span>金额</span>
                <input type="text" name="minRoutePrice" value="${param.minRoutePrice }">
                <input type="text" name="maxRoutePrice" value="${param.maxRoutePrice }">
                
                
                <button type="submit">搜索</button>
                
            </div>
                <input type = "hidden" name = "page" value = "">
            </form>
            <div class="list clearfix">
                <ul> 
                   <c:forEach items="${requestScope.routeList}"   var="route"  varStatus="status">
                   <li> 
                        <span class="num">${status.index+1} </span>
                        <a href="routedetail.do?rid=${route.rid }"><img src= "${route.rimage}" alt=""></a> 
                        <h4><a href="routedetail.do?rid=${route.rid }" title="${route.rname}">${fn:substring(route.rname,0,35)}...</a></h4>
                        <p>
                            <b class="price">&yen;<span>${route.price}</span>起</b>
                            <span class="shouchang">已收藏${route.favorite}次</span>
                        </p>
                    </li>
                   </c:forEach>  
                </ul>
            </div>
            <div class="pageNum">
                <ul>
                    <li><a href="javascript:BtoSearch(1)">首页</a></li>
                    <li class="threeword"><a href="javascript:BtoSearch(${requestScope.pageVO.page-1})">上一页</a></li>
                    
                <c:forEach begin="${requestScope.beginPage}" end="${requestScope.endPage}" var="p">
                     <li><a href="javascript:BtoSearch(${p })">${p}</a></li>
                </c:forEach>
                
                    <li class="threeword"><a href="javascript:BtoSearch(${requestScope.pageVO.page+1})">下一页</a></li>
                    <li class="threeword"><a href="javascript:BtoSearch(${requestScope.pageVO.pageCount})">末页</a></li>
                    

                </ul>
            </div>
        </div>
            
         <!--导入底部-->
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
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
    </body>
</html>