<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Color" />
</c:import>

<c:url var="formAction" value="/FavoriteThings/Page3" />
<form method="POST" action="${formAction}">
    <label>What is your favorite season?</label>
    <select name="favoriteSeason">
        <option>Spring </option>
        <option>Summer </option>
        <option>Fall </option>
        <option>Winter </option>
    </select>
    <button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />