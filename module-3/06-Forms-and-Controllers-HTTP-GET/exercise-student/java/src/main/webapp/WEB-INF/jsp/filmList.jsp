<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/filmList/search"/>
<form method="GET" action="${ formAction }">
    <label for="min_length">Minimum Length: </label>
    <input type="number" name="min_length" id="min_length">

    <label for="max_length">Maximum Length: </label>
    <input type="number" name="max_length" id="max_length">

    <label for="genre">Genre: </label>
    <select name="genre" id="genre" required="required">
        <option value="Action">Action</option>
        <option value="Animation">Animation</option>
        <option value="Children">Children</option>
        <option value="Classics">Classics</option>
        <option value="Comedy">Comedy</option>
        <option value="Documentary">Documentary</option>
        <option value="Drama">Drama</option>
        <option value="Family">Family</option>
        <option value="Foreign">Foreign</option>
        <option value="Games">Games</option>
        <option value="Horror">Horror</option>
        <option value="Music">Music</option>
        <option value="New">New</option>
        <option value="Sci-Fi">Sci-Fi</option>
        <option value="Sports">Sports</option>
        <option value="Travel">Travel</option>
    </select>

    <input type="submit">
</form>
<table class="table">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Release Year</th>
        <th>Length</th>
        <th>Rating</th>
    </tr>
    <c:forEach items="${films}" var="film">
        <tr>
            <td>${film.title}</td>
            <td>${film.description}</td>
            <td>${film.releaseYear}</td>
            <td>${film.length}</td>
            <td>${film.rating}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>