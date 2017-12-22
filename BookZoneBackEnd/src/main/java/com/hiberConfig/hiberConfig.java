package com.hiberConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class hiberConfig 
{
	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2()
	{
		System.out.println("Hibernate initiated...");
		DriverManagerDataSource dt = new DriverManagerDataSource();
		dt.setDriverClassName("org.h2.Driver");
		dt.setUrl("jdbc:h2:tcp://localhost/~/BookZoneDB");
		dt.setUsername("sa");
		dt.setPassword("");
		System.out.println("Connection established...");
		return dt;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hp = new Properties();
		hp.put("hibernate.hbm2ddl.auto", "update");
		hp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hp.put("hibernate.show_sql", "true");
		
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(getH2());
		lsfb.addProperties(hp);
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Product.class);
		lsfb.addAnnotatedClass(Cart.class);
		lsfb.addAnnotatedClass(Contact.class);
		lsfb.addAnnotatedClass(Orders.class);
		SessionFactory sessionFactory = lsfb.buildSessionFactory();
		System.out.println("Session Factory Object Created...");
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
	{
		HibernateTransactionManager tm = new HibernateTransactionManager(sessionFactory);
		return tm;
	}
}
