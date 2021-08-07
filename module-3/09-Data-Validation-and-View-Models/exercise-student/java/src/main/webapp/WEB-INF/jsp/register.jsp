<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="pageTitle" value="Register"/>
<%@include file="common/header.jspf" %>

<style>
  .error {
    color: red;
    font-weight: bold;
  }
</style>

<h2>New User Registration</h2>

<c:url var="formAction" value="/register" />
<form:form method="POST" action="${ formAction }" modelAttribute="registration">
  <label for="firstName">First Name</label>
  <form:input path="firstName" placeholder="enter first name" type="text"/>
  <form:errors path="firstName" cssClass="error"/>

  <label for="lastName">Last Name</label>
  <form:input path="lastName" placeholder="enter last name" type="text"/>
  <form:errors path="lastName" cssClass="error"/>

  <label for="email">Email</label>
  <form:input path="email" placeholder="enter email" type="text"/>
  <form:errors path="email" cssClass="error"/>

  <label for="confirmationEmail">Confirm Email</label>
  <form:input path="confirmationEmail" placeholder="confirm email address" type="text"/>
  <form:errors path="emailMatching" cssClass="error"/>

  <label for="password">Password</label>
  <form:input path="password" placeholder="enter password" type="text"/>
  <form:errors path="password" cssClass="error"/>

  <label for="confirmationPassword">Confirm Password</label>
  <form:input path="confirmationPassword" placeholder="confirm password" type="text"/>
  <form:errors path="passwordMatching" cssClass="error"/>

  <label for="birthday">Birthday</label>
  <form:input path="birthday" placeholder="enter birth date" type="text"/>
  <form:errors path="birthday" cssClass="error"/>

  <label for="tickets"># of Tickets</label>
  <form:input path="tickets" placeholder="enter number of tickets" type="text"/>
  <form:errors path="tickets" cssClass="error"/>
  <br>

  <input type="submit">
</form:form>
<%@include file="common/footer.jspf" %>
