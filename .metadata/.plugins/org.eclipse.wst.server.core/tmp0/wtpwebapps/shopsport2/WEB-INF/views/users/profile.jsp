<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
        .profile {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        
        h1 {
            text-align: center;
        }
        
        .info {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }
        
        .info img {
            width: 150px;
            height: 150px;
            margin-right: 20px;
        }
        
        .info p {
            margin: 5px 0;
            font-size: 18px;
        }
        
        .edit-link {
            display: block;
            text-align: center;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/templates/user/assets/css/bootstrap.css'/>"
	rel="stylesheet" />

<!-- Customize styles -->
<link href="<c:url value='/templates/user/assets/style.css'/>"
	rel="stylesheet" />

<!-- font awesome styles -->
<link
	href="<c:url value='/templates/user/assets/font-awesome/css/font-awesome.css'/>"
	rel="stylesheet" />


<!-- Favicons -->
<link rel="shortcut icon" href="templates/user/assets/ico/favicon.ico">

</head>
<body>
	<%@ include file="/common/user/header.jsp"%>

	<div class="row">

		 <div class="profile">
        <h1>Thông tin người dùng</h1>
        <div class="info">
            <img src="/templates/images/${customer.image}" alt="Hình ảnh">
            <div >
                <p>Tên người dùng: ${customer.surname} ${customer.name}</p>
                <p>Email: ${customer.account.email}</p>
                <p>Sdt: ${customer.phone}</p>
                <p>Địa chỉ: ${customer.address}</p>
                <p>Giới tính: ${customer.gender}</p>
            </div>
        </div>
        <a href="/profile/edit" class="edit-link">Chỉnh sửa thông tin</a>
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


</body>
</html>