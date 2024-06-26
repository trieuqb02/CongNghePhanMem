<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Hồ sơ</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="/admin/profile">Hồ
									sơ</a></li>
							<li class="breadcrumb-item active">Chỉnh sửa</li>
						</ol>
					</div>
				</div>
			</div>
		</section>
		<!-- end Content Header (Page header) -->

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row" style="justify-content: center;">
					<div class="col-md-8">
						<!-- general form elements -->
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Cập nhật thông tin</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<form:form modelAttribute="u" method="POST"
								enctype="multipart/form-data">
								<div class="card-body">

									<div class="form-group">
										<label for="exampleInputFile">File ảnh</label>
										<div class="input-group">
											<div class="custom-file">
												<input type="file" name="avatar" id="exampleInputFile">
											</div>
										</div>
									</div>
									<c:if test="${error != ''}">
										<span>${error}</span>
									</c:if>

									<spring:bind path="email">
										<div class="form-group">
											<label for="exampleInputEmail1">Email</label>
											<form:input type="email" class="form-control" path="email"
												id="exampleInputEmail1" placeholder="Enter email" />
										</div>
										<form:errors path="email"></form:errors>
										<c:if test="${errorEmail != ''}">
										<span>${errorEmail}</span>
									</c:if>
									</spring:bind>

									<spring:bind path="staff.phone">
										<div class="form-group">
											<label for="exampleInputPassword1">Phone</label>
											<form:input type="text" class="form-control" path="staff.phone"
												id="exampleInputPassword1" placeholder="Password" />
										</div>
										<form:errors path="staff.phone"></form:errors>
									</spring:bind>
									
									<spring:bind path="staff.address">
										<div class="form-group">
											<label for="exampleInputPassword1">Địa chỉ</label>
											<form:input type="text" class="form-control" path="staff.address"
												id="exampleInputPassword1" placeholder="Password" />
										</div>
										<form:errors path="staff.address"></form:errors>
									</spring:bind>
									
									<spring:bind path="staff.cmnd">
										<div class="form-group">
											<label for="exampleInputPassword1">CMND</label>
											<form:input type="text" class="form-control" path="staff.cmnd"
												id="exampleInputPassword1" placeholder="Password" />
										</div>
										<form:errors path="staff.cmnd"></form:errors>
										<c:if test="${errorCmnd != ''}">
										<span>${errorCmnd}</span>
									</c:if>
									</spring:bind>

								
								
								</div>
								<c:if test="${not empty message}"><div>${message}</div> </c:if>
								<!-- /.card-body -->
								<div class="card-footer">
								
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</form:form>
						</div>
						<!-- /.card -->
					</div>
				</div>
			</div>
		</section>

	</div>


</body>
</html>