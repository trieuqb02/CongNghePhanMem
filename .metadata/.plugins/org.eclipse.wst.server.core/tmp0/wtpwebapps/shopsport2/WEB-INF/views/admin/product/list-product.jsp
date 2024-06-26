<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href='<c:url value="/templates/admin/plugins/fontawesome-free/css/all.min.css" />'>
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href='<c:url value="/templates/admin/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css" />'>
<!-- Toastr -->
<link rel="stylesheet"
	href='<c:url value="/templates/admin/dist/css/adminlte.min.css" />'>
<!-- Theme style -->
<link rel="stylesheet"
	href='<c:url value="/templates/admin/dist/css/adminlte.min.css" />'>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<a href="/admin/management/prodcut/list"><h1>Danh sách sản phẩm</h1></a>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="/admin/home">Home</a></li>
							<li class="breadcrumb-item active">Danh sách sản phẩm</li>
						</ol>
					</div>

				</div>
			</div>
		</section>


		<section class="content">
			<form action="<c:url value='/admin/management/product/list'/>" id="formSubmit"
				method="get">
				<div class="container-fluid">
					<div class="row" style="justify-content: center;"></div>
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Tìm kiếm theo mã sản phẩm</h3>

								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<input type="text" name="search" id="search"
											value="${paging.search}" class="form-control float-right"
											placeholder="Search">
										<div class="input-group-append">
											<button type="submit" class="btn btn-default">
												<i class="fas fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<table class="table table-bordered">
									<thead>
										<tr >
											<th>Mã </th>
											<th>Hình ảnh</th>
											<th>Tên</th>
											<th>Loại</th>
											<th>Giá</th>
											<th>SỐ lượng</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody >
										<c:forEach var="product" items="${listProduct}">
											<tr>
												<td style="vertical-align: middle;">${product.id}</td>
												<td style="vertical-align: middle;" ><img
													src='<c:url value="/templates/images/${product.image}"/>'
													class=" elevation-2" style="height: 100px;width:100px"
													alt="User Image" /></td>
												<td style="vertical-align: middle;">${product.name}</td>
												<td style="vertical-align: middle;">${product.category.name}</td>
												<td style="vertical-align: middle;">${product.price}</td>
												<td style="vertical-align: middle;">${product.quantity}</td>
												<td style="vertical-align: middle;"><a type="button" class="btn btn btn-primary"
													data-toggle="modal" data-target="#modal-lg"> <i
														class="fas fa-info-circle"></i>
												</a> <a
													href="/admin/management/product/edit?id=${product.id}"
													class="btn btn-info"> <i class="fas fa-edit"></i>
												</a> <a class="btn btn-danger" data-toggle="modal"
													data-target="#modal-default"> <i class="fas fa-trash"></i>
												</a>
													<div class="modal fade" id="modal-default">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h4 class="modal-title">Thông báo</h4>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																
																<c:if test="${product.getDetailsReceipts().size() == 0 }">
																	<div class="modal-body">
																	<p>Bạn có đồng ý xoá sản phẩm không?&hellip;</p>
																</div>
																<div class="modal-footer justify-content-between">
																
																
																	<a
																		href="/admin/management/product/remove?id=${product.id}"
																		type="button" class="btn btn-primary">Đống ý</a>
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Đóng</button>
																</div>
																</c:if>
																
																<c:if test="${product.getDetailsReceipts().size() != 0 }">
																	<div class="modal-body">
																	<p>Bạn có không thể xoá sản phẩm này?&hellip;</p>
																</div>
																<div class="modal-footer justify-content-between">
																
																
																	
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Đóng</button>
																</div>
																</c:if>
																
																
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>


													<div class="modal fade" id="modal-lg">
														<div class="modal-dialog modal-lg">
															<div class="modal-content">
																<div class="modal-header">
																	<h4 class="modal-title">Chi tiết sản phẩm</h4>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">
																	<div class="card card-primary card-outline">
																		<div class="card-body box-profile">
																			<div class="text-center">
																				<img class="img-fluid "
																					src='<c:url value="/templates/images/${product.getImage()}"/>'
																					alt="User profile picture">
																			</div>

																			<ul class="list-group list-group-unbordered mb-3">
																				<li class="list-group-item"><b>Mã sản phẩm</b> <a class="float-right" style="color: #0056b3">${product.getId()}</a></li>
																				<li class="list-group-item"><b>Tên sản phẩm</b> <a
																					class="float-right" style="color: #0056b3">${product.name}
																						</a></li>

																				<li class="list-group-item"><b>Loại</b> <a
																					class="float-right" style="color: #0056b3">${product.category.name}</a>
																				</li>
												
																				<li class="list-group-item"><b>Mô tả</b> 
																				<p style="color: #0056b3">${product.description}</p>
																				</li>

																			</ul>
																		</div>
																		<!-- /.card-body -->
																	</div>
																</div>
																<div class="modal-footer justify-content-between">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Đóng</button>

																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.card-body -->
							<div class="card-footer clearfix">
								<ul id="pagination-demo" class="pagination-lg"></ul>
								<input type="hidden" value="1" id="page" name="page" /> <input
									type="hidden" value="1" id="limit" name="limit" />
							</div>
						</div>
						<!-- /.card -->
					</div>
				</div>
			</form>



		</section>

	</div>
	<script>
		var totalPages = ${paging.totalPage};
		var currentPage = ${paging.page};
		$('#pagination-demo').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#limit').val(1);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
			}
		});
	</script>


	<script
		src="<c:url value='/templates/admin/plugins/jquery/jquery.min.js'/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value='/templates/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- SweetAlert2 -->
	<script
		src="<c:url value='/templates/admin/plugins/sweetalert2/sweetalert2.min.js'/>"></script>
	<!-- Toastr -->
	<script
		src="<c:url value='/templates/admin/plugins/toastr/toastr.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/templates/admin/dist/js/adminlte.min.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/templates/admin/dist/js/demo.js'/>"></script>
	<!-- Page specific script -->
</body>
</html>