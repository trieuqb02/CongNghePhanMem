<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách phiếu nhập</title>
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
						<a href="/admin/management/prodcut/list"><h1>Danh sách
								phiếu nhập</h1></a>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="/admin/home">Home</a></li>
							<li class="breadcrumb-item active">Danh sách phiếu nhập</li>
						</ol>
					</div>

				</div>
			</div>
		</section>


		<section class="content">
			<form action="<c:url value='/admin/management/receipt/list'/>"
				id="formSubmit" method="get">
				<div class="container-fluid">
					<div class="row" style="justify-content: center;"></div>
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Tìm kiếm theo mã phiếu nhập</h3>

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
										<tr>
											<th>Mã</th>
											<th>Nhà cung cấp</th>
											<th>Ngày nhập</th>
											<th>Tổng tiền</th>
											<th>Mã nhân viên nhập</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="receipt" items="${listReceipt}">
											<tr>
												<td style="vertical-align: middle;">${receipt.id}</td>
												<td style="vertical-align: middle;">${receipt.supplier.name}</td>
												<td style="vertical-align: middle;">${receipt.date}</td>
												<td style="vertical-align: middle;">${receipt.sumMoney}</td>
												<td style="vertical-align: middle;">${receipt.staff.id}</td>
												<td style="vertical-align: middle;"><a type="button"
													class="btn btn btn-primary" data-toggle="modal"
													data-target="#modal-xl${receipt.id}"> <i class="fas fa-info-circle"></i>
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
																<div class="modal-body">
																	<p>Bạn có đồng ý xoá không?&hellip;</p>
																</div>
																<div class="modal-footer justify-content-between">
																	<a
																		href="/admin/management/receipt/remove?id=${receipt.id}"
																		type="button" class="btn btn-primary">Đống ý</a>
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Đóng</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>


													<div class="modal fade" id="modal-xl${receipt.id}">
														<div class="modal-dialog modal-xl">
															<div class="modal-content">
																<div class="modal-header">
																	<h4 class="modal-title">Thông tin chi tiết phiếu
																		nhập phiếu nhập</h4>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">
																		<table id="bangsanpham"
													class="table table-hover table-bordered table-striped text-center">
													<thead class="bg-primary">
														<tr>
															<th>Tên sản phẩm</th>
															<th>Số lượng</th>
															<th>Đơn giá</th>
															
														</tr>
													</thead>
													<tbody>
														<c:forEach var="dr" items="${receipt.detailsReceipts }">
															<tr>
																<td>${dr.product.name }</td>
																<td>${dr.quantity }</td>
																<td>${dr.priceImport }</td>

															</tr>
														</c:forEach>


													</tbody>

												</table>



																</div>
																<div class="modal-footer justify-content-between">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Đóng</button>

																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
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