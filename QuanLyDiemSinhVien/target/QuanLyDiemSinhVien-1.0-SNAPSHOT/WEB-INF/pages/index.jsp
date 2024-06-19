<%-- 
    Document   : index
    Created on : Jun 12, 2024, 9:42:40 AM
    Author     : chanh
    ! Trang chu !
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
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

                    </ul>
                    <form action="<c:url value="/" />" method="GET" class="d-flex">
                        <input class="form-control me-2" name="kw" type="text" placeholder="Tìm kiếm môn học......">
                        <button class="btn btn-primary" type="submit" title="Tìm kiếm">Tìm</button>
                    </form>
                </div>
            </div>
        </nav>
        <section class="container ">
            <h1><p class="text-info mt-3 ">Danh sách môn học</p></h1>

            <table class="table table-hover ">
                <thead>
                    <tr>
                        <th>Tên môn học</th>
                        <th>Mô tả</th>
                        <th class="text-center">Chi tiết môn học</th>
                    </tr>
                </thead>
                <c:forEach items="${monhoc}" var="m">
                    <tbody>
                        <tr>                            
                            <!--<td>${m.ten}</td>-->
                            <td><a href="#" class="text-primary text-decoration-none">${m.ten}</a></td>
                            <td class="text-secondary">${m.moTaMonHoc}</td>
                            <td class="text-center">
                                <a href="#" class="btn btn-primary mr-5">Xem chi tiết</a>
                                <a href="#" class="btn btn-danger">Xóa môn</a>
                            </td>

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
            
        </section>

    </body>
</html>
