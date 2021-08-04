<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Color" />
</c:import>

<table>
    <tbody>
        <tr>
            <th>
                Favorite Color:
            </th>
            <td>
                <c:out value="${ favoriteThings.favoriteColor }"/>
            </td>
        </tr>
        <tr>
            <th>
                Favorite Food:
            </th>
            <td>
                <c:out value="${ favoriteThings.favoriteFood }"/>
            </td>
        </tr>
        <tr>
            <th>
                Favorite Season:
            </th>
            <td>
                <c:out value="${ favoriteThings.favoriteSeason }"/>
            </td>
        </tr>
    </tbody>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />