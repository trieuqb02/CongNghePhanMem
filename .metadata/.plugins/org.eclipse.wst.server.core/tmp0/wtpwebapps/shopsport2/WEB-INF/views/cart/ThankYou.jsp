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
			<div class="col l-12">
		<div class="vh-100 d-flex justify-content-center align-items-center">
            <div>
                <div class="mb-4 text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" class="text-success" width="75" height="75"
                        fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                        <path
                            d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                    </svg>
                </div>
                <div class="text-center">
                    <h1>Cảm ơn quý khách đã mua sản phẩm của Shop!</h1>
                    <p>Đơn đặt hàng của bạn đang được xử lí!</p>
                    <button class="btn btn-primary" onclick="redirectPage(`<c:url value='/user/index'/>`)">Trở về trang chủ</button>
                </div>
            </div>
	</div>
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