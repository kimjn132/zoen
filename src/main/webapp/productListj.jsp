<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 상품</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<nav class="navbar bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src= "https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      상품 리스트
    </a>
	<a href="productAdd.jsp" class="btn btn-primary"
        style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
  상품 추가</a>
  </div>
</nav>
제품 등록 번호를 클릭하여 제품 정보 페이지로 이동하세요.
<br>

  
<table class="table table-hover" style="padding: 0; spa" >
  <thead>
    <tr>
      <th scope="col" width="10" >#</th>
      <th scope="col" width="200" >상품명</th>
      <th scope="col" width="100" >브랜드</th>
      <th scope="col"  >카테고리</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${productlist}" var="dto">
    <tr>
      <td><a href="productview.do?pId=${dto.pId}">${dto.pId}</a></td>
      <td>${dto.pName}</td>
      <td>${dto.pBrand}</td>
      <td>@${dto.pCategory}</td>
    </tr>
    </c:forEach>
   </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>