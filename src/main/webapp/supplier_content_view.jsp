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
<title>공급업체 수정 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<script type="text/javascript">
function deleteConfirm(){
	var form = document.modify
	
	if (confirm("정말 삭제하시겠습니까?")){
		form.submit(location.href="supplier_delete.do?sId=${supplier_content_view.sId}");
	}
}
</script>

<body>
<div class="bg-white" style="text-align:center">
<h3>공급업체 수정 페이지</h3>
	<form name="modify" action="supplier_modify.do" method="post">
		<input type="hidden" name="sId" value="${supplier_content_view.sId}">
		<table class="table table-dark table-hover center" border="1" style="width:70%">
			<tr>
				<td>공급업체명</td>
				<td><input type="text" name="sName" size="20" value="${supplier_content_view.sName}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="sPhone" size="20" value="${supplier_content_view.sPhone}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="sEmail" size="20" value="${supplier_content_view.sEmail}"></td>
			</tr>
		</table>
			
		<table class="table table-dark table-hover center" border="1" style="width:70%">
			<tr>
				<td colspan="3">
				<button type="submit" class="btn btn-primary">수정</button>
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-danger" onclick="deleteConfirm()">삭제</button>
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<a href="supplier_list.do">목록보기</a>
				</td>
			</tr>
		</table>
	
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>