<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<div class="bg-white" style="text-align:center">
	<h1>거래처 리스트</h1>
	<table class="table table-dark table-hover center" border="1" style="width:70%">

		<tr>
			<th>거래처 번호</th><th>거래처명</th><th>전화번호</th><th>이메일</th>
		</tr>
		<c:forEach items="${supplier_list}" var="dto">
			<tr>
				<td><a href="supplier_content_view.do?sId=${dto.sId}">${dto.sId}</a></td>
				<td>${dto.sName}</td>
				<td>${dto.sPhone}</td>
				<td>${dto.sEmail}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="supplier_add_view.do">추가</a></td>
		</tr>
	</table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>