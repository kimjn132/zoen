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
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">발주 페이지</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">발주현황</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="sorder_place_view.do">발주신청</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="supplier_list.do">업체관리</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<div class="bg-white" style="text-align:center">
	<h1>진행중인 발주 현황</h1>
	<table class="table table-dark table-hover center" border="1" style="width:70%">

		<tr>
			<th>발주번호</th><th>브랜드</th><th>상품명</th><th>사이즈</th><th>수량</th><th>발주일</th>
		</tr>
		<c:forEach items="${sorder_list}" var="dto">
			<tr>
				<td>${dto.soId}</td>
				<td>${dto.pBrand}</td>
				<td>${dto.pName}</td>
				<td>${dto.pSize}</td>
				<td>${dto.soQuantity}</td>
				<td>${dto.soSenddate}</td>
			</tr>
		</c:forEach>
	</table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>