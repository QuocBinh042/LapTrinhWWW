<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid ">
        <img src="<%= request.getContextPath() %>/image/news-header.png" class="w-100">
    </div>

    <nav class="nav justify-content-center bg-light">
        <a class="nav-link active" href="?page=list">Danh sách tin tức</a>
        <a class="nav-link active" href="?page=add">Thêm tin tức mới</a>
        <a class="nav-link active" href="?page=manage">Chức năng quản lý</a>
    </nav>


    <div class="container mt-4">
        <div class="content-area" style="min-height: 400px;">
			<%
        		String pages = request.getParameter("page");
        		if (pages == null) {
            		pages = "list";
        		}
        		switch(pages) {
            		case "list":
                		%><jsp:include page="DanhSachTinTuc.jsp" /><%
                		break;
            		case "add":
                		%><%@ include file="TinTucForm.jsp" %><%
                		break;
            		case "manage":
                		%><%@ include file="QuanLyForm.jsp" %><%
                		break;
            		default:
        		}
        	%>		        	
        </div>
    </div>

    <footer class="footer mt-4 text-lg-center bg-light">
        Trần Lê Quốc Bình - 21081801 - DHKTPM17ATT
    </footer>

</body>

</html>