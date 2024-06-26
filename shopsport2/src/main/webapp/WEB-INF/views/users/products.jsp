<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<div class="span9">
	<!-- 
New Products
-->
	<div class="well well-small">
		<h3>Our Products</h3>
		
		<div class="row-fluid">

			<c:if test="${products.size() > 0}">
				<ul class="thumbnails">

					<c:forEach var="item" items="${products}" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a class="zoomTool" href="/user/product_details?id=${item.id}" title="add to cart"><span
									class="icon-search"></span> QUICK VIEW</a> <a
									href="chi-tiet-san-pham/${item.id}"><img
									src='<c:url value="/templates/images/${item.image}"/>' alt=""></a>
								<div class="caption">
									<h5>${item.name}</h5>
									<h4>
										<a class="defaultBtn" href="product_details?id=${item.id}"
											title="Click to view"><span class="icon-zoom-in"></span></a>
										<a class="shopBtn" href="#" title="add to cart"><span
											class="icon-plus"></span></a> <span class="pull-right"><fmt:formatNumber
												type="number" groupingUsed="true" value="${ item.price }" />
											₫</span>
									</h4>
								</div>
							</div>
						</li>

						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1)  == products.size()}">
				</ul>
				<c:if test="${ (loop.index + 1) < products.size() }">
					<ul class="thumbnails">
				</c:if>
			</c:if>

			</c:forEach>

			</c:if>

		</div>
		
		
		
	</div>

</div>
<!-- 
Clients 
-->
