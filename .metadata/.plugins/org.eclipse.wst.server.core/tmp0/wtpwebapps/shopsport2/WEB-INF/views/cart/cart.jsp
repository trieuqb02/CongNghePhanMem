<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/templates/user/assets/css/bootstrap.css'/>"
	rel="stylesheet" />


<link href="<c:url value='/templates/user/assets/style.css'/>"
	rel="stylesheet" />


<link
	href="<c:url value='/templates/user/assets/font-awesome/css/font-awesome.css'/>"
	rel="stylesheet" />



<link rel="shortcut icon" href="templates/user/assets/ico/favicon.ico">

</head>
<body>
	<%@ include file="/common/user/header.jsp"%>

	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="/user/index">Home</a> <span class="divider">/</span></li>
			<li class="active">Check Out</li>
		</ul>
		<div class="well well-small">
			<h1>
				Giỏ hàng của bạn: <small class="pull-right"> ${cartDetails.size()} Items are in the
					cart </small>
			</h1>
			<hr class="soften" />

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Sản Phẩm</th>
						<th>Thông tin</th>
						
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tổng giá</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="itemcart" items="${cartDetails}">
						<tr>
							<td><img width="100"
								src='<c:url value="/templates/images/${itemcart.product.image}"/>'
								alt=""></td>
							<td>${itemcart.product.name}<br>${itemcart.product.description}
							</td>
							<td>${itemcart.product.price}</td>
							<td><input class="span1" style="max-width: 34px"
								placeholder="1" id="appendedInputButtons" size="16" type="text"
								value="${itemcart.quantity}">

								<div class="input-append">
									<button class="btn btn-mini" type="button" onclick="redirectPage(`<c:url value='/cart/product/${itemcart.product.id}/except'/>`)">-</button>
									<button class="btn btn-mini" type="button" onclick="redirectPage(`<c:url value='/cart/product/${itemcart.product.id}/add'/>`)">+</button>
									<form action="/cart/remove" method="post">
										<input type="hidden" name="cartDetailId"
											value="${itemcart.cart.id}"> <input type="hidden"
											name="productId" value="${itemcart.product.id}">
										<button type="submit" class="btn btn-mini btn-danger">
											<span class="icon-remove"></span>
										</button>
									</form>

								</div></td>
							<td>${itemcart.product.price * itemcart.quantity}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			<br />


			
			
			<a href="products.htm" class="shopBtn btn-large"><span
				class="icon-arrow-left"></span> Trở về </a> <a
				href="<c:url value='/cart/confirm'/>" class="shopBtn btn-large pull-right">Xác nhận <span
				class="icon-arrow-right"></span></a>

		</div>
	</div>


	<%@ include file="/common/user/footer.jsp"%>

	<script src="<c:url value='/templates/user/assets/js/jquery.js'/>"></script>
	<script
		src="<c:url value='/templates/user/assets/js/bootstrap.min.js'/>"></script>
	<script
		src="<c:url value='/templates/user/assets/js/jquery.easing-1.3.min.js'/>"></script>
	<script
		src="<c:url value='/templates/user/assets/js/jquery.scrollTo-1.4.3.1-min.js'/>"></script>
	<script src="<c:url value='/templates/user/assets/js/shop.js'/>"></script>

	<script type="text/javascript">
		function redirectPage(link) {
	    	window.location.href = link;
		}
	</script>
</body>
</html>