<%-- 
    Document   : sinhvienDetails
    Created on : Jun 27, 2024, 5:14:02 PM
    Author     : chanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 class="text-center text-success">Chi tiết sinh viên</h1>

<!-- Iterate over the list of student information -->
<c:forEach var="studentInfo" items="${studentInfos}">
    <div class="student-details">
        <h2>${studentInfo.studentName}</h2>
        <p><strong>MSSV:</strong> ${studentInfo.studentId}</p>
        <h3>Các khóa học đã đăng ký:</h3>

        <!-- Iterate over the courses for each student -->
        <ul>
            <c:forEach var="courseInfo" items="${studentInfo.courses}">
                <li>
                    <strong>Tên khóa học:</strong> ${courseInfo.courseName}<br>
                    <strong>Điểm giữa kỳ:</strong> ${courseInfo.midtermScore}<br>
                    <strong>Điểm cuối kỳ:</strong> ${courseInfo.finalScore}
                </li>
            </c:forEach>
        </ul>
        <hr>
    </div>
</c:forEach>

