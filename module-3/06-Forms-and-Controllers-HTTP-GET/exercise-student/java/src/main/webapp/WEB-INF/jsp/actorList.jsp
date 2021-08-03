<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/actorList/search"/>
<form method="GET" action="${ formAction }">
    <p>
        <input placeholder="Search" type="text" name="last_name" id="last_name">
        <input type="submit">
    </p>
</form>

<table class="table">
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items="${actors}" var="actor">
    <tr>
        <td>${actor.firstName} ${actor.lastName}</td>
    </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>