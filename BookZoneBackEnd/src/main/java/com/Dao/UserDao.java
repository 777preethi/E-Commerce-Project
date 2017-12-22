package com.Dao;

import java.util.List;
import com.model.User;

public interface UserDao 
{
	public boolean addUser(User user);
	public List<User> retrieveUser();
	public boolean deleteUser(User user);
	public User getUser(int userId);
	public boolean updateUser(User user);
	public List<User> findByUsername(String useranme);
}
