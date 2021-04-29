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
    <title>支付</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
    
        <style>
        	.liucheng {
			    width: 800px;
			    margin: 50px auto 0;
			}
			.liucheng div {
			    float: left;
			    text-align: center;
			}
			
			.clearfix::after {
			    height: 0;
			    content: " ";
			    display: block;
			    overflow: hidden;
			    clear: both;
			}
			
			.liucheng div i {
			    display: inline-block;
			    width: 26px;
			    height: 26px;
			    border-radius: 50%;
			    color: #ffffff;
			    background-color: #cccccc;
			    font-size: 16px;
			    line-height: 26px;
			    font-weight: 700;
			    font-family: arial;
			    text-align: center;
			}
			.liucheng u:nth-of-type(1), .liucheng u:nth-last-of-type(1) {
		    	width: 60px;
			}
			.liucheng u {
			    float: left;
			    width: 120px;
			    height: 1px;
			    margin: 13px 0 0 0;
			    background-color: #cccccc;
			}
			::after, ::before {
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
		    box-sizing: border-box;
			}
			::after, ::before {
			    -webkit-box-sizing: border-box;
			    -moz-box-sizing: border-box;
			    box-sizing: border-box;
			}
	.purchase-page-1 {
    width: 800px;
    margin: 60px auto 0;
    padding: 60px 0 0 0;
    border-top: 1px dashed #dddddd;
	}
        	
    	.liucheng div:nth-of-type(4) p {
		color: #333333;
	}
	.liucheng u:nth-of-type(4) {
		background-color: #2ac86e;
	}
	
	.liucheng div:nth-of-type(4) i {
		background-color: #2ac86e;
	}
	</style>
    
</head>

<body>
<jsp:include page="/header.jsp"   />
    <!-- 详情 start -->   
    <div class="wrap">
        <div class="bread_box">
            <a href="/">首页</a>
            <span> &gt;</span>
            <a href="#">国内游</a><span> &gt;</span>
            <a href="#">全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</a>
        </div>
        
       <div class="bread_box">
				<div class="liucheng clearfix">
					<u></u>	<div><i>1</i><p>提交定单</p></div>
					<u></u><div><i>2</i><p>选择支付方式</p></div>
					<u></u><div><i>3</i><p>扫码支付</p></div>
					<u></u><div><i>4</i><p>支付成功</p></div>
					<u></u>
				</div>
		</div>
		
		 <div class="bread_box">
				
		 		
		 	</br></br>
		<div class="purchase-page">
				<div class="purchase-page-text">
					
						<div style="text-align: center" colspan="3">
							
							<div style="margin: 0 0 30px 0;">
								<span>支付成功！&nbsp;&nbsp;<a style="color: #fe9900;"
									href="search.jsp">查看详情</a></span> 
							</div>
						</div>
						</br></br></br>
				</div>
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
    

</body>

</html>