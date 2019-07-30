<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="/parts/head.jsp" %>
<body>
<%@include file="/parts/navbar.jsp" %>
<div class="container mb-5 mt-3">
    <div class="form-group mt-3">
        <form method="post">
            <input type="hidden" value="${user.id}" name="id"/>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name:</label>
                <div class="col-sm-5">
                    <input type="text" name="username" value="${user.username}" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-5">
                    <input type="text" name="password" value="${user.password}" class="form-control"/>
                </div>
            </div>

            <div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="role" id="USER"
                           value="USER" ${user.role == 'USER' ? "checked" : ""}>
                    <label class="form-check-label" for="USER">USER</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="role" id="ADMIN"
                           value="ADMIN" ${user.role == 'ADMIN' ? "checked" : ""}>
                    <label class="form-check-label" for="ADMIN">ADMIN</label>
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary mt-2">Save</button>
            </div>
        </form>
    </div>
</div>
<%@include file="/parts/footer.jsp" %>
</body>
</html>