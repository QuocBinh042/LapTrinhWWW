package bai4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bai4.beans.CartBean;

@WebServlet(urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CartController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action != null) {
			switch (action) {
			case "add":							
				addToCart(request, session);
				session.setAttribute("successMessage", "Product added to cart successfully!");
				break;
			case "update":
				updateCart(request, session);
				session.setAttribute("successMessage", "Cart updated successfully!");
				break;
			case "delete":
				deleteCart(request, session);
				session.setAttribute("successMessage", "Item removed from cart successfully!");
				break;
			}
		}
		response.sendRedirect("ShoppingCart.jsp");
	}

	protected void addToCart(HttpServletRequest request, HttpSession session) {
        String modelNo = request.getParameter("modelNo");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        
        CartBean cartBean = (CartBean) session.getAttribute("cart");

        if (cartBean == null) {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }        
        cartBean.addCartItem(modelNo, description, price, quantity);
        session.setAttribute("cart", cartBean);
       
        
    }

    protected void updateCart(HttpServletRequest request, HttpSession session) {
        String index = request.getParameter("itemIndex");
        String quantity = request.getParameter("quantity");

        CartBean cartBean = (CartBean) session.getAttribute("cart");

        if (cartBean != null) {
            cartBean.updateCartItem(index, quantity);
        }
    }

    protected void deleteCart(HttpServletRequest request, HttpSession session) {
        String index = request.getParameter("itemIndex");

        CartBean cartBean = (CartBean) session.getAttribute("cart");

        if (cartBean != null) {
            cartBean.deleteCartItem(index);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
}
