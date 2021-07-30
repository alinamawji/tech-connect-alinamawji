<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="/products" />
	</c:import>

	<div class="main-content">
		<!-- Container for Sorting Choices
         
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
    	-->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li><a href="?sortOrder=PriceLowToHigh">Price - Low to High</a></li>
				<li><a href="?sortOrder=PriceHighToLow">Price - High to Low</a></li>
				<li><a href="?sortOrder=RatingHighToLow">Rating - High to Low</a></li>
			</ul>
		</div>

		<!-- Container for all of the Products -->
		<!-- The list of products is available using the `products` variable -->
		<div id="grid">
			<c:forEach var="product" items="${products}">
				<div class="${product.remainingStock == 0 ? 'tile sold-out' : 'tile'}">
					<c:choose>
						<c:when test="${product.remainingStock == 0}">
							<span class="banner">Sold Out</span>
						</c:when>
						<c:when test="${product.topSeller}">
							<span class="banner top-seller">Top Seller!</span>
						</c:when>
					</c:choose>

					<a class="product-image" href="products/detail?id=${product.id}">
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

						<p class="price">
							<fmt:formatNumber value="${product.price}" type="currency"/>
						</p>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />