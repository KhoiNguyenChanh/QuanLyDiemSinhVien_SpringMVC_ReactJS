<%-- 
    Document   : header
    Created on : Jun 20, 2024, 9:22:51 AM
    Author     : chanh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">Quản lý điểm sinh viên</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
                </li>
                <%-- duyet qua cac mon hoc--%>

                <c:forEach items="${danhmuc}" var="d">
                    <li class="nav-item">
                        <c:url value="/" var="myUrl">
                            <c:param name="monhocId" value="${d.id}" />
                        </c:url>
                        <a class="nav-link" href="${myUrl}">${d.tenDanhMuc}</a>
                    </li>
                </c:forEach>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="btn btn-info" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/" />">Chào! ${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-info" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                </c:choose>

            </ul>
            <form action="<c:url value="/" />" method="GET" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Tìm kiếm môn học......">
                <button class="btn btn-primary" type="submit" title="Tìm kiếm">Tìm</button>
            </form>
        </div>
    </div>
</nav>