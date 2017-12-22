package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.Dao.UserDao;
import com.hiberConfig.hiberConfig;
import com.model.Category;
import com.model.User;

public class UserTest 
{	
	static UserDao userDAO;	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();		
		//SessionFactory sessionFactory = (SessionFactory)ac.getBean("hiberConfig.class");
		userDAO = (UserDao)ac.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void addUserTest()
	{
		User user = new User();
		user.setEmail("sagar@gmail.com");
		user.setName("Sagar");
		user.setUsername("sagar");
		user.setPassword("123456");
		user.setRole("ROLE_USER");
		user.setAddress("Kavundampalayam,Coimbatore,India");
		user.setCountry("India");
		user.setEnabled(true);
		user.setPhone("9848341478");		
		assertTrue(userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user = new User();
		user.setEmail("sagar@gmail.com");
		user.setName("Sagar");
		user.setUsername("sagar");
		user.setPassword("123456");
		user.setRole("ROLE_USER");
		user.setAddress("Kavundampalayam,Coimbatore,India");
		user.setCountry("India");
		user.setEnabled(true);
		user.setPhone("9848341478");
		assertTrue(userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		User user = new User();
		user.setUserid(3);
		assertTrue(userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public void retrieveUserTest()
	{
		List<User> listUser = userDAO.retrieveUser();
		assertNotNull("Problem in retriving: ",listUser);
		this.showUserTest(listUser);
	}
	
	public void showUserTest(List<User> listUser)
	{
		for(User user:listUser)
		{
			System.out.println("User Id: "+user.getUserid());
			System.out.println("User Name: "+user.getName());
			System.out.println("User Email: "+user.getEmail());
		}
	}
	
	@Ignore
	@Test
	public void getUserTest()
	{
		User user = userDAO.getUser(23);
		assertNotNull("Problem in getting: "+user);
		System.out.println("User Id: "+user.getUserid());
		System.out.println("User Name: "+user.getName());
		System.out.println("User Email: "+user.getEmail());
	}
}
