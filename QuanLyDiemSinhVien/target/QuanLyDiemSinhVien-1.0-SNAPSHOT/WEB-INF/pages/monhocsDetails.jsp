<%-- 
    Document   : monhocsDetails
    Created on : Jun 25, 2024, 4:22:03 PM
    Author     : chanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-success">Chi tiết môn học</h1>
<div class="row container">

    <h5>Tên môn:</h5>
    <h5>Giảng viên phụ trách:</h5>
    <!--    <div class="col-md-8 col-12">-->
    <h2>Danh sách sinh viên</h2>
    <div class="row">
        <div>
            <a class="btn btn-primary my-2 text-decoration-none" href="<c:url value='/users'/>">Thêm sinh viên</a>
        </div>
        <div class="row">
            <form action="<c:url value="/monhocdetails" />" method="GET" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Tìm kiếm sinh viên......">
                <button class="btn btn-primary" type="submit" title="Tìm kiếm">Tìm</button>
            </form>
        </div> 
    </div>

    <table class="table table-hover ">
        <thead>
            <tr>
                <th>Thông tin sinh viên</th>
                <th>Ðiểm giữa kỳ</th>
                <th>Ðiểm cuối kỳ</th>

            </tr>
        </thead>

        <tbody>
            <c:forEach items="${user}" var="u">
                <c:if test="${u.role == 'sinhvien'}">
                    <tr>
                        <td>
                            <div class="card" style="width:400px">
                                <img class="card-img-top" src="${u.avatar}" alt="${u.ten}">
                                <div class="card-body">
                                    <h4 class="card-title">Tên sinh viên: ${u.ten}</h4>
                                    <p>MSSV: ${u.id}</p>
                                    <p>Vai tro: ${u.role}</p>
                                    <p>Email: ${u.email}</p>
                                    
                                    <a href="<c:url value="/sinhvienDetails/${u.id}"/>" class="btn btn-primary">Chi tiết sinh viên</a>
                                    
                                    <c:url value="/api/users/${u.id}" var="url"/>
                                    <a href="#" onclick="deleteUser('${url}',${u.id})" class="btn btn-primary">Xóa sinh viên</a>

                                </div>
                            </div>
                        </td>

                        <td>
                            <!-- Hiển thị điểm giữa kỳ của sinh viên -->
                            <c:forEach items="${scoresv}" var="s" varStatus="loop">
                                <c:if test="${loop.index == 0}"> <!-- Chỉ lấy điểm của sinh viên hiện tại -->
                                    ${s.giuaKy}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <!-- Hiển thị điểm cuối kỳ của sinh viên -->
                            <c:forEach items="${scoresv}" var="s" varStatus="loop">
                                <c:if test="${loop.index == 0}"> <!-- Chỉ lấy điểm của sinh viên hiện tại -->
                                    ${s.cuoiKy}
                                </c:if>
                            </c:forEach>
                        </td>
<!--                        <td>
                             Hiển thị điểm giữa kỳ của sinh viên 
                            <%--<c:forEach items="${scoresv}" var="s">--%>
                            {u.scoreSvSet}
                            <%--</c:forEach>--%>
                        </td>
                        <td>
                             Hiển thị điểm cuối kỳ của sinh viên 
                            <%--<c:forEach items="${scoresv}" var="s">--%>
                            {u.scoreSvSet}
                            <%--</c:forEach>--%>
                        </td>-->

                    </tr>
                </c:if>
            </c:forEach>
        </tbody>

    </table>
    <!--</div>-->
    <!--    <div class="col-md-4 col-12">
            <div th:if="{monhoc != null}">
                <h2>Tên môn học: <span th:text="{monhoc.ten}"></span></h2>
                <h3>Giảng viên phụ trách</h3>
                <div th:if="{giangvien != null}">
                    <p>Tên: <span th:text="{giangvien.ten}"></span></p>
                    <p>Email: <span th:text="{giangvien.email}"></span></p>
                    <p>SĐT: <span th:text="{giangvien.sdt}"></span></p>
                </div>
                <div th:if="{giangvien == null}">
                    <p><span th:text="{error}">Không tìm thấy giảng viên phụ trách</span></p>
                </div>
            </div>
            <div th:if="{monhoc == null}">
                <p><span th:text="{error}">Không tìm thấy môn học</span></p>
            </div>
        </div>-->
</div>
<script src="<c:url value="/js/script.js"/>"></script>
