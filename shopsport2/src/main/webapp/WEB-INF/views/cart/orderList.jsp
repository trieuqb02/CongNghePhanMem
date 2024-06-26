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

<style>
.button-link {
    display: inline-block;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.button-delete {
    display: inline-block;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    background-color: red;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.button-link:hover {
    background-color: #45a049;
}

.button-link:active {
    background-color: #3e8e41;
}
</style>

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
				Đơn hàng của bạn: <small class="pull-right">
					${cartDetails.size()} Items are in the cart </small>
			</h1>
			<hr class="soften" />

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Đơn hàng</th>
						<th>Ngày đặt</th>
						<th>Trạng thái</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${listOrder}">
						<tr>

							<td>${order.id}</td>
							<td>${order.date}</td>
							<td>${order.status}</td>
							<td>
								<a class="button-link" href="/order/details?ido=${order.id}">Xem chi tiết đơn hàng</a>
           						<c:if test="${order.status == 'Đã duyệt'}">
           							<a class="button-link" href="/order/detailconfirm?ido=${order.id}" >Xác nhận đã nhận được hàng</a>
           						</c:if>
           						<c:if test="${order.status == 'Chờ xác nhận'}">
           							<a class="button-delete" href="/order/delete?ido=${order.id}" >Xóa</a>
           						</c:if>
							</td>

						</tr>
					</c:forEach>

				</tbody>
			</table>
			<br /> <a href="/cart/list" class="shopBtn btn-large"><span
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