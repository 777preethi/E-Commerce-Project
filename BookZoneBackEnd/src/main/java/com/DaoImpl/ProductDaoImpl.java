package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.model.Category;
import com.model.Product;

@Repository("productDAO")
public class ProductDaoImpl implements ProductDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Product> retrieveProduct() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listProduct = query.list();
		session.close();
		return listProduct;
	}

	public Product getProduct(int productId) 
	{
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class,productId);
		session.close();
		return product;
	}
	
	public List<Product> getCategoryProducts(int categoryId) 	
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where catId="+categoryId);
		List<Product> listProduct = query.list();
		session.close();
		return listProduct;
	}

	public List<Product> retrieveLatestProducts() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product P ORDER BY P.productId DESC");
		query.setMaxResults(6);
		List<Product> latestProduct = query.list();
		session.close();
		return latestProduct;
	}
}
