<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="span9">

	<div class="well well-small">
		<h3>New Products</h3>
		<hr class="soften" />
		<div class="row-fluid">
			<div id="newProductCar" class="carousel slide">
				<div class="carousel-inner">
					<div class="item active">
					<c:if test="${listProdcut.size() > 0 }">
						<ul class="thumbnails">
							<c:forEach var="product" items="${listProdcut}" begin="${listProdcut.size()-4}" end="${listProdcut.size()}" step="1">
								<li class="span3">
									<div class="thumbnail">
										<a class="zoomTool"
											href="/user/product_details?id=${product.id}"
											title="add to cart"><span class="icon-search"></span>
											QUICK VIEW</a> <a href="#" class="tag"></a> <a
											href="/user/product_details?id=${product.id}"><img
											src='<c:url value="/templates/images/${product.image}"/>'
											alt=""></a>
											<p>${product.name}</p>
									</div>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					</div>
					<div class="item">
						<c:if test="${listProdcut.size() > 0 }">
						<ul class="thumbnails">
							<c:forEach var="product" items="${listProdcut}" begin="${listProdcut.size()-6}" end="${listProdcut.size()-5}" step="1">
								<li class="span3">
									<div class="thumbnail">
										<a class="zoomTool"
											href="/user/product_details?id=${product.id}"
											title="add to cart"><span class="icon-search"></span>
											QUICK VIEW</a> <a href="#" class="tag"></a> <a
											href="product_details.htm"><img
											src='<c:url value="/templates/images/${product.image}"/>'
											alt=""></a>
											<p>${product.name}</p>
									</div>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					</div>
				</div>
				<a class="left carousel-control" href="#newProductCar"
					data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
					href="#newProductCar" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		
		<div class="row-fluid">
			<h3>Product</h3>
			<c:if test="${listProdcut.size() > 0}">
				<ul class="thumbnails">

					<c:forEach var="item" items="${listProdcut}" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
									<a
									href="chi-tiet-san-pham/${item.id}"><img
									src='<c:url value="/templates/images/${item.image}"/>' alt=""></a>
								<div class="caption">
									<h5>${item.name}</h5>
									<h4>
										<a class="defaultBtn" href="product_details?id=${item.id}"
											title="Click to view"><span class="icon-zoom-in"></span></a>
										<a class="shopBtn" href="/cart?id=${item.id}" title="add to cart"><span
											class="icon-plus"></span></a> <span class="pull-right"><fmt:formatNumber
												type="number" groupingUsed="true" value="${item.price}" />
											₫</span>
									</h4>
								</div>
							</div>
						</li>

						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1)  == listProdcut.size()}">
				</ul>
				<c:if test="${ (loop.index + 1) < listProdcut.size() }">
					<ul class="thumbnails">
				</c:if>
			</c:if>

			</c:forEach>

			</c:if>

		</div>
		
	</div>



</div>