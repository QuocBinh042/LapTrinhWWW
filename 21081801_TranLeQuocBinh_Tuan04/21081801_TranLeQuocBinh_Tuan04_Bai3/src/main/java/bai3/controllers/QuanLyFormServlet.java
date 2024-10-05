package bai3.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import bai3.dao.TinTucDAO;
import bai3.dao.impl.TinTucImpl;
import bai3.utils.EntityManagerFactoryUtil;

public class QuanLyFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TinTucDAO tinTucDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.tinTucDAO = new TinTucImpl(new EntityManagerFactoryUtil().getEntityManager());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.startsWith("delete_")) {
            int id = Integer.parseInt(action.substring(7));
            tinTucDAO.deleteTinTuc(id);
        }

        request.setAttribute("danhSachTinTuc", tinTucDAO.getAllTinTuc());        
        request.getRequestDispatcher("views/TrangChu.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
