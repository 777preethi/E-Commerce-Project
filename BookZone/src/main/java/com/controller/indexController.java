package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Dao.CartDao;
import com.Dao.CategoryDao;
import com.Dao.ContactDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDao;
import com.model.Cart;
import com.model.Category;
import com.model.Contact;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Controller
@Scope("session")
public class indexController 
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ContactDao contactDao;
	
	@RequestMapping("/")
	public String index(Model m)
	{
		String pageTitle = "BookZone - Home";
		m.addAttribute("pageTitle", pageTitle);
		List<Product> latestProductList = productDao.retrieveLatestProducts();
		m.addAttribute("latestProductList", latestProductList);
		return "index";
	}
	
	@RequestMapping("/goToLogin")
	public String goToLogin(Model m)
	{
		String pageTitle = "BookZone - Login";
		m.addAttribute("pageTitle", pageTitle);
		User user = new User();
		m.addAttribute(user);
		return "login";
	}
	
	@RequestMapping("/userLogged")
	public String userLogged(Model m, HttpSession session)
	{
		String pageTitle = "BookZone - Home";
		m.addAttribute("pageTitle", pageTitle);
		
		String roleName=null;
		boolean loggedIn=false;
		int userId=0;
		String userName = null;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		session.setAttribute("username", loggedUsername);
		Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>)auth.getAuthorities();
		for(GrantedAuthority role:auths)
		{
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn = true;
				roleName = "admin";
			}
			else
			{
				loggedIn = true;
				roleName = "user";
			}
		}
		List<User> userList = userDao.findByUsername(loggedUsername);
		for(User u:userList)
		{
			userId = u.getUserid();
			userName = u.getUsername();
		}
		session.setAttribute("userId", userId);
		session.setAttribute("userName", userName);
		session.setAttribute("loggedIn", loggedIn);
		session.setAttribute("roleName", roleName);
		List<Cart> cartList = cartDao.retrieveCart(userId);
		int cartCount = 0;
		for(Cart cl:cartList)
		{
			cartCount++;
		}
		session.setAttribute("cartCount", cartCount);
		List<Category> categoryList = categoryDao.retrieveCategory();
		int categoryCount = 0;
		for(Category catL:categoryList)
		{
			categoryCount++;
		}
		session.setAttribute("categoryCount", categoryCount);
		List<Supplier> supplierList = supplierDao.retrieveSupplier();
		int supplierCount = 0;
		for(Supplier sl:supplierList)
		{
			supplierCount++;
		}
		session.setAttribute("supplierCount", supplierCount);
		List<Product> productList = productDao.retrieveProduct();
		int productCount = 0;
		for(Product pl:productList)
		{
			productCount++;
		}
		session.setAttribute("productCount", productCount);
		List<Contact> contactList = contactDao.retrieveContact();
		int contactCount = 0;
		for(Contact conl:contactList)
		{
			contactCount++;
		}
		session.setAttribute("contactCount", contactCount);
		
		return "redirect:/";
	}
	
	@RequestMapping("/error")
	public String error(Model m)
	{
		String pageTitle = "BookZone - Error";
		m.addAttribute("pageTitle", pageTitle);
		return "loginError";
	}
	
	@RequestMapping("/register")
	public String goToRegister(Model m)
	{
		String pageTitle = "BookZone - Sign Up";
		m.addAttribute("pageTitle", pageTitle);
		User user = new User();
		m.addAttribute(user);
		return "register";
	}
	
	@RequestMapping(value="AddUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("uimage")MultipartFile fileDetail, Model m)
	{
		if (bindingResult.hasErrors()) 
		{
			String pageTitle = "BookZone - Sign Up";
			m.addAttribute("pageTitle", pageTitle);
			User user1 = new User();
			m.addAttribute(user1);
			return "register";
		}
		String pageTitle = "BookZone - Home";
		m.addAttribute("pageTitle", pageTitle);
		userDao.addUser(user);
		String path = "D:\\EclipseProjects\\BookZone\\src\\main\\webapp\\resources\\images\\users\\";
		String totalFilePath = path+String.valueOf(user.getUserid())+".jpg";
		File userImage = new File(totalFilePath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[] = fileDetail.getBytes();
				FileOutputStream fos = new FileOutputStream(userImage);
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

		List<Product> latestProductList = productDao.retrieveLatestProducts();
		m.addAttribute("latestProductList", latestProductList);
		return "index";
	}
	
	@RequestMapping(value="/AboutUs", method=RequestMethod.GET)
	public String aboutUs(Model m)
	{
		String pageTitle = "BookZone - About Us";
		m.addAttribute("pageTitle", pageTitle);
		return "aboutUs";
	}
	
	@RequestMapping(value="/ContactUs", method=RequestMethod.GET)
	public String contactUs(Model m)
	{
		String pageTitle = "BookZone - Contact Us";
		m.addAttribute("pageTitle", pageTitle);
		Contact contact = new Contact();
		m.addAttribute(contact);
		return "contactUs";
	}
	
	@RequestMapping(value="/ContactFormSubmit", method=RequestMethod.POST)
	public String contactSubmit(@ModelAttribute("contact")Contact contact, Model m, HttpSession session)
	{
		String pageTitle = "BookZone - Contact Us";
		m.addAttribute("pageTitle", pageTitle);
		contactDao.addContact(contact);
		Contact contact1 = new Contact();
		m.addAttribute(contact1);
		List<Contact> contactList = contactDao.retrieveContact();
		int contactCount = 0;
		for(Contact conl:contactList)
		{
			contactCount++;
		}
		session.setAttribute("contactCount", contactCount);
		return "contactUs";
	}
	
	@RequestMapping(value = "/admin/CustomerContact", method=RequestMethod.GET)
	public String customerContact(Model m)
	{ 
		String pageTitle = "BookZone - Customer Queries";
		m.addAttribute("pageTitle", pageTitle);
		List<Contact> queriesList = contactDao.retrieveContact();
		m.addAttribute("queriesList",queriesList);
		return "customerQueries";
	}
	
	@RequestMapping(value = "/admin/viewQuery/{queryId}", method=RequestMethod.GET)
	public String queryDetail(@PathVariable("queryId")int queryId, Model m)
	{ 
		String pageTitle = "BookZone - Customer Query Detail";
		m.addAttribute("pageTitle", pageTitle);
		Contact contact = contactDao.getContact(queryId);
		m.addAttribute(contact);
		return "queryDetail";
	}
	
	@RequestMapping(value="/PrivacyPolicy", method=RequestMethod.GET)
	public String privacyPolicy(Model m)
	{
		String pageTitle = "BookZone - Privacy Policy";
		m.addAttribute("pageTitle", pageTitle);
		return "privacyPolicy";
	}
	
	@RequestMapping(value="/Help", method=RequestMethod.GET)
	public String help(Model m)
	{
		String pageTitle = "BookZone - Help";
		m.addAttribute("pageTitle", pageTitle);
		return "help";
	}
	
	@RequestMapping(value = "/viewProfile", method=RequestMethod.GET)
	public String viewProfileDetail(HttpSession session, Model m)
	{ 
		String pageTitle = "BookZone - Your Profile";
		m.addAttribute("pageTitle", pageTitle);
		
		int userId = (Integer)session.getAttribute("userId");
		m.addAttribute("userId",userId);
		User userDetails = userDao.getUser(userId);
		String userName = userDetails.getName();
		m.addAttribute("userName",userName);
		String userPhone = userDetails.getPhone();
		m.addAttribute("userPhone",userPhone);
		String userEmail = userDetails.getEmail();
		m.addAttribute("userEmail",userEmail);
		String userAddress = userDetails.getAddress();
		m.addAttribute("userAddress",userAddress);
		return "profileView";
	}
	
	@RequestMapping("/updateProfile")
	public String goToUpdateProfile(HttpSession session, Model m)
	{
		String pageTitle = "BookZone - Edit Profile";
		m.addAttribute("pageTitle", pageTitle);
		int userId = (Integer)session.getAttribute("userId");
		User user = userDao.getUser(userId);
		m.addAttribute(user);
		return "editProfile";
	}
	
	@RequestMapping(value="UpdateProfile", method=RequestMethod.POST)
	public String UpdateMyProfile(@ModelAttribute("user")User user, HttpSession session, @RequestParam("uimage")MultipartFile fileDetail, Model m)
	{
		String pageTitle = "BookZone - Your Profile";
		m.addAttribute("pageTitle", pageTitle);
		userDao.updateUser(user);
		String path = "D:\\EclipseProjects\\BookZone\\src\\main\\webapp\\resources\\images\\users\\";
		String totalFilePath = path+String.valueOf(user.getUserid())+".jpg";
		File userImage = new File(totalFilePath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[] = fileDetail.getBytes();
				FileOutputStream fos = new FileOutputStream(userImage);
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

		int userId = (Integer)session.getAttribute("userId");
		m.addAttribute("userId",userId);
		User userDetails = userDao.getUser(userId);
		String userName = userDetails.getName();
		m.addAttribute("userName",userName);
		String userPhone = userDetails.getPhone();
		m.addAttribute("userPhone",userPhone);
		String userEmail = userDetails.getEmail();
		m.addAttribute("userEmail",userEmail);
		String userAddress = userDetails.getAddress();
		m.addAttribute("userAddress",userAddress);
		return "profileView";
	}
}
