<%@ page import="bai3.models.TinTuc" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý tin tức</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body class="container">
    <h2 class="mt-4">Quản lý tin tức</h2>
    
    <!-- Check if the news list is empty -->
    <c:choose>
        <c:when test="${empty danhSachTinTuc}">
            <p>Không có tin tức nào để hiển thị.</p>
        </c:when>
        <c:otherwise>
            <!-- Display the news table -->
            <table class="table table-bordered mt-4">
                <thead>
                    <tr>
                        <th>Mã tin tức</th>
                		<th>Tiêu đề</th>
                		<th>Nội dung</th>
                		<th>Liên kết</th>
                		<th>Danh mục</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the list of news items -->
                    <c:forEach var="tinTuc" items="${danhSachTinTuc}">
                        <tr>
                            <td><c:out value="${tinTuc.maTT}" /></td>
                            <td><c:out value="${tinTuc.tieuDe}" /></td>
                            <td><c:out value="${tinTuc.noiDungTT}" /></td>
                            <td>
                            	<a href="${tinTuc.lienKet}" class="text-blue-500 underline" target="_blank">
                            		<c:out value="${tinTuc.lienKet}" />
    							</a>
    						</td>
                            <td><c:out value="${tinTuc.danhMuc.tenDanhMuc}" /></td>
                            <td>
                                <!-- Create a delete link that sends the delete action and news ID to the servlet -->
                                <a href="${pageContext.request.contextPath}/QuanLyFormServlet?action=delete_${tinTuc.maTT}" 
                                   class="btn btn-danger" 
                                   onclick="return confirm('Bạn có chắc muốn xóa tin tức này?');">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
