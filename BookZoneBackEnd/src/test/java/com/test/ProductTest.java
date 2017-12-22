package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.Dao.ProductDao;
import com.model.Category;
import com.model.Product;

public class ProductTest 
{
	static ProductDao productDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();		
		//SessionFactory sessionFactory = (SessionFactory)ac.getBean("hiberConfig.class");
		productDAO = (ProductDao)ac.getBean("productDAO");
	}
	
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("A Game Of Thrones");
		product.setProductDesc("Story Book");
		product.setPrice(655);
		product.setStock(3);
		product.setCatId(1001);
		product.setSupplierId(101);
		assertTrue(productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = new Product();
		product.setProductId(14);
		product.setProductName("Test Product Image7");
		product.setProductDesc("Test Product Image7 Description");
		product.setPrice(250);
		product.setStock(10);
		product.setCatId(1001);
		product.setSupplierId(102);
		product.setImageName("14.jpg");
		assertTrue(productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = new Product();
		product.setProductId(1);
		assertTrue(productDAO.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void retrieveProductTest()
	{
		List<Product> listProduct = productDAO.retrieveProduct();
		assertNotNull("Problem in retriving: ",listProduct);
		this.showProductTest(listProduct);
	}
	
	public void showProductTest(List<Product> listProduct)
	{
		for(Product product:listProduct)
		{
			System.out.println("Product Id: "+product.getProductId());
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Product Desc: "+product.getProductDesc());
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Product product = productDAO.getProduct(2);
		assertNotNull("Problem in getting: "+product);
		System.out.println("Product Id: "+product.getProductId());
		System.out.println("Product Name: "+product.getProductName());
		System.out.println("Product Desc: "+product.getProductDesc());
	}
}
