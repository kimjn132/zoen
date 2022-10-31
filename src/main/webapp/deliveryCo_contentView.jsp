<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import = "java.sql.*"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Checkout example · Bootstrap v5.2</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/checkout/">

    

    

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
        

      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
   <header class="bd-header bg-dark py-3 d-flex align-items-stretch border-bottom border-dark">
  <div class="container-fluid d-flex align-items-center">
    <h1 class="d-flex align-items-center fs-4 text-white mb-0">
      &nbsp;&nbsp;<a href="#" style="text-decoration:none">가나다 마트</a>
      <img class="d-block mx-auto mb-4" src="https://kr.seaicons.com/wp-content/uploads/2015/10/Sport-Mode-icon.png" alt="" width="40" height="30">
    </h1>
  </div>
</header> 
	<img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/128/1289/1289320.png" alt="" width="120" height="100">
     <div class="text-center"> 
     <h2><strong>배송 업체 수정 및 삭제</strong></h2>
     </div>
<div class="container">
	
    <div class="py-5 text-center">
    </div>
       <div class="text-center">
        
        <form action="deliveryCo_modify.do" method="post">
          <div class="row g-3">
            
            <div class="text-center">
				<input type="hidden" name="deliveryCo_id" size="20" value="${deliveryCo_contentView.deliveryCo_id}">
				<div class="invalid-feedback">
              </div>
            </div>
            <div class="text-center">
              <label for="name" class="form-label">배송업체명</label>
				<input type="text" name="deliveryCo_name" size="20" value="${deliveryCo_contentView.deliveryCo_name}">
				<div class="invalid-feedback">
              </div>
            </div>

            <div class="text-center">
              <label for="phone" class="form-label">전화번호</label>
				<input type="text" name="deliveryCo_phone" size="20"value="${deliveryCo_contentView.deliveryCo_phone}">
              <div class="invalid-feedback">
                
              </div>
            </div>

            <div class="text-center">
              <label for="email" class="form-label">Email <span class="text-muted"></span></label>
				<input type="text" name="deliveryCo_email" size="20"value="${deliveryCo_contentView.deliveryCo_email}">
              <div class="invalid-feedback">
              </div>
            </div>

          </div>
			<br>
          <hr class="my-4">
			<div>
         <input type="submit" value="수정" class="btn btn-primary">
		<a href="deliveryCo_delete.do?deliveryCo_id=${deliveryCo_contentView.deliveryCo_id}" type="submit" class="btn btn-primary">삭제</a>
         </div>
        </form>
		<div>
		<br>
        <a href="deliveryCo_list.do">목록보기</a>
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
        <br>        
		</div>
      </div>
    </div>

	<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
  </div>
	</footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

      <script src="form-validation.js"></script>
  </body>
</html>
