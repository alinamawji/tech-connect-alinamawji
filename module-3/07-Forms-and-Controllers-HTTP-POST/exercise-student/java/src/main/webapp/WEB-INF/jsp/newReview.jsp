<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<h2>Create New Review</h2>

<div class="reviewSection">
    <c:url var="formAction" value="/"/>
    <form method="POST" action="${ formAction }">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required="required">

        <label for="rating">Rating: </label>
        <input type="range" min="0" max="5" name="rating" id="rating" required="required">

        <label for="title">Review Title: </label>
        <input type="text" name="title" id="title" required="required">

        <label for="content">Review Content: </label>
        <input type="text" name="content" id="content" required="required">

        <input type="submit">
    </form>
</div>