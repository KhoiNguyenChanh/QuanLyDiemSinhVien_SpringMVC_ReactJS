<%-- 
    Document   : index
    Created on : Jun 12, 2024, 9:42:40 AM
    Author     : chanh
    ! Trang chu !
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1><p class="text-info mt-3 ">Danh sách môn học</p></h1>
<c:if test="${not empty loggedInUser}">
    <div>
        <!--<button class="btn btn-primary my-2" href="<c:url value='/monhocs'/>">Thêm môn học</button>-->
        <a class="btn btn-primary my-2 text-decoration-none" href="<c:url value='/monhocs'/>">Thêm môn học</a>
        <a class="btn btn-primary my-2 text-decoration-none" href="<c:url value='/users'/>">Thêm giảng viên</a>

    </div>
</c:if>

<table class="table table-hover ">
    <thead>
        <tr>
            <th>Tên môn học</th>
            <th>Mô tả</th>
            <th>Giảng viên phụ trách</th>
            <th class="text-center">Chi tiết môn học</th>
        </tr>
    </thead>
    <c:forEach items="${monhoc}" var="m">
        <tbody>
            <tr>                            
                <!--<td>{m.ten}</td>-->
                <td><a href="<c:url value="/monhocdetails"/>" class="text-primary text-decoration-none">${m.ten}</a></td>
                <td class="text-secondary">${m.moTaMonHoc}</td>
                <td class="text-secondary">${m.nguoidung.ten}</td>
                <c:if test="${not empty loggedInUser}">
                    <td class="text-center">
                        <c:url value="/api/monhocs/${m.id}" var="url"/>
                        <a href="<c:url value="/monhocdetails"/>" class="btn btn-primary mr-5">Xem chi tiết</a>
                        <a href="<c:url value="/monhocs/${m.id}"/>" class="btn btn-success">Cập nhật môn</a>
                        <button onclick="deleteMonhoc('${url}',${m.id})" class="btn btn-danger">Xóa môn</button>
                    </td>
                </c:if>
            </tr>
        </tbody>
    </c:forEach>

    <!--        just checcking :p
    c:forEach items="${scoresv}" var="s">
        <p> ${s.id}</p>
        <h2>${s.giuaKy}</h2>
        <h2>${s.cuoiKy}</h2>
        <h2>${s.nguoidung}</h2>


    /c:forEach> -->
    <!--just checcking :p-->
<!--        c:forEach items="${user}" var="u">
        <p> ${u.ten}</p>
        <h2>${u.role}</h2>
    /c:forEach> -->
</table>
<script src="<c:url value="/js/script.js"/>"></script>