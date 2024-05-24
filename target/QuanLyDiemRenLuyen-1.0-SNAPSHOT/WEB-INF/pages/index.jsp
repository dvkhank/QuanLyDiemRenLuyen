<%-- 
    Document   : index
    Created on : May 5, 2024, 1:05:13 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %> 
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="mt-1">
    <div>
        <a href="<c:url value="/admin/hoatdongs" />" class="btn btn-info">Thêm hoạt động</a>
    </div>

    <table class="table table-striped mt-1">

        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Mô Tả</th>
            <th>Điểm</th>
            <th>Điều</th>
            <th>Khoa</th>
            <th>Học kì</th>
            <th>Năm</th>
            <th>Trợ lý tạo ra</th>
            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${hoatDongs}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.ten}</td>
                    <td>${c.moTa}</td>
                    <td>${c.diem}</td>
                    <td>${c.dieuId.getDieu()}</td>
                    <td>${c.khoaId.getTen()}</td>
                    <td>${c.hocKiNamHocId.getHocKiId().getHocKi()}</td>
                    <td>${c.hocKiNamHocId.getNamHocId().getNamHoc()}</td>                     
                    <td>${c.troLyId.getNguoiDung().getHo()}  ${c.troLyId.getNguoiDung().getTen()}</td>
                    <c:url value="/admin/hoatdongs/${c.id}" var="url"/>
                    <td>
                        <a href="<c:url value="/admin/hoatdongs/${c.id}" />" class="btn btn-info">Cập nhật</a>
                        <button onclick="deleteHoatDong('${url}')" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
    </sec:authorize>
<script src="<c:url value="/js/script.js" />"></script>


