<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="/parts/head.jsp" %>
<body>
<%@include file="/parts/navbar.jsp" %>
<div class="container mb-5 mt-3">

    <a class="btn btn-primary btn-sm" href='<c:url value="?action=create"/>'>Create new</a>
    <table class="table table-hover mt-3">
        <thead class="bg-secondary">
        <tr>
            <th>Description</th>
            <th>Content</th>
            <th>Author</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.description}</td>
                <td>${task.content}</td>
                <td>${task.author}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href='<c:url value="?action=edit&id=${task.id}" />'>Edit</a>
                    <form method="post" action='<c:url value="?action=delete"/>' style="display:inline;">
                        <input type="hidden" name="id" value="${task.id}">
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