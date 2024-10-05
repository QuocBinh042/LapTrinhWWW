package bai3.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.Set;

import bai3.dao.DanhMucDAO;
import bai3.dao.TinTucDAO;
import bai3.dao.impl.DanhMucImpl;
import bai3.dao.impl.TinTucImpl;
import bai3.models.DanhMuc;
import bai3.models.TinTuc;
import bai3.utils.EntityManagerFactoryUtil;

public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil enf;
	private TinTucDAO tinTucDAO;

	public TinTucFormServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.enf = new EntityManagerFactoryUtil();
		this.tinTucDAO = new TinTucImpl(this.enf.getEntityManager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tieuDe = request.getParameter("tieude");
		String lienKet = request.getParameter("lienket");
		String noiDung = request.getParameter("noidung");
		int danhMuc = Integer.parseInt(request.getParameter("danhmuc"));
		DanhMuc dm = new DanhMuc(danhMuc, "", "", "");
		TinTuc tinTuc = new TinTuc(tieuDe, noiDung, lienKet, dm);

		// Validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);

		if (!violations.isEmpty()) {
			StringBuilder errorMessage = new StringBuilder();
			for (ConstraintViolation<TinTuc> violation : violations) {
				System.out.println(violation.getMessage());
			}
			request.getRequestDispatcher("views/TrangChu.jsp").forward(request, response);
		} else {
			this.tinTucDAO.addTinTuc(tinTuc);
			response.sendRedirect("DanhSachTinTucServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
