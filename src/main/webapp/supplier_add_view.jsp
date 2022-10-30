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
<title>공급업체 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<script type="text/javascript">
	function checkInfo(){
		
			var regExpName = /^[가-힣|a-z|A-Z]*$/
			var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
			var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
			
			var form = document.registerForm
			
			var name = form.sName.value
			var phone = form.sPhone.value
			var email = form.sEmail.value
			
			if(!regExpName.test(name)){
				alert("업체명은 문자로만 입력해주세요")
				form.sName.select()
				return
			}
			
			
			if(!regExpPhone.test(phone)){
				alert("연락처 입력을 확인해주세요")
				form.sPhone.select()
				return
			}
			
			if(!regExpEmail.test(email)){
				alert("이메일 입력을 확인해주세요")
				form.sEmail.select()
				return
			}

			form.submit()
		}
</script>
<body>
<div class="bg-white" style="text-align:center">
	<h2>공급업체 등록 페이지</h2>
	<form name="registerForm" action="supplier_add.do" method="post">
		<table class="table table-dark table-hover center" border="1" style="width:70%">
			<tr>
				<td>공급업체명</td>
				<td><input type="text" name="sName" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="sPhone" size="20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="sEmail" size="20"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" class="btn btn-primary" onclick="checkInfo()">입력</button>
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<a href="supplier_list.do">목록보기</a>
			
		</table>
	
	</form>
</div>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>