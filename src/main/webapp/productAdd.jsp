<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<nav class="navbar bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src= "https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      제품 등록
    </a>
  </div>
</nav>

<form action="productadd.do" method="post">

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1" > 상품명 </span>
  <input type="text" class="form-control" placeholder="enter product name here..." aria-label="name input" aria-describedby="basic-addon1" name="pName">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">판매가격</span>
  <input type="text" class="form-control" placeholder="enter product price here..." aria-label="price input" aria-describedby="basic-addon1" name="pSaleprice">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1"> 색상 </span>
  <input type="text" class="form-control" placeholder="enter product color here..." aria-label="color input" aria-describedby="basic-addon1" name="pColor">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1"> 수량 </span>
  <input type="text" class="form-control" placeholder="enter product stock here..." aria-label="color input" aria-describedby="basic-addon1" name="pStock">
</div>

<select class="form-select" aria-label="Default select example" name="pSize">
  <option selected>Choose Size</option>
<c:forEach var="i" begin="230" end="300" varStatus="step" >
<option value="${i}">${i}</option>
</c:forEach>
</select>

<select class="form-select" aria-label="Default select example" name="pCategory">
  <option selected>Choose Category</option>
  <option value="운동화">운동화</option>
  <option value="단화">단화</option>
</select>

<select class="form-select" aria-label="Default select example" name="pBrand">
  <option selected>Choose Brand</option>
  <option value="Nike">나이키</option>
  <option value="Adidas">아디다스</option>
  <option value="Converse">컨버스</option>
  <option value="Vans">반스</option>
  <option value="Fila">휠라</option>
</select>


<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">상품 상세설명</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="pDetail" placeholder="enter product information..." ></textarea>
</div>

 <button type="submit" class="btn btn-primary">확인</button>
 <a href="productlist.do" type="submit" class="btn btn-primary">뒤로</a>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>