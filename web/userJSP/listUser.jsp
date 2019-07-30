<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="/parts/head.jsp" %>
<body>
<%@include file="/parts/navbar.jsp" %>
<div class="container mb-5 mt-3">
    <table class="table table-hover mt-3">
        <thead class="bg-secondary">
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>
                <a class="btn btn-primary btn-sm" href='<c:url value="?action=edit&id=${user.id}" />'>Edit</a>
                <form method="post" action='<c:url value="?action=delete"/>' style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
        </tbody>
</table>
</div>
<%@include file="/parts/footer.jsp" %>
</body>
</html>