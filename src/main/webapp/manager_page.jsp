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
    <title>Dashboard Template · Bootstrap v5.2</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">

    

    

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
    <link href="dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <h1 class="d-flex align-items-center fs-4 text-white mb-0">
      &nbsp;&nbsp;가나다 마트
	<img class="d-block mx-auto mb-4" src="https://kr.seaicons.com/wp-content/uploads/2015/10/Sport-Mode-icon.png" alt="" width="40" height="30">
    </h1>
  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
      <a class="nav-link px-3" href="#">Sign out</a>
    </div>
  </div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="productList.do">  <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="home" class="align-text-bottom"></span>
              상품등록/수정/삭제
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">                           <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="file" class="align-text-bottom"></span>
              주문확인
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">                     <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="shopping-cart" class="align-text-bottom"></span>
              배송확인
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">                  <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="users" class="align-text-bottom"></span>
              공급업체 등록/확인/수정/삭제
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="deliveryCo_list.do">                 <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="bar-chart-2" class="align-text-bottom"></span>
              배송업체 등록/확인/수정/삭제
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="">                <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="layers" class="align-text-bottom"></span>
              재고확인
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">                <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="layers" class="align-text-bottom"></span>
              발주
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">               <!-- 하이퍼링크크크크크크크크크크크크크크크크크크 -->
              <span data-feather="layers" class="align-text-bottom"></span>
              매출

            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
          <!-- span>Saved reports</span> -->
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle" class="align-text-bottom"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
             <!--  Current month -->
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
             <!--  Last quarter -->
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom"></span>
              <!-- Social engagement -->
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text" class="align-text-bottom" ></span>
             <!--  Year-end sale -->
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">관리자 페이지</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
          </div>

        </div>
      </div>

      <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

      <h2>상세 매출 현황</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>주문날짜</th>
              <th>주문수</th>
              <th>주문합계</th>
              <th>판매수량</th>
              <th>순이익</th>
              <!-- <th scope="col">순이익</th> -->
            </tr>
          </thead>
          <tbody>
         	<c:forEach items="${deliveryCo_list}" var="dto">
 		 <tr>
 		 
 			<td>${dto.deliveryCo_id}</td>
 			<td>${dto.deliveryCo_id}</td>
 			<td>${dto.deliveryCo_id}</td>
 			<td>${dto.deliveryCo_id}</td>
 		</tr>
 		</c:forEach>
 		<tr>
 		</tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
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
	
	<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
  </div>
	</footer>

    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
  </body>
</html>
