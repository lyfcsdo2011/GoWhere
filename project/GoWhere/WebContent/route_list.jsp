<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>去哪儿-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp"   />
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="images/search.png" alt="">
                <p>去哪儿><span>搜索结果</span></p>
            </div>

            <div class="xinxi clearfix">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul>
                        <c:choose>
          			<c:when test="${ empty requestScope.RouteList }">
          			<tr><td colspan="10" align="center" bgcolor="#FFFFFF"><div class="STYLE1" style="font-size:36px;color:red;">本次查询没有商品！</div></td></tr>
          			</c:when>
          			<c:otherwise>
          			<c:forEach items="${requestScope.RouteList}"   var="routes"  varStatus="status">
          			<li>
                            <div class="img"><img src="${routes.rimage }" alt="" width="299" height="169"></div>
                            <div class="text1">
                            <p title="${routes.rname}">${fn:substring(routes.rname,0,35)}...</p>
                            
                            <br/>
                            <p>${routes.routeIntroduce}</p>       
                            </div>
                            <div class="price">
                            <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${routes.price}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="routedetail.do?rid=${routes.rid }">查看详情</a></p>
                            </div>      
                            </li>     
          			</c:forEach>
          			</c:otherwise>
          			</c:choose>
                    </ul>
                    <div class="page_num_inf">
                        <i></i> <span>${requestScope.pageVO.page}</span>
                        /
                        <span>${requestScope.pageVO.pageCount}</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span>${requestScope.pageVO.recordCount}</span>条
                    </div>
                    <div class="pageNum">
                        <ul>
                            <li><a href="javascript:toPage(1)">首页</a></li>
                            <li class="threeword"><a href="javascript:toPage(${requestScope.pageVO.page-1})">上一页</a></li>
                            <c:forEach begin="${requestScope.beginPage}" end="${requestScope.engPage}" var="pageIndex">
                            	<li><a href="javascript:toPage(${pageIndex})">${pageIndex}</a></li>
                         	</c:forEach>
                            <li class="threeword"><a href="javascript:toPage(${requestScope.pageVO.page+1});">下一页</a></li>
                            <li class="threeword"><a href="javascript:toPage(${requestScope.pageVO.pageCount})">末页</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right">
                    <div class="top">
                        <div class="hot">HOT</div>
                        <span>热门推荐</span>
                    </div>
                    <ul>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--引入头部-->
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