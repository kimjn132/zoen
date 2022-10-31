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
<title>공급업체 선택</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">업체 선택</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
      
        <li class="nav-item">
          <a class="nav-link" href="sorder_main.do">발주현황</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="available_supplier.do">발주신청</a>
        </li>

            
        <li class="nav-item">
          <a class="nav-link" href="supplier_list.do">업체관리</a>
        </li>
        
     	 </ul>
        </div>
  </div>
</nav>
<div class="bg-white" style="text-align:center">
<h2>공급업체 선택</h2>
	<table class="table table-dark table-hover center" border="1" style="width:70%">

		<tr>
			<th>거래처 번호</th><th>거래처명</th><th>전화번호</th><th>이메일</th>
		</tr>
		<c:forEach items="${availableS}" var="ava">
			<tr>
				<td>${ava.sId}</td>
				<td><a href="sorder_place_view.do?sName=${ava.sName}">${ava.sName}</a></td>
				<td>${ava.sPhone}</td>
				<td>${ava.sEmail}</td>
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