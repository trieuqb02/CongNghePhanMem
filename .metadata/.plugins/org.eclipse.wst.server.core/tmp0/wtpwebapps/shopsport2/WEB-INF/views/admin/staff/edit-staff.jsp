<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sữa nhân viên</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp" %>
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
		 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Cập nhật thông tin</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/list-staff">Danh sách nhân viên</a></li>
              <li class="breadcrumb-item active">Cập nhật</li>
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
                <h3 class="card-title">Cập nhật chức vụ nhân viên</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="updateStaff"  method="POST">
                <div class="card-body">
                
				
				
                	<spring:bind path="role">
                	<div class="form-group">
                	<label for="exampleInputEmail1">Chức vụ</label>
                			
                			
               				<form:select class="custom-select" path="role" items="${roles}" itemLabel="name" itemValue="name"></form:select>
                
                 </div>
                 <form:errors path="role"></form:errors>
                 </spring:bind>
                
                </div>
                <!-- /.card-body -->
 				<c:if test="${not empty message}"><div>${message}</div> </c:if>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Cập nhật</button>
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