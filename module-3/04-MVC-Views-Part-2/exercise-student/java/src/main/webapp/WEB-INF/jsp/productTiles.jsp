<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

<div id="masonry-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="/products/tiles" />
	</c:import>

	<!-- Container for all of the Products -->
	<!-- The list of products is available using the `products` variable -->
	<div id="grid" class="main-content">

		<!-- The following HTML shows different examples of what HTML
		 could be rendered based on different rules. For purposes
		 of demonstration we've written it out so you can see it
		 when you load the page up. -->
		<c:forEach var="product" items="${products}">
			<div class="${product.remainingStock == 0 ? 'tile sold-out' : product.topSeller ? 'tile top-seller' : 'tile'}">
				<c:if test="${product.remainingStock == 0}">
					<span class="banner">Sold Out</span>
				</c:if>

				<a class="product-image" href="detail?id=${product.id}">
					<img src="<c:url value="/images/product-images/${product.imageName}"/>"/>
				</a>

				<div class="details">
					<p class="name">${product.name}</p>

					<!-- .filled will make the star solid -->
					<div class="rating">
						<c:forEach begin="1" end="5" var="starCount">
							<c:set var="filled" value="${starCount <= product.averageRating ? 'filled' : ''}"/>
							<span class="${filled}">&#9734;</span>
						</c:forEach>
					</div>

					<c:if test="${product.topSeller}">
						<br />
						<p class="product-alert">Top Seller</p>
					</c:if>
					<c:if test="${product.remainingStock > 0 && product.remainingStock <= 5}">
						<p class="product-alert">${product.remainingStock} remaining!</p>
					</c:if>

					<p class="price">
						<fmt:formatNumber value="${product.price}" type="currency"/>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />