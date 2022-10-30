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
<title>발주신청 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>

<body>
<div class="bg-white" style="text-align:center">
	<h2>발주신청 페이지</h2>
	
<nav class="navbar bg-light py-0">
<div class="container-fluid">
<div class="container text-center">
	<div class="row row-cols-auto">
  	<div class="col">
  		<select name="option">
		<option value="pBrand">브랜드</option>
		<option value="pName">상품명</option>
		</select>
  	</div>
    <div class="col">
    	<form class="d-flex" role="search">
    	<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
    	<button class="btn btn-outline-success" type="submit">검색</button>
    	</form>
    </div>
  </div>
</div>
</div>
</nav>

<div style="width:100%; height:450px; overflow:auto">
	<form name="sorder_place" action="sorder_place.do" method="post">
		<table class="table table-dark table-hover center" border="1" style="width:70%">
			<tr>
			<th>상품번호</th><th>브랜드</th><th>상품명</th><th>현 재고</th><th>수량</th><th>선택</th>
		</tr>
		<c:forEach items="${product_list_check}" var="dto">
			<tr>
				<td>${dto.pId}</td>
				<td>${dto.pBrand}</td>
				<td>${dto.pName}</td>
				<td>${dto.pStock}</td>
				<td><input type="text" name="soQuantity"></td>
				<td>
				<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
				<label class="form-check-label" for="flexCheckDefault"></label>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
	</form>
</div>
<br>
<br>
		<input type="submit" value="신청하기">
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>