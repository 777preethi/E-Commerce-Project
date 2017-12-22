package com.DaoImpl;

import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.model.Cart;

@Repository("cartDAO")
public class CartDaoImpl implements CartDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean insertCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean updateCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean deleteCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Cart> retrieveCart(int userId) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userid=:userId and orderStatus = 0").setInteger("userId", userId);
		List<Cart> listCart = query.list();
		session.close();
		return listCart;
	}

	public List<Cart> getCartById(int userId, int productId) 
	{
		Session session = sessionFactory.openSession();
		List<Cart> cr = null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("from Cart where userid=:userId and productId=:productId and orderStatus = 0")
					.setInteger("userId", userId)
					.setInteger("productId", productId)
					.list();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			
		}
		return cr;
	}
	
	public List<Cart> checkCartExist(int userId, int productId)
	{
		Session session = sessionFactory.openSession();
		List<Cart> cr = null;
		try
		{
			session.beginTransaction();
			cr = (List<Cart>)session.createQuery("from Cart where userid=:userId and productId=:productId and orderStatus = 0")
					.setInteger("userId", userId)
					.setInteger("productId", productId)
					.getResultList();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			
		}
		return cr;
	}
	
	public Cart getCart(int cartId) 
	{
		Session session = sessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class,cartId);
		session.close();
		return cart;
	}
}
