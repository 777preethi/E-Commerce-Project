package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.hiberConfig.hiberConfig;
import com.model.Category;

public class CategoryTest 
{
	static CategoryDao categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();		
		//SessionFactory sessionFactory = (SessionFactory)ac.getBean("hiberConfig.class");
		categoryDAO = (CategoryDao)ac.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category = new Category();
		category.setCatId(1004);
		category.setCatName("Children Books");
		category.setCatDesc("All books of Children Books type");
		assertTrue(categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = new Category();
		category.setCatId(1001);
		category.setCatName("Fiction Books");
		category.setCatDesc("All books of Fiction Books type");
		assertTrue(categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = new Category();
		category.setCatId(1004);
		assertTrue(categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory = categoryDAO.retrieveCategory();
		assertNotNull("Problem in retriving: ",listCategory);
		this.showCategoryTest(listCategory);
	}
	
	public void showCategoryTest(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category Id: "+category.getCatId());
			System.out.println("Category Name: "+category.getCatName());
			System.out.println("Category Desc: "+category.getCatDesc());
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Category category = categoryDAO.getCategory(1003);
		assertNotNull("Problem in getting: "+category);
		System.out.println("Category Id: "+category.getCatId());
		System.out.println("Category Name: "+category.getCatName());
		System.out.println("Category Desc: "+category.getCatDesc());
	}
}
