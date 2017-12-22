package com.Dao;

import java.util.List;
import com.model.Cart;
import com.model.Orders;

public interface OrderDao 
{
	public boolean createOrder(Orders orders);
	public List<Cart> completedOrders(int userId);
}
