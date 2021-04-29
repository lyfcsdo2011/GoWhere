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
        <title>去哪儿网-我的收藏</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" href="css/index.css">
       <style>
           .tab-content .row>div {
            margin-top: 16px;
           } 
           .tab-content {
            margin-bottom: 36px;
           }
       </style>
       <script src="js/jquery-3.3.1.js"></script>
    </head>
    <body>
    	<jsp:include page="/header.jsp"   />
          <!-- 排行榜 start-->
          <script type="text/javascript">
                	function AtoPage(p){
                		document.myFavoriteForm.page.value = p;
                		document.myFavoriteForm.submit();
                	}
                </script>
        <section id="content">            
            <section class="hemai_jx">
            <form action = "users/myfavorite.do" name = "myFavoriteForm" method="post">
            <input type="hidden" name="page" value="">
                <div class="jx_top">
                    <div class="jx_tit">
                        <img src="images/icon_5.jpg" alt="">
                        <span>我的收藏</span>
                    </div>                    
                </div>
                
                <div class="jx_content">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                           
                              <c:forEach items="${requestScope.routeList}"   var="route"  varStatus="status">
                                <div class="col-md-3">
                                    <a href="routedetail.do?rid=${route.rid }">
                                        <img src="${route.rimage }" alt="">
                                        <div class="has_border">
                                            <h3>${route.rname }</h3>
                                            <div class="price">网付价<em>￥</em><strong>${route.price }</strong><em>起</em></div>
                                        </div>
                                    </a>
                                </div>
                                </c:forEach>
                            </div>
                        </div>                       
                    </div>
                </div>
                <div class="pageNum">
                
                    <ul>
                        <li><a href="javascript:AtoPage(1)">首页</a></li>
                        <li class="threeword"><a href="javascript:AtoPage(${requestScope.myFavPageVO.page-1 })">上一页</a></li>
                        <c:forEach begin="${requestScope.beginPage }" end="${requestScope.endPage }" var="pageIndex">
                            <li><a href="javascript:AtoPage(${pageIndex })">${pageIndex }</a></li>
                            </c:forEach>
                     
                        <li class="threeword"><a href="javascript:AtoPage(${requestScope.myFavPageVO.page+1 })">下一页</a></li>
                        <li class="threeword"><a href="javascript:AtoPage(${requestScope.myFavPageVO.pageCount })">末页</a></li>
                    </ul>
                </div>
                 </form>
            </section>   
                              
        </section>
        <!-- 排行榜 end-->
    	
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
        <!--导入布局js，共享header和footer-->
        <script type="text/javascript" src="js/include.js"></script>
    </body>
</html>