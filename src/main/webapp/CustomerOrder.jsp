<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
<meta name="generator" content="Hugo 0.104.2">
<title>ZOEN-주문결제창</title>

<link rel="canonical"
	href="https://getbootstrap.kr/docs/5.2/examples/checkout/">





<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.2/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg"
	color="#712cf9">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
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


<!-- 결제 진행 폼 -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<form action="order.do" method="post">
			<div class="py-5 text-center">
				<h2>결제창</h2>
			</div>

			<div class="row g-5">
				<div class="col-md-5 col-lg-4 order-md-last">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-primary">결제 상품 리스트</span> <span
							class="badge bg-primary rounded-pill">1</span>
					</h4>


					
						<ul class="list-group mb-3">

							<li class="list-group-item d-flex justify-content-between lh-sm">
								<div>
									<h6 class="my-0">${detail.pId}  ${detail.pName}</h6>
									<small class="text-muted">${detail.pDetail}</small>
								</div> <span class="text-muted">${detail.pSaleprice}</span>
							</li>

							<li class="list-group-item d-flex justify-content-between">
								<span>주문합계</span> <strong>${detail.pSaleprice}</strong>
							</li>
						</ul>
				</div>


				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">주문자 정보</h4>

					<div class="col-12">


						<label for="firstName" class="form-label">이름</label> <input
							type="text" class="form-control" id="firstName"
							value="<%=session.getAttribute("CID") %>">
						<div class="invalid-feedback"></div>
					</div>


					<div class="col-12">
						<label for="phone" class="form-label">휴대폰번호</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control" id="phone"
								value="${customer.cPhone}">
							<div class="invalid-feedback"></div>
						</div>
					</div>


					<div class="col-12">
						<label for="address" class="form-label">주소</label> <input
							type="text" class="form-control" id="address"
							value="${customer.cAddress}">
						<div class="invalid-feedback"></div>
					</div>


					<%--<div class="col-12">
						<label for="requested term" class="form-label">배송 요청사항 <span class="text-muted"></span></label> 
						<input type="text" class="form-control" id="requested term" placeholder="요청사항">
					</div>--%>




					<%-- radio: name="oPayment" 이렇게 command 변수와 맞춰야 됨 --%>
					<h4 class="mb-3">결제방법</h4>

					<div class="my-3">
						<div class="form-check">
							<input id="credit" name="oPayment" type="radio"
								class="form-check-input" checked="checked" value="신용카드">
							신용카드
						</div>


						<div class="form-check">
							<input id="debit" name="oPayment" type="radio"
								class="form-check-input" value="체크카드">체크카드
						</div>


						<div class="form-check">
							<input id="deposit without a bankbook" name="oPayment"
								type="radio" class="form-check-input" value="무통장입금">무통장입금
						</div>
					</div>



					<hr class="my-4">
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="agree">
						<label class="agree" for="agree">회원 본인은 구매조건, 주문 내용 확인 및
							결제에 동의합니다.</label>
					</div>
					<br>

					<button class="w-100 btn btn-primary btn-lg" type="submit">결제하기</button>


				</div>
			</div>
			</form>
		</main>


		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
			crossorigin="anonymous"></script>

		<script src="form-validation.js"></script>
</body>
</html>
