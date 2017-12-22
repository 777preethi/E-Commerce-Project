package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Dao.OrderDao;
import com.model.Cart;
import com.model.Orders;

@Repository("orderDAO")
public class OrderDaoImpl implements OrderDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean createOrder(Orders order) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Cart> completedOrders(int userId) 
	{
		Session session = sessionFactory.openSession();
		List<Cart> completedOrdersList = null;
		try
		{
			session.beginTransaction();
			completedOrdersList = (List<Cart>)session.createQuery("from Cart where userid=:userId and orderStatus = 1")
					.setInteger("userId", userId)
					.getResultList();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			
		}
		return completedOrdersList;
	}
}
