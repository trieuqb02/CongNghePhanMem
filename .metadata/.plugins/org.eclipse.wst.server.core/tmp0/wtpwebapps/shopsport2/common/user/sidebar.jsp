<%@ include file="/common/taglib.jsp"%>
<div id="sidebar" class="span3">
	<div class="well well-small">
		<ul class="nav nav-list">
		
		
			 <c:forEach var="c" items="${category}">
			 
			 	<li><a href="/user/products?id=${c.id}"><span class="icon-chevron-right"></span>${c.name}</a></li>
			</c:forEach>
			
			
			
			
		</ul>
	</div>

	
	<div class="well well-small">
		<a href="#"><img src="/templates/user/assets/img/paypal.jpg"
			alt="payment method paypal"></a>
	</div>

	

</div>