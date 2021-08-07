<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="pageTitle" value="Login"/>
<%@include file="common/header.jspf" %>

<style>
    .error {
        color: red;
        font-weight: bold;
    }
</style>

<h2>Login</h2>

<c:url var="formAction" value="/login" />
<form:form method="POST" action="${ formAction }" modelAttribute="login">
    <label for="email">Email</label>
    <form:input path="email" placeholder="enter email" type="text"/>
    <form:errors path="email" cssClass="error"/>

    <label for="password">Password</label>
    <form:input path="password" placeholder="enter password" type="text"/>
    <form:errors path="password" cssClass="error"/>

    <br>

    <button type="submit">Submit</button>

</form:form>
<%@include file="common/footer.jspf" %>
