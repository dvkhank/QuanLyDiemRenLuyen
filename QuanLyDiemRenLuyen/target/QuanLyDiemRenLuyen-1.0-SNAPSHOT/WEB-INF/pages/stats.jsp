<%-- 
    Document   : stats
    Created on : May 9, 2024, 12:04:53 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ BÁO CÁO</h1>

<div class="row">
    <div class="col-mt-5 col-12">
        <table class="table">
            <tr>
                <th>Id Sinh Viên</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Lớp</th>
                <th>Khoa</th>
                <td>Điểm rèn luyện</td>
            </tr>
            <c:forEach items="${statsTheoKhoa}" var="c"> 
            <tr>
                <td>${c[0]}</td>
                <td>${c[1]}</td>
                <td>${c[2]}</td>
                <td>${c[3]}</td>
                <td>${c[4]}</td>
                <td>${c[5]}</td>
                <td>${c[6]}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>