<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thống kê hàng tồn kho</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp"%>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Thống kê số lượng nhập</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Biểu đồ</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="card card-primary col-12">
						<form action="/admin/management/statistical/receipt" method="post">
							<div class="card-body">
								<div class="toDate">
									<label for="fromDate">Từ ngày</label> <input type="date"
										class="form-control" name="fromDate" id="fromDate">
								</div>
								<span style="color:red">
								${message1}
									
								</span>
								
								<div class="toDate">
									<label for="exampleInputPassword1">Đến ngày</label> <input
										type="date" class="form-control" name="toDate" id="toDate">

								</div>
								<span style="color:red">
								${message2}
									
								</span>
							</div>
							<div class="card-footer">
								<button type="submit" class="btn btn-primary">Báo cáo</button>
							</div>
						</form>
					</div>

				</div>
				<div class=row style="justify-content: center;">
					<c:if test="${check }">
						<div class="col-8">
						 <canvas id="myChart"></canvas>
					</div>
					</c:if>
					<c:if test="${check }">
						<div class="col-12">
						 <div class="card">
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
												</a> 
													
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
															<th>Đơn giá </th>
															
														</tr>
													</thead>
													<tbody>
														<c:forEach var="dr" items="${receipt.getDetailsReceipts()}">
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
						 </div>
					</div>
					</c:if>
				</div>
			</div>
		</section>

	</div>
	<!-- /.content-wrapper -->
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script>
	const ctx = document.getElementById('myChart');
	 new Chart(ctx, {
		    type: 'bar',
		    data: {
		      labels: [<c:forEach var="item" items="${labels}">'${item}',</c:forEach>],
		      datasets: [{
		        label: 'số lượng sản phẩm nhập vào',
		        data: [
		        	<c:forEach var="item" items="${counts}">${item},</c:forEach>
		        ],
		        borderWidth: 1
		      },
		      {
			        label: 'Số tiền thanh toán',
			        data: [
			        	<c:forEach var="item" items="${revenus}">${item},</c:forEach>
			        ],
			        borderWidth: 1
			      }]
		    },
		    options: {
		      scales: {
		        y: {
		          beginAtZero: true
		        }
		      }
		    }
		  });
	</script>
</body>
</html>