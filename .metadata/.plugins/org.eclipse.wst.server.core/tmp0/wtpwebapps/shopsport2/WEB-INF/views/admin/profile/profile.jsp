<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp" %>
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
		 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Hồ sơ</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/home">Home</a></li>
              <li class="breadcrumb-item active">Hồ sơ</li>
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
     	 	 		<div class="card card-primary card-outline">
              <div class="card-body box-profile">
                <div class="text-center">
                  <img class="profile-user-img img-fluid img-circle"
                       	src='<c:url value="/templates/admin/dist/img/${u.getStaff().getImage()}"/>'
                       alt="User profile picture">
                </div>

                <h3 class="profile-username text-center">${u.getUsername()}</h3>

              

                <ul class="list-group list-group-unbordered mb-3">
                  <li class="list-group-item" >
                    <b>Họ và Tên</b> <a class="float-right" style="color:#0056b3">${u.getStaff().getSurname()} ${u.getStaff().getName()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Chứng minh nhân dân</b> <a class="float-right" style="color:#0056b3">${u.getStaff().getCmnd()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Giới tính</b> <a class="float-right" style="color:#0056b3">${u.getStaff().getGender()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Ngày sinh</b> <a class="float-right" style="color:#0056b3">${u.getStaff().dateOfBirth}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Địa chỉ</b> <a class="float-right" style="color:#0056b3">${u.getStaff().getAddress()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Email</b> <a class="float-right" style="color:#0056b3">${u.getEmail()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Phone</b> <a class="float-right" style="color:#0056b3">${u.getStaff().getPhone()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Chức vụ</b> <a class="float-right" style="color:#0056b3">
                    
                    	${u.role.getName()}
            
                    </a>
                  </li>
                </ul>

                <a href="/admin/profile/update/${u.getUsername()}" class="btn btn-primary btn-block"><b>Chỉnh sữa thông tin</b></a>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
     	 	 		 </div>
     	 	 </div>
     	 </div>
     </section>
    
	</div>
	
	
</body>
</html>