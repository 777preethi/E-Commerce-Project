package com.Dao;

import java.util.List;
import com.model.Category;

public interface CategoryDao 
{
	public boolean addCategory(Category category);
	public List<Category> retrieveCategory();
	public boolean deleteCategory(Category category);
	public Category getCategory(int catId);
	public boolean updateCategory(Category category);
}
