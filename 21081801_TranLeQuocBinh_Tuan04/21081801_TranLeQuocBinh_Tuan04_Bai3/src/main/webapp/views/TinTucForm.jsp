<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <script>
        function validateForm() {
            const lienKet = document.getElementById("link").value;
            const noiDung = document.getElementById("content").value;
            // Kiểm tra liên kết
            const lienKetRegex ='^http://.*';
            if (!lienKetRegex.test(lienKet)) {
                alert("Liên kết phải bắt đầu bằng 'http://'.");
                return false;
            }
            // Kiểm tra nội dung không quá 255 ký tự
            if (noiDung.length > 255) {
                alert("Nội dung không được quá 255 ký tự.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body class="container">    
    <form action="TinTucFormServlet" method="POST" onsubmit="return validateForm()">
        <div class="mb-3">
            <label for="title" class="form-label">Tiêu đề:</label>
            <input type="text" id="title" name="tieude" required class="form-control">
        </div>
        <div class="mb-3">
            <label for="link" class="form-label">Liên kết:</label>
            <input type="text" id="link" name="lienket" required class="form-control">
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Nội dung:</label>
            <textarea id="content" name="noidung" required class="form-control" rows="5"></textarea>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Danh mục:</label>
            <select id="category" name="danhmuc" required class="form-select">
              <c:choose>
                    <c:when test="${empty requestScope.danhmuc}">
                        <option value="">Không có danh mục nào để hiển thị</option>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="id" items="${requestScope.danhmuc}">
                            <option value="${id}">${id}</option>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm tin tức</button>
    </form>
</body>
</html>
 