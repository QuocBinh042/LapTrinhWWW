package bai2.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import bai2.dao.ProductDAO;
import bai2.dao.impl.ProductImpl;
import bai2.models.Product;
import bai2.utils.EntityManagerFactoryUtil;

@WebServlet(urlPatterns = {"/ModelList"})
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityManagerFactoryUtil enf;
    private ProductDAO productDAO;

    public ProductListController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.enf = new EntityManagerFactoryUtil();
        productDAO = new ProductImpl(this.enf.getEm()); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	if (productDAO.isDatabaseEmpty()) {
    		productDAO.insertInitialData();
    	}
        List<Product> list = productDAO.getAllProducts();
        
        request.setAttribute("ds", list);  
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ModelList.jsp");
        rd.forward(request, response);  
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
