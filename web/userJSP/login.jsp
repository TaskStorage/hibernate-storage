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
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name:</label>
                <div class="col-sm-5">
                    <input type="text" name="username" required placeholder="username" class="form-control"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-5">
                    <input type="password" name="password" required placeholder="password" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary mt-2">Login</button>
            </div>
        </form>
    </div>
</div>
<%@include file="/parts/footer.jsp" %>
</body>
</html>
