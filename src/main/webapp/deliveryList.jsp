<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery List</title>
</head>
<body>
	<h1>Delivery List</h1>
	<table border="1">
		<tr>
		<th><%=session.getAttribute("cId") %></th>
		</tr>
		<tr>
			<th>배송ID</th><th>배송회사ID</th><th>제품ID</th><th>고객ID</th><th>주문ID</th><th>주문시작날짜</th><th>주문종료날짜</th>
		</tr>
		<c:forEach items="${delivery_list}" var="dto">
			<tr>
				<td><a href=content_viewDeliveryId.do?delivery_id=${dto.delivery_id}>${dto.delivery_id}</a></td>
				<td>${dto.deliveryCo_id}</td>
				<td>${dto.pId}</td>
				<td>${dto.cId}</td>
				<td>${dto.oId}</td>
				<td>${dto.delivery_initdate}</td>
				<td>${dto.delivery_enddate}</td>
				<td><a href=deleteDelivery.do?delivery_id=${dto.delivery_id}>삭제</a></td> 
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeDelivery.jsp">글작성</a></td>
		</tr>
	</table>
</body>
</html>