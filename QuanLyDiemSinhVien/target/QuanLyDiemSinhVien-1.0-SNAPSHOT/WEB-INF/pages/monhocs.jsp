<%-- 
    Document   : monhoc
    Created on : Jun 20, 2024, 9:45:07 AM
    Author     : chanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1 class="text-center text-info">Thêm môn học</h1>
<!--modelAttributes nhan name tu trong controller-->
<c:url value="/monhocs" var="action"/>
<form:form method="POST" action="${action}" modelAttribute="monhocs" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên môn học" path="ten" />
        <label for="name">Tên môn học</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="desc" placeholder="Mô tả môn học" path="moTaMonHoc" />
        <label for="desc">Mô tả môn học</label>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="danhmuc" path="danhMucMonHoc">
            <c:forEach items="${giangvien}" var="g">
                <option value="${g.id}">${g.ten}</option>
            </c:forEach>
        </form:select>
        <label for="danhMucMonHoc" class="form-label">Giảng viên phụ trách</label>
    </div>  
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="danhmuc" path="danhMucMonHoc">
            <c:forEach items="${danhmuc}" var="d">
                <option value="${d.id}">${d.tenDanhMuc}</option>
            </c:forEach>
        </form:select>
        <label for="danhMucMonHoc" class="form-label">Danh mục môn học</label>

    </div>  
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-primary">Thêm</button>

    </div>

</form:form>
<!-- not use anymore 
<div class="form-floating mb-3 mt-3">
            form:input class="form-control" id="giangvien" placeholder="Giảng viên phụ trách" path="tenGiangVien" />
            <label for="giangvien">Giảng viên phụ trách</label>
        </div>
            <div class="form-floating mb-3 mt-3">
            form:input class="form-control" id="danhmuc" placeholder="Danh mục môn học" path="danhMucMonHoc" />
            <label for="danhmuc">Danh mục môn học</label>
        </div>-->
    <!--giangViens và danhMucs nam trong monhoccontroller, tach biet voi homecontroller-->
    <!--    <div class="form-floating mb-3 mt-3">
            form:select class="form-control" id="giangvien" path="tenGiangVien">
                form:option value="" label="Chọn giảng viên" />
                form:options items="{giangvien}" itemValue="id" itemLabel="ten" />
            /form:select>
            <label for="giangvien">Giảng viên phụ trách</label>
        </div>-->
    <!--    <div class="form-floating mb-3 mt-3">
            form:select class="form-control" id="danhmuc" path="danhMucMonHoc">
    form:option value="" label="Chọn danh mục" />
    form:options items="{danhmuc}" itemValue="id" itemLabel="tenDanhMuc" />
/form:select>
<label for="danhmuc">Danh mục môn học</label>
</div>-->