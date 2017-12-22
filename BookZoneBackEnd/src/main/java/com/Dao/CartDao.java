package com.Dao;

import java.util.List;
import com.model.Cart;

public interface CartDao 
{
	public boolean insertCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> retrieveCart(int userId);
	public List<Cart> getCartById(int userId, int productId);
	public List<Cart> checkCartExist(int userId, int productId);
	public Cart getCart(int cartId);
}
