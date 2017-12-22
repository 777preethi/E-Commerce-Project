package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.Dao.CategoryDao;
import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

public class SupplierTest 
{
	static SupplierDao supplierDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();		
		//SessionFactory sessionFactory = (SessionFactory)ac.getBean("hiberConfig.class");
		supplierDAO = (SupplierDao)ac.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierId(102);
		supplier.setSupplierName("DC Comics");
		supplier.setSupplierAddress("Coimbatore, Tamil Nadu");
		supplier.setSupplierEmail("dccomics@gmail.com");
		assertTrue(supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierId(101);
		supplier.setSupplierName("DC Publications");
		supplier.setSupplierAddress("Coimbatore, Tamil Nadu");
		supplier.setSupplierEmail("dcpublications@gmail.com");
		assertTrue(supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierId(102);
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void retrieveSupplierTest()
	{
		List<Supplier> listSupplier = supplierDAO.retrieveSupplier();
		assertNotNull("Problem in retriving: ",listSupplier);
		this.showSupplierTest(listSupplier);
	}
	
	public void showSupplierTest(List<Supplier> listSupplier)
	{
		for(Supplier supplier:listSupplier)
		{
			System.out.println("Supplier Id: "+supplier.getSupplierId());
			System.out.println("Supplier Name: "+supplier.getSupplierName());
			System.out.println("Supplier Address: "+supplier.getSupplierAddress());
			System.out.println("Supplier Email: "+supplier.getSupplierEmail());
		}
	}
	
	@Test
	public void getCategoryTest()
	{
		Supplier supplier = supplierDAO.getSupplier(101);
		assertNotNull("Problem in getting: "+supplier);
		System.out.println("Supplier Id: "+supplier.getSupplierId());
		System.out.println("Supplier Name: "+supplier.getSupplierName());
		System.out.println("Supplier Address: "+supplier.getSupplierAddress());
		System.out.println("Supplier Email: "+supplier.getSupplierEmail());
	}
}
