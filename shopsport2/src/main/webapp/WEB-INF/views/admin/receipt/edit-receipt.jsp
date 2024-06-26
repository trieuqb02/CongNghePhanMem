<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật phiếu nhập</title>
</head>
<body>
	<%@ include file="/common/admin/nav.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<a href="/admin/management/prodcut/list"><h1></h1></a>
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
							<form:form modelAttribute="updateReceipt" method="POST" id="receipt">
								<div class="col-sm-6">
									<div class="form-group">
										
											<div class="form-group">
												<label for="exampleInputEmail1">Mã phiếu nhập</label>
												<input type="text" disabled="disabled" value="${updateReceipt.id}">
											</div>
										

									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<spring:bind path="supplier">
											<div class="form-group">
												<label for="exampleInputEmail1">Nhà cung cấp</label>
												
													
													<form:select class="custom-select" path="supplier">
														<c:forEach items="${suppliers}" var="s">
															<c:choose>
    															<c:when test="${s.name == updateReceipt.supplier.name}">
        																<form:option  value="${s.id}" selected="selected" label="${s.name}"/>  
    															</c:when>    
    														<c:otherwise>
        																<form:option  value="${s.id}" label="${s.name}"/>  
   															 </c:otherwise>
   															 </c:choose>
														</c:forEach>
													
													</form:select>
											</div>
											<form:errors path="supplier"></form:errors>
										</spring:bind>

									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<spring:bind path="date">
											<div class="form-group">
												<label for="exampleInputEmail1">Ngày cập nhật</label>
												<form:input type="date"  path="date"/>
											</div>
											<form:errors path="date"></form:errors>
										</spring:bind>
									</div>
								</div>


								<div class="col-sm-12">

									<table id="id_table" class="table table-head-fixed text-nowrap">
										<thead>
											<tr>
												<th>Tên sản phẩm</th>
												<th>Số lượng</th>
												<th>Đơn giá</th>

											</tr>
										</thead>

										<c:forEach items="${updateReceipt.detailsReceipts}" var="dr"
											varStatus="loop">
											<tr>
												<td><spring:bind
														path="detailsReceipts[${loop.index}].product">
														<div class="form-group">
														
															<form:select class="custom-select" path="detailsReceipts[${loop.index}].product">
																<c:forEach items="${products}" var="p">
																	<c:choose>
    																<c:when test="${p.name == updateReceipt.detailsReceipts[loop.index].product.name}">
        																<form:option  value="${p.id}" selected="selected" label="${p.name}"/>  
    																</c:when>    
    															<c:otherwise>
        																<form:option  value="${p.id}" label="${p.name}"/>  
   															 	</c:otherwise>
   															 </c:choose>
																</c:forEach>
																</form:select>
														

															
														</div>
														<form:errors path="detailsReceipts[${loop.index}].product"></form:errors>
													</spring:bind></td>

												<td><spring:bind
														path="detailsReceipts[${loop.index}].quantity">
														<div class="form-group">
															<form:input class="form-control" type="number"
																path="detailsReceipts[${loop.index}].quantity" />
														</div>
														<form:errors
															path="detailsReceipts[${loop.index}].quantity"></form:errors>
													</spring:bind></td>

												<td><spring:bind
														path="detailsReceipts[${loop.index}].priceImport">
														<div class="form-group">
															<form:input class="form-control" type="text"
																path="detailsReceipts[${loop.index}].priceImport" />
														</div>
														<form:errors
															path="detailsReceipts[${loop.index}].priceImport"></form:errors>
													</spring:bind></td>
											</tr>

										</c:forEach>
											<tr>
												<td></td>
												<td></td>
												<td>Tổng tiền: ${updateReceipt.sumMoney}</td>
											</tr>
									</table>

								</div>
								<div class=row style="justify-content: end;">

									<div class="col-2">
										<button type="submit" class="btn btn-primary">Xác
											nhập</button>

									</div>
								</div>
							</form:form>

						</div>

					</div>
				</div>
			</div>


		</section>
	</div>
</body>
</html>