<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
	
}

.form-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 20 20 10px rgba(0, 0, 0, 0.1);
        }

h1 {
	text-align: center;
}

form {
	max-width: 600px;
	margin: 0 auto;
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], input[type="email"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #45a049;
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

		 <div class="form-container">
			<h1>Chỉnh sửa thông tin</h1>
			<form:form method="post" action="/profile/edit?ids=${customer.id}" modelAttribute="customer" enctype="multipart/form-data">
				
				<div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Hình ảnh</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="avatar" type="file" class="form-control"  >
                        
                      </div>
                    </div>
				
				<div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Họ</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="surname" type="text" class="form-control" ></form:input>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="about" class="col-md-4 col-lg-3 col-form-label">Tên</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="name" type="text" class="form-control" ></form:input>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Job" class="col-md-4 col-lg-3 col-form-label">Địa chỉ</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="address" type="text" class="form-control" ></form:input>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">Giới Tính</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="gender" type="text" class="form-control" ></form:input>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Sđt</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="phone" type="text" class="form-control" ></form:input>
                      </div>
                    </div>

    
				<br> <input type="submit" value="Cập nhật">
			</form:form>
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