<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Số lượng sản phẩn</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<a href="/admin/management/product/list"></a>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="/admin/home">Home</a></li>
							<li class="breadcrumb-item active">Số lượng chi tiết sản phẩm</li>
						</ol>
					</div>

				</div>
			</div>
		</section>


		<section class="content">

			<div class="container-fluid">
				<div class="row" style="justify-content: center;"></div>
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Phiếu nhập hàng</h3>
						</div>
						<!-- /.card-header -->

						<!-- select -->
						<div class="card-body">
							<form  method="POST" 
								action="/admin/management/receipt/quantity">
								
								<div class="col-sm-6">
									<div class="form-group">
									<label for="exampleInputEmail1">Số lượng chi tiết sản phẩm</label>
										<input class="form-control" name="quantityDR" type="number"/>

									</div>
									<span style="color:red">
									<c:if  test="${error != '' }">
										${error}
									</c:if>
									</span>
								</div>
								
							<div class=row style="justify-content: end;">
								
								<div class="col-2">
									<button type="submit" class="btn btn-primary">Tiếp theo</button>

								</div>
							</div>
							</form>

						</div>

					</div>
				</div>
			</div>


		</section>
	</div>
</body>
</html>