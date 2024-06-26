<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thể loại</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp" %>
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
		 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
          <a href="/admin/management/category/list"><h1>Danh sách thể loại</h1></a>
            
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
              <li class="breadcrumb-item active">Cập nhật thể loại</li>
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
                <h3 class="card-title">Cập nhật thể loại</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="editCategory"  method="POST">
                <div class="card-body">

				<spring:bind path="name">
					<div class="form-group">
                    <label for="exampleInputEmail1">Tên thể loại</label>
                    <form:input type="text"  class="form-control" path="name" id="exampleInputEmail1" placeholder="Enter password"/>
                  </div>
                  <form:errors path="name"></form:errors>
				</spring:bind>
                
                </div>
                <!-- /.card-body -->
 				<c:if test="${not empty message}"><div>${message}</div> </c:if>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Cập nhật</button>
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