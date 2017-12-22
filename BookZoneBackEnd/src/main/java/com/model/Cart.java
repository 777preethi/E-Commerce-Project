package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int cartId;
	
	@OneToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private double cartPrice;
	private int cartQuantity;
	private int orderStatus;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
