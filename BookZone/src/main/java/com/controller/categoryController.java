package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Dao.CategoryDao;
import com.model.Category;

@Controller
@Scope("session")
public class categoryController 
{
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/admin/category", method=RequestMethod.GET)
	public String showCategory(Model m)
	{
		String pageTitle = "BookZone - Category";
		m.addAttribute("pageTitle", pageTitle);
		Category category = new Category();
		m.addAttribute(category);
		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		return "category";
	}
	
	@RequestMapping(value="/admin/AddCategory", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult, Model m, HttpSession session)
	{
		if (bindingResult.hasErrors()) 
		{
			String pageTitle = "BookZone - Category";
			m.addAttribute("pageTitle", pageTitle);
			Category category1 = new Category();
			m.addAttribute(category1);
			List<Category> listCategory = categoryDao.retrieveCategory();
			m.addAttribute("categoryList",listCategory);
			return "category";
		}
		String pageTitle = "BookZone - Category";
		m.addAttribute("pageTitle", pageTitle);
		categoryDao.addCategory(category);
		List<Category> listCategory = categoryDao.retrieveCategory();
		int categoryCount = 0;
		for(Category catL:listCategory)
		{
			categoryCount++;
		}
		session.setAttribute("categoryCount", categoryCount);
		m.addAttribute("categoryList",listCategory);
		Category category1 = new Category();
		m.addAttribute(category1);
		return "category";
	}
	
	@RequestMapping(value="/admin/updateCategory/{catId}", method=RequestMethod.GET)
	public String updateCategory(@PathVariable("catId")int catId, Model m)
	{
		String pageTitle = "BookZone - Category Update";
		m.addAttribute("pageTitle", pageTitle);
		Category category = categoryDao.getCategory(catId);
		m.addAttribute(category);
		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		return "updateCategory";
	}
	
	@RequestMapping(value="/admin/UpdateCategory", method=RequestMethod.POST)
	public String updateMyCategory(@ModelAttribute("category")Category category, Model m)
	{
		String pageTitle = "BookZone - Category";
		m.addAttribute("pageTitle", pageTitle);
		categoryDao.updateCategory(category);
		Category category1 = new Category();
		m.addAttribute(category1);
		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		return "category";
	}
	
	@RequestMapping(value="/admin/deleteCategory/{catId}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("catId")int catId, Model m, HttpSession session)
	{
		String pageTitle = "BookZone - Category";
		m.addAttribute("pageTitle", pageTitle);
		Category category = categoryDao.getCategory(catId);
		categoryDao.deleteCategory(category);
		List<Category> listCategory = categoryDao.retrieveCategory();
		int categoryCount = 0;
		for(Category catL:listCategory)
		{
			categoryCount++;
		}
		session.setAttribute("categoryCount", categoryCount);
		m.addAttribute("categoryList",listCategory);
		Category category1 = new Category();
		m.addAttribute(category1);
		return "category";
	}	
	
	@RequestMapping(value="/admin/viewCategory/{catId}", method=RequestMethod.GET)
	public String viewCategory(@PathVariable("catId")int catId, Model m)
	{
		String pageTitle = "BookZone - Category Detail";
		m.addAttribute("pageTitle", pageTitle);
		Category category = categoryDao.getCategory(catId);
		m.addAttribute(category);
		return "categoryDetail";
	}
}
