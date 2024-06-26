<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo tài khoản nhân viên</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp" %>
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
		 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Tạo tài khoản</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
              <li class="breadcrumb-item active">Tạo tài khoản</li>
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
                <h3 class="card-title">Tạo tài khoản nhân viên</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="staffForm"  method="POST">
                <div class="card-body">
                
                <spring:bind path="username">
					<div class="form-group">
                    <label for="exampleInputEmail1">Tên tài khoản</label>
                    <form:input type="text" class="form-control" path="username" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red; margin-left: 10px" path="username"></form:errors>
				</spring:bind>

				<spring:bind path="password">
					<div class="form-group">
                    <label for="exampleInputEmail1">Mật khẩu</label>
                    <form:input type="password" class="form-control" path="password" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red; margin-left: 10px" path="password"></form:errors>
				</spring:bind>

				<div class="form-group">
				  <label for="exampleInputEmail1">Xác nhận mật khẩu</label>
						<input class="form-control" type="password"
							name="passwordConfirm" placeholder="" />
						<p class="error" style="color: red; margin-left: 10px">
							<c:if test="${checkPassword}">
								${error}
							</c:if>
						</p>
					</div>
				
				<spring:bind path="staff.id">
					<div class="form-group">
                    <label for="exampleInputEmail1">Mã nhân viên</label>
                    <form:input type="text" class="form-control" path="staff.id" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.id"></form:errors>
				</spring:bind>
				
				<spring:bind path="staff.surname">
					<div class="form-group">
                    <label for="exampleInputEmail1">Họ</label>
                    <form:input type="text" class="form-control" path="staff.surname" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.surname"></form:errors>
				</spring:bind>
				
				<spring:bind path="staff.name">
					<div class="form-group">
                    <label for="exampleInputEmail1">Tên</label>
                    <form:input type="text" class="form-control" path="staff.name" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.name"></form:errors>
				</spring:bind>
				
				<spring:bind path="staff.dateOfBirth">
					<div class="form-group">
                    <label for="exampleInputEmail1">Ngày sinh</label>
                    <form:input type="date" class="form-control" path="staff.dateOfBirth" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.dateOfBirth"></form:errors>
				</spring:bind>
				
				<spring:bind path="staff.cmnd">
					<div class="form-group">
                    <label for="exampleInputEmail1">CMND</label>
                    <form:input type="text" class="form-control" path="staff.cmnd" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.cmnd"></form:errors>
				</spring:bind>
				
				<spring:bind path="staff.gender">
				<div class="form-group">
				<label for="exampleInputEmail1">Giới tính: </label>
					<form:radiobutton path="staff.gender" value="Male"/>Nam
					<form:radiobutton path="staff.gender" value="Female"/>Nữ
                  <form:errors  style="display:block;color: red" path="staff.gender"></form:errors>
                  </div>
				</spring:bind>
				
				
				<spring:bind path="staff.address">
					<div class="form-group">
                    <label for="exampleInputEmail1">Địa chỉ</label>
                    <form:input type="text" class="form-control" path="staff.address" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red" path="staff.address"></form:errors>
				</spring:bind>

				<spring:bind path="staff.phone">
					<div class="form-group">
                    <label for="exampleInputEmail1">Số diện thoại</label>
                    <form:input type="text" class="form-control" path="staff.phone" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red"  path="staff.phone"></form:errors>
				</spring:bind>

				<spring:bind path="email">
					<div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <form:input type="email" class="form-control" path="email" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color: red"  path="email"></form:errors>
				</spring:bind>
				
                	<spring:bind path="role">
                	<div class="form-group">
                	<label for="exampleInputEmail1">Chức vụ</label>
                	
               				<form:select class="custom-select" path="role" items="${roles}" itemLabel="name" itemValue="name"></form:select>
                
                 </div>
                 <form:errors style="color: red" path="role"></form:errors>
                 </spring:bind>
                
                </div>
                <!-- /.card-body -->
 				<c:if test="${not empty message1}"><div style="color: red;margin-left:20px">${message1}</div> </c:if>
 				<c:if test="${not empty message2}"><div style="color: green;margin-left:20px">${message2}</div> </c:if>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Đăng kí</button>
                </div>
              </form:form>
              
             
             
            </div>
            <!-- /.card -->
     	 	 </div>
     	 </div>
     </section>
    
	</div>
	
	
</body>
</html>