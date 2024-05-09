<%-- 
    Document   : header
    Created on : May 7, 2024, 2:54:16 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand""><img width="100px" src="<c:url value="/images/logo.jpg" />"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:forEach items="${dieus}" var="c">
                    <li class="nav-item">
                        <c:url var="myUrl" value="/">
                            <c:param name="dieuId" value="${c.id}"/>
                        </c:url>
                        <a class="nav-link" href="${myUrl}">Điều ${c.dieu}</a>
                    </li>
                </c:forEach>

                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Tính năng</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Bảng tin</a></li>
                        <li><a class="dropdown-item btn-info" href="<c:url value="/stats" />">Thống kê</a></li>
                        <li><a class="dropdown-item" href="#">Hỏi đáp</a></li>
                    </ul>
                </li>
            </ul>
            <form action="<c:url value="/" />" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

