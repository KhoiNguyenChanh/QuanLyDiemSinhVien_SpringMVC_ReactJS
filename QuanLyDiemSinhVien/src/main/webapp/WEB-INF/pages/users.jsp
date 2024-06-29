<%-- 
    Document   : sinhviens
    Created on : Jun 25, 2024, 11:51:53 PM
    Author     : chanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:choose>
    <c:when test="${user.id > 0}">
        <h1 class="text-center text-info">Quản lý sinh viên</h1>
    </c:when>
    <c:otherwise>
        <h1 class="text-center text-info">Quản lý người dùng</h1>
    </c:otherwise>
</c:choose>


<%--<c:url value="/monhocs" var="action"/>--%>
<%--<form:form method="post" action="${action}" modelAttribute="monhocs" enctype="multipart/form-data">--%>
<c:url value="/users" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">

    <form:errors path="*" element="div" cssClass="alert alert-danger"/>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên môn học" path="ten" />
        <label for="name">Tên người dùng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="email" placeholder="Email" path="email" />
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="sdt" placeholder="Số điện thoại" path="sdt" />
        <label for="sdt">Số điện thoại</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="username" placeholder="Username" path="username" />
        <label for="username">Tên tài khoản (Username)</label>
    </div>
        <!--tim cach de crypt cai mk lai-->
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" id="pass" placeholder="Password" path="password" />
        <label for="pass">Mật khẩu</label>
        <!--<p>$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO</p>-->
    </div>

    <!--role-->
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="role" placeholder="Role" path="role" />
        <label for="role">Vai trò</label>
    </div>

<!--    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="role" path="role">
            <c:forEach items="${users}" var="u">
                <c:choose>
                    <c:when test="${u.id == users.id}">
                        <option value="${u.id}" selected>${u.role}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${u.id}">${u.nguoidung.role}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="danhMucMonHoc" class="form-label">Vai trò</label>
    </div>  -->
    <!--avatar-->
    <div class="form-floating mb-3 mt-3">
            <form:input class="form-control" id="avatar" type="file" path="file" />
            <label for="avatar">Avatar</label>
            <form:errors path="file" cssClass="error" />
        </div>

    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${user.id > 0}">
                    Cập nhật sinh viên
                </c:when>
                <c:otherwise>
                    Thêm người dùng
                </c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id" />
    </div>
</form:form>
