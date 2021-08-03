<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/newReview"/>
<form method="GET" action="${ formAction }">
    <input class="newReviewButton" type="submit" value="New Review">
</form>

<br>
<h2>Squirrel Parties for Dummies</h2>
<h3>by Craig Castelaz</h3>
<br>

<img src="<c:url value="/static/forDummies.png"/>" alt="book cover picture" class="center"/>

<hr>

<h2>Reviews</h2>

<div>
    <c:forEach items="${ reviews }" var="review">
        <div class="reviewSection">
            <p>${review.title}</p>
            <p>By: ${review.username}</p>
                <c:forEach begin="1" end="5" var="currentStar">
                    <c:if test="${review.rating >= currentStar}">
                        <img src="<c:url value="/static/star.png"/>" alt="star">
                    </c:if>
                </c:forEach>
            <p>${review.text}</p>
        </div>
    </c:forEach>
</div>