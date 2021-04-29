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
    <title>路线详情</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
</head>

<body>
<jsp:include page="/header.jsp"   />
    <!-- 详情 start -->   
    <div class="wrap">
        <div class="bread_box">
            <a href="/">首页</a>
            <span> &gt;</span>
            <a href="#">国内游</a><span> &gt;</span>
            <a href="#">${requestScope.route.rname}</a>
        </div>
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <img alt="" class="big_img" src="${requestScope.route.routeImgList[0].bigPic }">
                </dt>
                <dd>
                    <a class="up_img up_img_disable"></a>
                    <c:forEach items="${requestScope.route.routeImgList }" var="img">
                    <a title="" class="little_img" data-bigpic="${img.bigPic}">
                        <img src="${img.smallPic}">
                    </a>
                    </c:forEach>
                    <a class="down_img down_img_disable" style="margin-bottom: 0;"></a>
                </dd>
            </dl>
            <div class="prosum_right">
               <p class="pros_title">${requestScope.route.rname}</p>
                <p class="hot">1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
                <div class="pros_other">
                    <p>经营商家  ：去哪儿</p>
                    <p>咨询电话 : 400-618-9191</p>
                    <p>地址 ：北京中关村软件园</p> 
                </div>
                <div class="pros_price">
                    <p class="price"><strong>¥${requestScope.route.price }</strong><span>起</span></p>
                    <p class="collect">
                    <c:choose>
                    <c:when test="${requestScope.isFavorite }">
                        <a class="btn" href="favorite.do?rid=${requestScope.route.rid } " onclick="alert('已取消')"><i class="glyphicon glyphicon-heart-empty"></i>取消收藏</a>
                    </c:when>
                    <c:otherwise>
                     <c:choose> 
                      <c:when test="${empty sessionScope.users }">
                        <a class="btn" href="favorite.do?rid=${requestScope.route.rid }"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                      </c:when>
                     <c:otherwise>
                        <a class="btn" href="favorite.do?rid=${requestScope.route.rid }"  onclick="alert('已收藏')"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                     </c:otherwise>
                    </c:choose>
                    </c:otherwise>
                    </c:choose>
                        <a class="btn" href="buy.do?rid=${requestScope.route.rid }"><i class="glyphicon glyphicon-heart-empty"></i>立即购买</a>
                        <span>已收藏${requestScope.route.favorite }次</span>
                    </p>
                </div>        
            </div>
        </div>
        <div class="you_need_konw">
            <span>旅游须知</span>
            <div class="notice">
                <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

                <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

                <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

                <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

                <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
 			</div>           
        </div>
    </div>
    <!-- 详情 end -->

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
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
    <script>
    $(document).ready(function() {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function() {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
           //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click',function(){
            var num = $('.little_img').length;
            if((nextindex + 1) <= num){
                $('.little_img:eq('+picindex+')').hide();
                $('.little_img:eq('+nextindex+')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click',function(){
            var num = $('.little_img').length;
            if(picindex > 0){
                $('.little_img:eq('+(nextindex-1)+')').hide();
                $('.little_img:eq('+(picindex-1)+')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    });

    //自动轮播方法
    function auto_play() {
        var cur_index = $('.prosum_left dd').find('a.cur_img').index();
        cur_index = cur_index - 1;
        var num = $('.little_img').length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(' + next_index + ')').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        } else {
            var big_pic = $('.little_img:eq(0)').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(0)').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        }
    }
    </script>
    <script>
    </script>
</body>

</html>