<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<head>
<meta charset="utf-8">
<title>Twitter Bootstrap shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->

<link href="<c:url value='/templates/user/assets/css/bootstrap.css' />"
	rel="stylesheet" />

<!-- Customize styles -->
<link href="<c:url value ='/templates/user/assets/style.css'/>"
	rel="stylesheet" />
<!-- font awesome styles -->
<link
	href="<c:url value='/templates/user/assets/font-awesome/css/font-awesome.css' />"
	rel="stylesheet">

<!-- Favicons -->
<link rel="shortcut icon" href="/templates/user/assets/ico/favicon.ico">
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="/user/index"> <span class="icon-home"></span>
						Trang chủ
					</a> <a href="/profile"><span class="icon-user"></span> Tài khoản</a> 
						<a href="/cart/list"><span class="icon-shopping-cart"></span> ${cartDetails.size()} <span
							>Giỏ hàng</span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		<header id="header">
			<div class="row">
				<div class="span4">
					<h1>
						<a class="logo" href="index.htm"><span>Twitter
								Bootstrap ecommerce template</span> <img
							src="/templates/user/assets/img/logo-bootstrap-shoping-cart.png"
							alt="bootstrap sexy shop"> </a>
					</h1>
				</div>
				<div class="span4">
					
				</div>
				<div class="span4 alignR">
					<p>
						<br> <strong> Hotline : 0568 107 119 </strong><br>
						<br>
					</p>
					<span class="btn btn-mini">[ 2 ] <span
						class="icon-shopping-cart"></span></span> <span
						class="btn btn-warning btn-mini">$</span> <span
						class="btn btn-mini">&pound;</span> <span class="btn btn-mini">&euro;</span>
				</div>
			</div>
		</header>

		<!--
Navigation Bar Section 
-->
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a data-target=".nav-collapse" data-toggle="collapse"
						class="btn btn-navbar"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li class=""><a href="/user/index">Trang chủ </a></li>
							<li class=""><a href="/user/products">Sản phẩm</a></li>
							<li class=""><a href=""></a></li>
							<li class=""><a href=""></a></li>
							<li class=""><a href=""></a></li>
							<li class=""><a href=""></a></li>
						</ul>

						<ul class="nav pull-right">
							<li>
								<form action="#" class="navbar-search pull-left">
									<input type="text" placeholder="Search"
										class="search-query span2" id="search-input">
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>