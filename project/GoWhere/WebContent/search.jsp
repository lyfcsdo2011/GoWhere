<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单查询</title>
</head>
<body>
<table border="1">
	<tr>
		<td>订单号</td>
		<td>产包名</td>
		<td>支付用户id</td>
		<td>旅游线路id</td>
		<td>数量</td>
		<td>金额</td>
		<td>创建时间</td>
		<td>支付状态</td>
	</tr>
	<tr>
		<td>${sessionScope.order.orderNumber}</td>
		<td>${sessionScope.buyRoute.rname}</td>
		<td>${sessionScope.order.uid}</td>
		<td>${sessionScope.order.rid}</td>
		<td>1</td>
		<td>${sessionScope.order.price}</td>
		<td>${sessionScope.order.createDate}</td>
		<td>
			<c:choose>
				<c:when test = "${sessionScope.order.status ==10}">
					已下单
				</c:when>
				<c:when test = "${sessionScope.order.status ==20}">
					支付中
				</c:when>
				<c:when test = "${sessionScope.order.status ==30}">
					支付成功
				</c:when>
				<c:when test = "${sessionScope.order.status ==100}">
					支付失败
				</c:when>
				<c:when test = "${sessionScope.order.status ==200}">
					已取消
				</c:when>
			</c:choose>
		</td>
		</tr>
</table>
</body>
</html>