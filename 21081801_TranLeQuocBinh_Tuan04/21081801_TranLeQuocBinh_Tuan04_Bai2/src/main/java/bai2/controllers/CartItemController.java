package bai2.controllers;

import bai2.dao.CartItemDAO;
import bai2.dao.impl.CartItemImpl;
import bai2.models.CartItem;
import bai2.utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/CartController"})
public class CartItemController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityManagerFactoryUtil enf;
    private CartItemDAO cartItemDAO;

    public CartItemController() {
        super();
        this.enf = new EntityManagerFactoryUtil();
        this.cartItemDAO = new CartItemImpl(this.enf.getEm());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addToCart(request);
                    request.setAttribute("successMessage", "Product added to cart successfully!");
                    break;
                case "update":
                    updateCart(request);
                    request.setAttribute("successMessage", "Cart updated successfully!");
                    break;
                case "delete":
                    deleteCart(request);
                    request.setAttribute("successMessage", "Item removed from cart successfully!");
                    break;
            }
        }
        doGet(request, response);
    }

    protected void addToCart(HttpServletRequest request) {
        String partNumber = request.getParameter("modelNo");
        String description = request.getParameter("description");
        double unitCost = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double totalCost = unitCost * quantity;
        CartItem cartItem = new CartItem(0, partNumber, description, unitCost, quantity, totalCost);

        cartItemDAO.addCartItem(cartItem);
    }

    protected void updateCart(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("itemIndex"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartItem cartItem = cartItemDAO.getCartItemById(id);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItem.setTotalCost(cartItem.getUnitCost() * quantity);
            cartItemDAO.updateCartItem(cartItem);
        }
    }

    protected void deleteCart(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("itemIndex"));
        cartItemDAO.deleteCartItem(id);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<CartItem> cartItems = cartItemDAO.getAllCartItems();
    	double cartTotal = cartItemDAO.getTotalCartValue();
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("cartTotal", cartTotal);
        request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
    }
    
    @Override
    public void destroy() {
        if (enf != null) {
            enf.close(); 
        }
        super.destroy();
    }

}