<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="title" value="Favorite Color" />
</c:import>

<c:url var="formAction" value="/FavoriteThings/Page2" />
<form method="POST" action="${formAction}">
<label>What is your favorite food?</label>
<input type="text" name="favoriteFood">
<button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />