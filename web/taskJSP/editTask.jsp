<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="/parts/head.jsp" %>
<body>
<%@include file="/parts/navbar.jsp" %>
<div class="container mb-5 mt-3">
    <div class="form-group mt-3">
        <form method="post">
            <input type="hidden" value="${task.id}" name="id"/>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Description</label>
                <div class="col-sm-5">
                    <input type="text" name="description" value="${task.description}" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Content</label>
                <div class="col-sm-5">
                    <input type="text" name="content" value="${task.content}" class="form-control"/>
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