package bai3.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bai3.dao.TinTucDAO;
import bai3.dao.impl.TinTucImpl;
import bai3.utils.EntityManagerFactoryUtil;

public class DanhSachTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil enf;
	private TinTucDAO tinTucDAO;

	public DanhSachTinTucServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.enf = new EntityManagerFactoryUtil();
		this.tinTucDAO = new TinTucImpl(this.enf.getEntityManager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("danhSachTinTuc", this.tinTucDAO.getAllTinTuc());
		request.setAttribute("danhmuc", this.tinTucDAO.getDanhMucId());
		request.getRequestDispatcher("views/TrangChu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
