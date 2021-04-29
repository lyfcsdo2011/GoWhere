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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>去哪儿网</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="/header.jsp"/>
    <!-- banner start-->
    <section id="banner">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <A href="routedetail.do?rid=1"><img src="images/banner_1.jpg" alt=""></A>
                </div>
                <div class="item">
                    <img src="images/banner_2.jpg" alt="">
                </div>
                <div class="item">
                    <img src="images/banner_3.jpg" alt="">
                </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
        </div>
    </section>
    <!-- banner end-->
    <!-- 旅游 start-->
    <section id="content">
         <!-- 去哪儿网精选start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_5.jpg" alt="">
                    <span>去哪儿网</span>
                </div>
                <!-- Nav tabs -->
                <ul class="jx_tabs" role="tablist">
                    <li role="presentation" class="active">
                        <span>
                        <a href="#popularity" aria-controls="popularity" role="tab" data-toggle="tab">人气旅游</a></span>
                    </li>
                    <li role="presentation">
                        <span>
                        <a href="#newest" aria-controls="newest" role="tab" data-toggle="tab">最新旅游</a></span>
                    </li>
                </ul>
            </div>
            <div class="jx_content">
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="popularity">
                        <div class="row">
                        	<c:forEach items="${requestScope.PopuList }" var="route">
                            <div class="col-md-3">
                                <a href="routedetail.do?rid=${route.rid }">
                                    <img src="${route.rimage }" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname }</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        	</c:forEach>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="newest">
                        <div class="row">
                       <c:forEach items="${requestScope.zuixin }" var="route">
                            <div class="col-md-3">
                                <a href="routedetail.do?rid=${route.rid }">
                                    <img src="${route.rimage }" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname }</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        	</c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 去哪儿网精选end-->
        <!-- 国内游 start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_6.jpg" alt="">
                    <span>国内游</span>
                </div>
                <div class="jx_tit" style="float:right" align="right">
                    <span >更多</span>
                </div>
            </div>
            <div class="heima_gn">
                <div class="guonei_l">
                    <img src="images/guonei_1.jpg" alt="">
                </div>
                <div class="guone_r">
                    <div class="row">
                        
                            <a href="route_detail.jsp">
								<c:forEach items="${requestScope.guonei}" var="route">
								<div class="col-md-4">
                                <a href="routedetail.do?rid=${route.rid }">
                                    <img src="${route.rimage }" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname }</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        	</c:forEach>
                        	</a>
                        	</div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 国内游 end-->
        <!-- 境外游 start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_7.jpg" alt="">
                    <span>境外游</span>
                </div>
                <div class="jx_tit" style="float:right" align="right">
                    <span >更多</span>
                </div>
            </div>
            <div class="heima_gn">
                <div class="guonei_l">
                    <img src="images/jiangwai_1.jpg" alt="">
                </div>
                <div class="guone_r">
                    <div class="row">
                        
                            <a href="route_detail.jsp ">
								<c:forEach items="${requestScope.guowai}" var="route">
                            <div class="col-md-4">
                                <a href="routedetail.do?rid=${route.rid }">
                                    <img src="${route.rimage }" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname }</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        	</c:forEach>
							</a>
                        </div>
                     
                    </div>
                </div>
            </div>
        </section>
        <!-- 境外游 end-->
    </section>
    <!-- 旅游 end-->
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
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>
</html>