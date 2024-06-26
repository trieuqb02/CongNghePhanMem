<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="shopsport.nhom18.utils.SecurityUtils" %>

<nav class="main-header navbar navbar-expand navbar-dark">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
		
	</ul>

	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<!-- Navbar Search -->
		<li class="nav-item"><a class="nav-link"
			data-widget="navbar-search" href="#" role="button"> <i
				class="fas fa-search"></i>
		</a>
			<div class="navbar-search-block">
				<form class="form-inline">
					<div class="input-group input-group-sm">
						<input class="form-control form-control-navbar" type="search"
							placeholder="Search" aria-label="Search">
						<div class="input-group-append">
							<button class="btn btn-navbar" type="submit">
								<i class="fas fa-search"></i>
							</button>
							<button class="btn btn-navbar" type="button"
								data-widget="navbar-search">
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div>
				</form>
			</div></li>



		

		
			<li class="nav-item dropdown show"><a class="nav-link "
				style="display: flex; justify-content: center; align-items: center;"
				data-toggle="dropdown" href="#">
				<security:authorize access = "isAuthenticated()">
					<div class="image" style="height: inherit">
						<img
							src='<c:url value="/templates/admin/dist/img/${u.getStaff().getImage()}"/>'
							class="img-circle elevation-2" style="height: inherit"
							alt="User Image"> <span> <%=SecurityUtils.getPrincipal().getFullName()%>
						</span>
					</div>
				</security:authorize>
			</a>
				<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right"
					style="max-width: 140px; min-width: 140px;">

					<div class="dropdown-divider"></div>
					<a href="/admin/profile" class="dropdown-item"> <i
						class="fas fa-envelope mr-2"></i> Hồ sơ
					</a>
					<div class="dropdown-divider"></div>
					<a href="/logout" class="dropdown-item"> <i
						class="fas fa-users mr-2"></i> Đăng xuất
					</a>


				</div></li>

		


	</ul>
</nav>
