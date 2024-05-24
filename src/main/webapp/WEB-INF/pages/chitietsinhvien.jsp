<%-- 
    Document   : chitietsinhvien
    Created on : May 10, 2024, 10:04:33 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="row">
    <h1 class="text-center text-info mt-3">THÔNG TIN CHI TIẾT CỦA SINH VIÊN</h1>
    <div class="col-mt-5 col-12 mt-3">
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>MSSV</th>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${chitiets}" var="c">
                    <tr>
                        <td><img width="70px" src="${c[0]}"></td>
                        <td>${c[1]}</td>
                        <td>${c[2]}</td>
                        <td>${c[3]}</td>
                        <td>${c[4]}</td>
                        <td>${c[5]}</td>
                        <td>${c[6] == 1 ? "Nam" : "Nữ"}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>    
</div>

<div class="row">
    <h1 class="text-center text-info">CHI TIẾT ĐIỂM SINH VIÊN</h1>
    <div class="col-mt-5 col-12 mt-3">
        <form>
            <div class="form-floating">
                <select class="form-select" id="hockinamhoc" name="hocKiNamHocId">
                    <c:forEach items="${hocKiNamHocs}" var="c">
                        <option value="${c.id}" >Học kì : ${c.hocKiId.getHocKi()} - Năm Học : ${c.namHocId.getNamHoc()}</option>
                    </c:forEach>
                </select>
                <label for="hockinamhoc" class="form-label">CHỌN HỌC KÌ - NĂM HỌC</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class='btn btn-success'>Xem</button>
            </div>
        </form>
        <table class="table">
            <thead class="table-success">
                <tr>
                    <th>Minh Chứng</th>
                    <th>Điểm sinh viên</th>
                    <th>Điểm tối đa</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th colspan="2">Điều 1: Đánh giá về ý thức học tập</th>  
                    <th>20</th>
                </tr>

                <c:forEach items="${hoatdongdieu1s}" var="c">
                    <tr>
                        <td>${c[0]}</td>
                        <td>${c[1]}</td>
                    </tr>
                </c:forEach>
                <tr class="bg-info">
                    <th>Tổng điểm điều 1</th>
                        <c:forEach items="${diemdieu1}" var="c">
                        <th colspan="2">${c[2]}</th>

                    </c:forEach>
                </tr>
                <tr>
                    <th colspan="2">Điều 2: Đánh giá về ý thức, kết quả chấp hành nội quy, quy định của nhà trường</th>  
                    <th>20</th>
                </tr>
                <c:forEach items="${hoatdongdieu2s}" var="c">
                    <tr>
                        <td>${c[0]}</td>
                        <td>${c[1]}</td>
                    </tr>
                </c:forEach>
                <tr class="bg-info">
                    <th>Tổng điểm điều 2</th>
                        <c:forEach items="${diemdieu2}" var="c">
                        <th colspan="2">${c[2]}</th>

                    </c:forEach>
                </tr>
                <tr>
                    <th colspan="2">Điều 3: Đánh giá về ý thức và kết quả tham gia các hoạt động chính trị - xã hội, văn hóa, văn nghệ, thể thao, phòng chống các tệ nạn xã hội.</th>  
                    <th>30</th>
                </tr>
                <c:forEach items="${hoatdongdieu3s}" var="c">
                    <tr>
                        <td>${c[0]}</td>
                        <td>${c[1]}</td>
                    </tr>
                </c:forEach>
                <tr class="bg-info">
                    <th>Tổng điểm điều 3</th>
                        <c:forEach items="${diemdieu3}" var="c">
                        <th colspan="2">${c[2]}</th>

                    </c:forEach>
                </tr>
                <tr>
                    <th colspan="2">Điều 4: Đánh giá về phẩm chất công dân và quan hệ với cộng đồng</th>  
                    <th>20</th>
                </tr>
                <c:forEach items="${hoatdongdieu4s}" var="c">
                    <tr>
                        <td>${c[0]}</td>
                        <td>${c[1]}</td>
                    </tr>
                </c:forEach>
                <tr class="bg-info">
                    <th>Tổng điểm điều 4</th>
                        <c:forEach items="${diemdieu4}" var="c">
                        <th colspan="2">${c[2]}</th>

                    </c:forEach>
                </tr>
                <tr>
                    <th colspan="2">Điều 5: Đặc biệt</th>  
                    <th>10</th>
                </tr>
                <c:forEach items="${hoatdongdieu5s}" var="c">
                    <tr>
                        <td>${c[0]}</td>
                        <td>${c[1]}</td>
                    </tr>
                </c:forEach>
                <tr class="bg-info">
                    <th>Tổng điểm điều 5</th>
                        <c:forEach items="${diemdieu5}" var="c">
                        <th colspan="2">${c[2]}</th>

                    </c:forEach>
                </tr>


            </tbody>
        </table>
    </div>
</div>