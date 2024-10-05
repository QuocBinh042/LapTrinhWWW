<%@page import="bai3.models.TinTuc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h2 class="text-bg-light">Danh sách tin tức</h2>
<%
	List<TinTuc> danhSachTinTuc = (List<TinTuc>) request.getAttribute("danhSachTinTuc");
	if (danhSachTinTuc != null && !danhSachTinTuc.isEmpty()){
%>		
	<table class="table">
        <thead>
            <tr>
                <th>Mã tin tức</th>
                <th>Tiêu đề</th>
                <th>Nội dung</th>
                <th>Liên kết</th>
                <th>Danh mục</th>
            </tr>
        </thead>
        <tbody>
        	<% for (TinTuc tinTuc: danhSachTinTuc){%>
        	<tr>
                <th><%= tinTuc.getMaTT()%></th>
                <th><%= tinTuc.getTieuDe() %></th>
                <th><%= tinTuc.getNoiDungTT() %></th>
                <th> <a href="<%= tinTuc.getLienKet() %>" target="_blank"><%= tinTuc.getLienKet() %></a></th>
                <th><%= tinTuc.getDanhMuc().getTenDanhMuc() %></th>
            </tr>
        	<%} %>
            
        </tbody>
    </table>
	<%} else {%>
	<p>Không có tin tức</p>
	<%} %>
	
	
