<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<nav class="navbar bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src= "https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      상세정보
    </a>
  </div>
</nav>
<div class="w-65 p-3" >
<form action="productmodify.do" method="post">
		<input type="hidden" name="pId" value="${productview.pId}">
		<table class="table table table-sm table-hover">
			<tr>
				<th >등록번호</th>
				<th> [${productview.pId}]</th>
			</tr>
			<tr>
				<th>상품명</th>
				<td> <input type="text" name="pName" size="20" value="${productview.pName}"> </td>
			</tr>
			<tr>
				<th>상품 색상</th>
				<td> <input type="text" name="pColor" size="20" value="${productview.pColor}"> </td>
			</tr>
			<tr>
				<th>상품 사이즈</th>
				<td> <input type="text" name="pSize" size="20" value="${productview.pSize}"> </td>
			</tr>
			<tr>
				<th>브랜드</th>
				<td> <input type="text" name="pBrand" size="50" value="${productview.pBrand}"> </td>
			</tr>
			<tr>
				<th>판매가격</th>
				<td> <input type="text" name="pSaleprice" size="50" value="${productview.pSaleprice}"> </td>
			</tr>
			<tr>
				<th>재고</th>
				<td> <textarea name="pStock" rows="1" cols="19">${productview.pStock}</textarea> </td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td> <textarea name="pDetail" rows="10" cols="50">${productview.pDetail}</textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit" class="btn btn-primary">수정</button>
				<a href="productdelete.do?pId=${productview.pId}" type="submit" class="btn btn-primary">삭제</a>
				<a href="productlist.do" type="submit" class="btn btn-primary">뒤로</a>
           	 </td>
			</tr>
		</table>
	
	</form>
	</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>