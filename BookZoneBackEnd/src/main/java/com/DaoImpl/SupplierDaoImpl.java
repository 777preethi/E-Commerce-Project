package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Supplier> retrieveSupplier() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSupplier = query.list();
		session.close();
		return listSupplier;
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) 
	{
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
