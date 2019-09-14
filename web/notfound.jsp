<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<%@include file="parts/head.jsp" %>
<body>
<%@include file="parts/navbar.jsp" %>
<div class="container mb-5 mt-3">
    <div class="text-center">
        <img src='<c:url value="/static/404.png"/>'>
    </div>
</div>
<%@include file="parts/footer.jsp" %>
</body>
</html>