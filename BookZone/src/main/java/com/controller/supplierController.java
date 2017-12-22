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
import com.Dao.SupplierDao;
import com.model.Supplier;

@Controller
@Scope("session")
public class supplierController 
{
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/admin/supplier", method=RequestMethod.GET)
	public String showSupplier(Model m)
	{
		String pageTitle = "BookZone - Supplier";
		m.addAttribute("pageTitle", pageTitle);
		Supplier supplier = new Supplier();
		m.addAttribute(supplier);
		List<Supplier> listSupplier = supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		return "supplier";
	}
	
	@RequestMapping(value="/admin/AddSupplier", method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult bindingResult, Model m, HttpSession session)
	{
		if (bindingResult.hasErrors()) 
		{
			String pageTitle = "BookZone - Supplier";
			m.addAttribute("pageTitle", pageTitle);
			Supplier supplier1 = new Supplier();
			m.addAttribute(supplier1);
			List<Supplier> listSupplier = supplierDao.retrieveSupplier();
			int supplierCount = 0;
			for(Supplier sl:listSupplier)
			{
				supplierCount++;
			}
			session.setAttribute("supplierCount", supplierCount);
			m.addAttribute("supplierList",listSupplier);
			return "supplier";
		}
		String pageTitle = "BookZone - Supplier";
		m.addAttribute("pageTitle", pageTitle);
		supplierDao.addSupplier(supplier);
		List<Supplier> listSupplier = supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		Supplier supplier1 = new Supplier();
		m.addAttribute(supplier1);
		return "supplier";
	}
	
	@RequestMapping(value="/admin/updateSupplier/{supplierId}", method=RequestMethod.GET)
	public String updateSupplier(@PathVariable("supplierId")int supplierId, Model m)
	{
		String pageTitle = "BookZone - Supplier Update";
		m.addAttribute("pageTitle", pageTitle);
		Supplier supplier = supplierDao.getSupplier(supplierId);
		m.addAttribute(supplier);
		List<Supplier> listSupplier = supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		return "updateSupplier";
	}
	
	@RequestMapping(value="/admin/UpdateSupplier", method=RequestMethod.POST)
	public String updateMySupplier(@ModelAttribute("supplier")Supplier supplier, Model m)
	{
		String pageTitle = "BookZone - Supplier";
		m.addAttribute("pageTitle", pageTitle);
		supplierDao.updateSupplier(supplier);
		Supplier supplier1 = new Supplier();
		m.addAttribute(supplier1);
		List<Supplier> listSupplier = supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		return "supplier";
	}
	
	@RequestMapping(value="/admin/deleteSupplier/{supplierId}", method=RequestMethod.GET)
	public String deleteSupplier(@PathVariable("supplierId")int supplierId, Model m, HttpSession session)
	{
		String pageTitle = "BookZone - Supplier";
		m.addAttribute("pageTitle", pageTitle);
		Supplier supplier = supplierDao.getSupplier(supplierId);
		supplierDao.deleteSupplier(supplier);
		List<Supplier> listSupplier = supplierDao.retrieveSupplier();
		int supplierCount = 0;
		for(Supplier sl:listSupplier)
		{
			supplierCount++;
		}
		session.setAttribute("supplierCount", supplierCount);
		m.addAttribute("supplierList",listSupplier);
		Supplier supplier1 = new Supplier();
		m.addAttribute(supplier1);
		return "supplier";
	}
	
	@RequestMapping(value="/admin/viewSupplier/{supplierId}", method=RequestMethod.GET)
	public String viewSupplier(@PathVariable("supplierId")int supplierId, Model m)
	{
		String pageTitle = "BookZone - Supplier Detail";
		m.addAttribute("pageTitle", pageTitle);
		Supplier supplier = supplierDao.getSupplier(supplierId);
		m.addAttribute(supplier);
		return "supplierDetail";
	}
}
