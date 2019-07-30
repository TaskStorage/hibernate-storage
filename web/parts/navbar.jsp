<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand text-white" href='<c:url value="/"/>'>
        <img src='<c:url value="/static/logo.png"/>' width="50" height="30" class="d-inline-block align-left" alt=""/>
        TaskStorage
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">

                <a class="nav-link" href='<c:url value="/tasklist"/>'>Tasks</a>
                <%--<a class="nav-link" href="/tasklist">Tasks</a>--%>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/userlist"/>'>User list</a>
            </li>
        </ul>
        <a href='<c:url value="/login"/>' class="btn btn-primary btn-sm ml-1">Login</a>
        <a href='<c:url value="/register"/>' class="btn btn-primary btn-sm ml-1">Register</a>
    </div>
</nav>