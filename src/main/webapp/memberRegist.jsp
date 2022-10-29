<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Template Bootstrap v5.2</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">

    
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
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin w-100 m-auto">
  <form action="insertCustomer.do">
    <img class="mb-4" src="https://png.pngtree.com/png-vector/20210426/ourlarge/pngtree-red-shoes-png-image_3229809.jpg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">회원가입</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="ID" name="cId">
      <label for="floatingInput">ID</label> 
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="Password" name="cPw">
      <label for="floatingPassword">Password</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="Confirm password" name="cPw2">
      <label for="floatingPassword">Confirm password</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="Address" name="cAddress">
      <label for="floatingPassword">Address</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="Email" name="cEmail">
      
      <label for="floatingPassword">E-mail</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="Phone" name="cPhone">
      
      <label for="floatingPassword">Phone</label>
    </div>
    <div class="checkbox mb-3">
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">join membership</button>
  </form>
</main>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>


  </body>
</html>
