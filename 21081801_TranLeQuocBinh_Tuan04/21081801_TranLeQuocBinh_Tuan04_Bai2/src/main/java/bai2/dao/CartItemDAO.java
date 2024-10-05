package bai2.dao;

import bai2.models.CartItem;
import java.util.List;

public interface CartItemDAO {
	void addCartItem(CartItem cartItem);

	void updateCartItem(CartItem cartItem);

	void deleteCartItem(int id);

	CartItem getCartItemById(int id);

	List<CartItem> getAllCartItems();

	double getTotalCartValue();
}
