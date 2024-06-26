<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhà cung cấp</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp" %>
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
		 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
          <a href="/admin/management/supplier/list"><h1>Danh sách nhà cung cấp</h1></a>
            
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
              <li class="breadcrumb-item active">Tạo nhà cung cấp</li>
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
                <h3 class="card-title">Tạo nhà cung cấp</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="addSupplier"  method="POST">
                <div class="card-body">
                
                <spring:bind path="id">
					<div class="">
                    <label for="exampleInputEmail1">Mã nhà cung cấp</label>
                    <form:input type="text" class="form-control" path="id" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color:red" path="id"></form:errors>
				</spring:bind>

				<spring:bind path="name">
					<div class="">
                    <label for="exampleInputEmail1">Tên nhà cung cấp</label>
                    <form:input type="text" class="form-control" path="name" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color:red" path="name"></form:errors>
				</spring:bind>
				
				<spring:bind path="phone">
					<div class="">
                    <label for="exampleInputEmail1">SDT</label>
                    <form:input type="text" class="form-control" path="phone" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color:red" path="phone"></form:errors>
				</spring:bind>
				
				<spring:bind path="address">
					<div class="">
                    <label for="exampleInputEmail1">Địa chỉ</label>
                    <form:input type="text" class="form-control" path="address" id="exampleInputEmail1" placeholder=""/>
                  </div>
                  <form:errors style="color:red" path="address"></form:errors>
				</spring:bind>
                
                </div>
                <!-- /.card-body -->
 				<c:if test="${not empty message1}"><div style="color:red;margin-left:20px">${message1}</div> </c:if>
 				<c:if test="${not empty message2}"><div style="color:green;margin-left:20px">${message2}</div> </c:if>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Tạo</button>
                </div>
              </form:form>
              </div>
            </div>
            <!-- /.card -->
     	 	 </div>
     	 </div>
     </section>
    
	</div>
</body>
</html>