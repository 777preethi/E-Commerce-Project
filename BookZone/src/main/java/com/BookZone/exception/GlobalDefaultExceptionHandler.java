package com.BookZone.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler 
{
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		String pageTitle = "BookZone - Error";
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("pageTitle", pageTitle);
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available right now!");
		/*mv.addObject("descList1", "");
		mv.addObject("descList2", "");
		mv.addObject("descList3", "");*/
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		String pageTitle = "BookZone - Error";
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("pageTitle", pageTitle);
		mv.addObject("errorTitle", "The item not available!");
		mv.addObject("errorDescription", "The item you are looking for is not available right now!");
		/*mv.addObject("descList1", "");
		mv.addObject("descList2", "");
		mv.addObject("descList3", "");*/
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		String pageTitle = "BookZone - Error";
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("pageTitle", pageTitle);
		mv.addObject("errorTitle", "Unable to load!!!");
		mv.addObject("errorDescription", "This may be due to the following reasons: ");
		mv.addObject("descList1", "The logged in session may be expired.");
		mv.addObject("descList2", "The requested page may not be available.");
		mv.addObject("descList3", "The form you have submitted may contain any error."+ex.getMessage());
		return mv;
	}
}
