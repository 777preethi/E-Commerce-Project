package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.CategoryDao;
import com.Dao.OrderDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDao;
import com.Dao.CartDao;
import com.model.Cart;
import com.model.Orders;
import com.model.Product;
import com.model.User;

@Controller
@Scope("session")
public class cartController 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderDao orderDao;
	
	@RequestMapping(value="/MyCart", method=RequestMethod.GET)
	public String myCart(HttpSession session,Model m)
	{
		String pageTitle = "BookZone - My Cart";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		m.addAttribute("userCartList", userCartList);
		return "cart";
	}
	
	@RequestMapping(value="/AddCart", method=RequestMethod.POST)
	public String addCart(HttpServletRequest request, Model m, HttpSession session)
	{
		String pageTitle = "BookZone - My Cart";
		m.addAttribute("pageTitle", pageTitle);
		int cartId = 0;
		int orderStatus = 0;
		int userId = Integer.valueOf(request.getParameter("cartUserId"));
		int productId = Integer.valueOf(request.getParameter("cartProductId"));
		int quantity = Integer.valueOf(request.getParameter("cartQuantity"));
		Product p = productDao.getProduct(productId);
		double price = p.getPrice();
		User u = userDao.getUser(userId);
		List<Cart> cartExist = cartDao.checkCartExist(userId, productId);
		if(cartExist.isEmpty())
		{
			Cart cm = new Cart();
			cm.setUser(u);
			cm.setProduct(p);
			cm.setCartQuantity(quantity);
			cm.setCartPrice(price);
			cm.setOrderStatus(orderStatus);
			cartDao.insertCart(cm);
		}
		else
		{
			List<Cart> cartList = cartDao.getCartById(userId, productId);
			for(Cart c:cartList)
			{
				cartId = c.getCartId();
				Cart cm = new Cart();
				cm.setCartId(cartId);
				cm.setUser(u);
				cm.setProduct(p);
				cm.setCartQuantity(quantity);
				cm.setCartPrice(price);
				cm.setOrderStatus(orderStatus);
				cartDao.updateCart(cm);
			}
		}
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		int cartCount = 0;
		for(Cart cl:userCartList)
		{
			cartCount++;
		}
		session.setAttribute("cartCount", cartCount);
		m.addAttribute("userCartList", userCartList);
		return "cart";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String shippingDetails(HttpSession session, Model m)
	{
		String pageTitle = "BookZone - Shipping Details";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		User userDetails = userDao.getUser(userId);
		m.addAttribute(userDetails);
		String userName = userDetails.getName();
		m.addAttribute("userName",userName);
		String userPhone = userDetails.getPhone();
		m.addAttribute("userPhone",userPhone);
		String userEmail = userDetails.getEmail();
		m.addAttribute("userEmail",userEmail);
		String userAddress = userDetails.getAddress();
		m.addAttribute("userAddress",userAddress);
		String userCountry = userDetails.getCountry();
		m.addAttribute("userCountry",userCountry);
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		m.addAttribute("userCartList", userCartList);
		return "shipping";
	}
	
	@RequestMapping(value="/invoice", method=RequestMethod.POST)
	public String invoiceDetails(HttpServletRequest request, HttpSession session, Model m)
	{
		String pageTitle = "BookZone - Invoice";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		User u = userDao.getUser(userId);
		String paymentMode = String.valueOf(request.getParameter("paymentMode"));
		double orderAmount = Double.valueOf(request.getParameter("orderAmount"));
		Orders os = new Orders();
		os.setUser(u);
		os.setOrderDate(new Date());
		os.setPaymentMode(paymentMode);
		os.setOrderAmount(orderAmount);
		orderDao.createOrder(os);	
		int orderId = os.getOrderId();
		Date orderDate = os.getOrderDate();
		String userName = os.getUser().getName();
		String userPhone = os.getUser().getPhone();
		String userPMode = os.getPaymentMode();
		double userAmount = os.getOrderAmount();
		m.addAttribute("orderId", orderId);
		m.addAttribute("orderDate", orderDate);
		m.addAttribute("userName", userName);
		m.addAttribute("userPhone", userPhone);
		m.addAttribute("userPMode", userPMode);
		m.addAttribute("userAmount", userAmount);
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		m.addAttribute("userCartList", userCartList);
		return "invoice";
	}
	
	@RequestMapping(value="/ack", method=RequestMethod.GET)
	public String ackDetails(HttpSession session, Model m)
	{
		String pageTitle = "BookZone - Thank You";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		for(Cart c:userCartList)
		{
			int orderStatus = 1;
			int cartId = c.getCartId();
			int cartquantity = c.getCartQuantity();
			double cartPrice = c.getCartPrice();
			Product product = c.getProduct();
			User user = c.getUser();
		
			Cart cm = new Cart();
			cm.setCartId(cartId);
			cm.setOrderStatus(orderStatus);
			cm.setCartPrice(cartPrice);
			cm.setCartQuantity(cartquantity);
			cm.setProduct(product);
			cm.setUser(user);
			cartDao.updateCart(cm);			

			int productId = c.getProduct().getProductId();
			String productName = c.getProduct().getProductName();
			String productDesc = c.getProduct().getProductDesc();
			int catId = c.getProduct().getCatId();
			int supplierId = c.getProduct().getSupplierId();
			int productStock = c.getProduct().getStock();
			int stockUpdate = (productStock - cartquantity);
			int productPrice = c.getProduct().getPrice();
			Product updateP = new Product();
			updateP.setProductId(productId);
			updateP.setProductName(productName);
			updateP.setProductDesc(productDesc);
			updateP.setCatId(catId);
			updateP.setSupplierId(supplierId);
			updateP.setPrice(productPrice);
			updateP.setStock(stockUpdate);
			productDao.updateProduct(updateP);
		}
		return "acknowledgement";
	}
	
	@RequestMapping(value="/myOrders", method=RequestMethod.GET)
	public String myOrderList(HttpSession session, Model m)
	{
		String pageTitle = "BookZone - Thank You";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		List<Cart> completedOrdersList = orderDao.completedOrders(userId);
		m.addAttribute("completedOrdersList", completedOrdersList);
		return "myOrders";
	}
	
	@RequestMapping(value="/deleteCart/{cartId}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("cartId")int cartId, HttpSession session, Model m)
	{
		String pageTitle = "BookZone - My Cart";
		m.addAttribute("pageTitle", pageTitle);
		Cart cart = cartDao.getCart(cartId);
		cartDao.deleteCart(cart);
		int userId = (Integer)session.getAttribute("userId");
		List<Cart> userCartList = cartDao.retrieveCart(userId);
		int cartCount = 0;
		for(Cart cl:userCartList)
		{
			cartCount++;
		}
		session.setAttribute("cartCount", cartCount);
		m.addAttribute("userCartList", userCartList);
		return "cart";
	}
}
