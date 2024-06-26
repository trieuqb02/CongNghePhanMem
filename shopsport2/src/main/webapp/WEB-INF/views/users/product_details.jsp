<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="index.htm">Home</a> <span class="divider">/</span></li>
		<li><a href="/user/products">Items</a> <span class="divider">/</span></li>
		<li class="active">Preview</li>
	</ul>
	<div class="well well-small">
		<div class="row-fluid">
			<div class="span5">
				<div id="myCarousel" class="carousel slide cntr">
					<div class="carousel-inner">
						<div class="item active">
							<a href="#"> <img
								src='<c:url value="/templates/images/${product.image}"/>' alt=""
								style="width: 100%"></a>
						</div>

					</div>

				</div>
			</div>
			<div class="span7">
				<h3>${product.name}</h3>
				<hr class="soft" />

				<form class="form-horizontal qtyFrm">
					<div class="control-group">
						<label class="control-label"><span>Giá sản phẩm</span></label>
						<div class="controls">
							<p style="font-size: 30px; font-weight: bold;">${product.price}</p>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label"></label>
						<div class="controls"></div>
					</div>
					<div class="control-group">
						<label class="control-label"></label>
						<div class="controls"></div>
					</div>
					<h4>Mô tả sản phẩm</h4>
					<p>${product.description}
					<p>
						<a href="/cart?id=${product.id}" class="shopBtn"> <span
							class=" icon-shopping-cart"></span> Add to cart
						</a>
				</form>
			</div>
		</div>
		<hr class="softn clr" />


		<ul id="productDetail" class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">Product
					Details</a></li>
			<li class=""><a href="#profile" data-toggle="tab">Related
					Products </a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Acceseries <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#cat1" data-toggle="tab">Category one</a></li>
					<li><a href="#cat2" data-toggle="tab">Category two</a></li>
				</ul></li>
		</ul>


	</div>
</div>

