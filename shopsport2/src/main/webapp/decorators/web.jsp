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

<!-- Customize styles -->
<link href="<c:url value='/templates/user/assets/style.css'/>"
	rel="stylesheet" />

<!-- font awesome styles -->
<link href="<c:url value='/templates/user/assets/font-awesome/css/font-awesome.css'/>"
	rel="stylesheet" />


<!-- Favicons -->
<link rel="shortcut icon" href="templates/user/assets/ico/favicon.ico">

</head>
<body>
	<%@ include file="/common/user/header.jsp" %>
	
	<div class="row">
		<%@ include file="/common/user/sidebar.jsp" %>
		<dec:body></dec:body>
	</div>
	
	<%@ include file="/common/user/footer.jsp" %>
	
<script src="<c:url value='/templates/user/assets/js/jquery.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.easing-1.3.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.scrollTo-1.4.3.1-min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/shop.js'/>"></script>


</body>
</html>