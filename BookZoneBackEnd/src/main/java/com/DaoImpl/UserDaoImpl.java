package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Dao.UserDao;
import com.model.User;

@Repository("userDAO")
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<User> retrieveUser() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User> listUser = query.list();
		session.close();
		return listUser;
	}

	@Transactional
	public boolean deleteUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public User getUser(int userId) 
	{
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class,userId);
		session.close();
		return user;
	}

	@Transactional
	public boolean updateUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public List<User> findByUsername(String userName)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username= :username");
		query.setParameter("username", userName);
		List<User> listUser = query.list();
		session.close();
		return listUser;
	}
}
