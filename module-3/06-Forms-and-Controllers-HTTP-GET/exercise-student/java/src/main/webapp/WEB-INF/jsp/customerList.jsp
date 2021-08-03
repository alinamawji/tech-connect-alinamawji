<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/customerList/search"/>
<form method="GET" action="${ formAction }">
    <input placeholder="Search" type="text" name="name" id="name">

    <label for="order">Sort: </label>
    <select name="order" id="order">
        <option value="last_name">Last Name</option>
        <option value="email">Email</option>
        <option value="active">Active</option>
    </select>

    <input type="submit">
</form>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Active</th>
    </tr>
    <c:forEach items="${ customers }" var="customer">
        <tr>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <c:if test="${customer.active == true}">
                <td>Yes</td>
            </c:if>
            <c:if test="${customer.active == false}">
                <td>No</td>
            </c:if>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>