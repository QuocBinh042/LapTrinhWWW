package bai4.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bai4.beans.Product;
import bai4.beans.ProductList;

@WebServlet(urlPatterns = {"/ModelList" })
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> list = new ArrayList<Product>();
	
	public ProductListController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		list = ProductList.queryProducts();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {				
		request.setAttribute("ds", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ModelList.jsp");
		rd.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
