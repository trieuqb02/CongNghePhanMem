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
			<li><a href="/user/index">Trang chủ</a> <span class="divider">/</span></li>
			<li class="active">Check Out</li>
		</ul>
		<div class="well well-small">
			<h1>
				Chi tiết đơn hàng: <small class="pull-right"> ${cartDetails.size()} Items are in the
					cart </small>
			</h1>
			<hr class="soften" />

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Sản Phẩm</th>
						
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tổng giá</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderdetail" items="${detailsOders}">
						<tr>
							<td><img width="100"
								src='<c:url value="/templates/images/${orderdetail.product.image}"/>'
								alt=""></td>
							
		
							<td>${orderdetail.product.price}</td>
							<td>${orderdetail.quantity}</td>
							<td>${orderdetail.product.price * orderdetail.quantity}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			<br />


			
			
			<a href="/cart/orderlist" class="shopBtn btn-large"><span
				class="icon-arrow-left"></span> Trở về </a> 
				

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