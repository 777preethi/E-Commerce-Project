package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.BookZone.exception.ProductNotFoundException;
import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.model.Cart;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Controller
@Scope("session")
public class productController 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/admin/product", method=RequestMethod.GET)
	public String showProduct(Model m)
	{
		String pageTitle = "BookZone - Product";
		m.addAttribute("pageTitle", pageTitle);
		Product product = new Product();
		m.addAttribute(product);
		List<Product> listProduct = productDao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "product";
	}
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listCategories = categoryDao.retrieveCategory();
		LinkedHashMap<Integer,String> categoriesList = new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			categoriesList.put(category.getCatId(), category.getCatName());
		}
		return categoriesList;
	}
	
	public LinkedHashMap<Integer,String> getSuppliers()
	{
		List<Supplier> listSuppliers = supplierDao.retrieveSupplier();
		LinkedHashMap<Integer,String> suppliersList = new LinkedHashMap<Integer,String>();
		for(Supplier supplier:listSuppliers)
		{
			suppliersList.put(supplier.getSupplierId(), supplier.getSupplierName());
		}
		return suppliersList;
	}
	
	@RequestMapping(value="/admin/AddProduct", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, HttpServletRequest request, @RequestParam("pimage")MultipartFile fileDetail, Model m, HttpSession session)
	{
		if (bindingResult.hasErrors()) 
		{
			String pageTitle = "BookZone - Product";
			m.addAttribute("pageTitle", pageTitle);
			Product product1 = new Product();
			m.addAttribute(product1);
			List<Product> listProduct = productDao.retrieveProduct();
			m.addAttribute("productList",listProduct);
			m.addAttribute("categoryList",this.getCategories());
			m.addAttribute("supplierList",this.getSuppliers());
			return "product";
		}
		String pageTitle = "BookZone - Product";
		m.addAttribute("pageTitle", pageTitle);
		productDao.addProduct(product);
		String insertProductId = String.valueOf(product.getProductId());
		
		String path = "D:\\EclipseProjects\\BookZone\\src\\main\\webapp\\resources\\images\\products\\";
		String orginalFilename = fileDetail.getOriginalFilename();		
		String totalFilePath = path+insertProductId+".jpg";
		File productImage = new File(totalFilePath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[] = fileDetail.getBytes();
				FileOutputStream fos = new FileOutputStream(productImage);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBuffer);;
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("error", e.getMessage());
			}
		}
		else
		{
			m.addAttribute("error", "Problem in file uploading.");
		}
		List<Product> listProduct = productDao.retrieveProduct();
		int productCount = 0;
		for(Product pl:listProduct)
		{
			productCount++;
		}
		session.setAttribute("productCount", productCount);
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		Product product1 = new Product();
		m.addAttribute(product1);
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value="/admin/updateProduct/{productId}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable("productId")int productId, Model m)
	{
		String pageTitle = "BookZone - Product Update";
		m.addAttribute("pageTitle", pageTitle);
		Product product = productDao.getProduct(productId);
		m.addAttribute(product);
		List<Product> listProduct = productDao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "updateProduct";
	}
	
	@RequestMapping(value="/admin/UpdateProduct", method=RequestMethod.POST)
	public String updateMyProduct(@ModelAttribute("product")Product product, @RequestParam("pimage")MultipartFile fileDetail, Model m)
	{
		String pageTitle = "BookZone - Product";
		m.addAttribute("pageTitle", pageTitle);
		productDao.updateProduct(product);
		Product product1 = new Product();
		m.addAttribute(product1);
		String path = "D:\\EclipseProjects\\BookZone\\src\\main\\webapp\\resources\\images\\products\\";
		String totalFilePath = path+String.valueOf(product.getProductId())+".jpg";
		File productImage = new File(totalFilePath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[] = fileDetail.getBytes();
				FileOutputStream fos = new FileOutputStream(productImage);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBuffer);;
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("error", e.getMessage());
			}
		}
		else
		{
			m.addAttribute("error", "Problem in file uploading.");
		}
		List<Product> listProduct = productDao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "product";
	}
	
	@RequestMapping(value="/admin/deleteProduct/{productId}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId")int productId, Model m, HttpSession session)
	{
		String pageTitle = "BookZone - Product";
		m.addAttribute("pageTitle", pageTitle);
		Product product = productDao.getProduct(productId);
		productDao.deleteProduct(product);
		List<Product> listProduct = productDao.retrieveProduct();
		int productCount = 0;
		for(Product pl:listProduct)
		{
			productCount++;
		}
		session.setAttribute("productCount", productCount);
		m.addAttribute("productList",listProduct);
		Product product1 = new Product();
		m.addAttribute(product1);
		return "product";
	}
	
	@RequestMapping(value="/viewProduct/{productId}", method=RequestMethod.GET)
	public String viewProduct(@PathVariable("productId")int productId, Model m) throws ProductNotFoundException
	{
		String pageTitle = "BookZone - Product detail";
		m.addAttribute("pageTitle", pageTitle);
		Product product = productDao.getProduct(productId);
		if(product == null) throw new ProductNotFoundException();
		m.addAttribute(product);
		int catId = product.getCatId();
		Category category = categoryDao.getCategory(catId);
		m.addAttribute(category);
		int supplierId = product.getSupplierId();
		Supplier supplier = supplierDao.getSupplier(supplierId);
		m.addAttribute(supplier);
		Cart cart = new Cart();
		m.addAttribute(cart);
		return "productDetail";
	}
	
	@RequestMapping(value = "/categoryProducts", method=RequestMethod.POST)
	public String categoryProducts(HttpServletRequest request, HttpSession session, Model m)
	{ 
		int catId = 0;
		catId = Integer.valueOf(request.getParameter("catId"));
		String pageTitle = "BookZone - Categorized Products";
		m.addAttribute("pageTitle", pageTitle);
		Product product1 = new Product();
		m.addAttribute(product1);
		Category category = new Category();
		m.addAttribute(category);
		if(catId == 0)
		{
			List<Product> listProduct = productDao.retrieveProduct();		
			m.addAttribute("productList",listProduct);
		}
		else
		{
			List<Product> listProduct = productDao.getCategoryProducts(catId);		
			m.addAttribute("productList",listProduct);
		}
		m.addAttribute("catId",catId);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "categoryProduct";
	}
	
	@RequestMapping(value = "/productList", method=RequestMethod.GET)
	public String productList(Model m)
	{ 
		String pageTitle = "BookZone - Products";
		m.addAttribute("pageTitle", pageTitle);
		int catId = 0;
		m.addAttribute("catId",catId);
		Product product = new Product();
		m.addAttribute(product);
		Category category = new Category();
		m.addAttribute(category);
		List<Product> listProduct = productDao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "categoryProduct";
	}
}
