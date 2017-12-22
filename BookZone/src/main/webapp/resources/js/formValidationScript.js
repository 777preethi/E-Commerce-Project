$(function() 
{
	$("#loginForm").validate({
		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : "Please enter username"
			},
			password : {
				required : "Please enter password"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#registerForm").validate({
		rules : {
			name : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			username : {
				required : true
			},
			password : {
				required : true,
				minlength : 5,
				maxlength : 15
			},
			phone : {
				required : true,
				minlength : 10,
				maxlength : 10
			},
			address : {
				required : true
			},
			country : {
				required : true
			}
		},
		messages : {
			name : {
				required : "Please enter your name"
			},
			email : {
				required : "Please enter your email",
				email : "Please enter valid email"
			},
			username : {
				required : "Please enter username"
			},
			password : {
				required : "Please enter password",
				minlength : "Your password must between 5 and 15 characters",
				maxlength : "Your password must between 5 and 15 characters"
			},
			phone : {
				required : "Please enter password",
				minlength : "Please enter valid 10 digit mobile number",
				maxlength : "Please enter valid 10 digit mobile number"
			},
			address : {
				required : "Please enter your address"
			},
			country : {
				required : "Please enter your country"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#categoryForm").validate({
		rules : {
			catName : {
				required : true
			},
			catDesc : {
				required : true
			}
		},
		messages : {
			catName : {
				required : "Please enter category name"
			},
			catDesc : {
				required : "Please enter category description"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#supplierForm").validate({
		rules : {
			supplierName : {
				required : true
			},
			supplierAddress : {
				required : true
			},
			supplierEmail : {
				required : true,
				email : true
			}
		},
		messages : {
			supplierName : {
				required : "Please enter supplier name"
			},
			supplierAddress : {
				required : "Please enter supplier address"
			},
			supplierEmail : {
				required : "Please enter supplier email",
				email : "Please enter valid email"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#productForm").validate({
		rules : {
			productName : {
				required : true
			},
			price : {
				required : true,
				digits : true,
				min : 1
			},
			stock : {
				required : true,
				digits : true,
				min : 1
			},
			catId: {
				required: {
					depends: function(element) {
	                     return $('#catId').val() == 0;
	                 }
	              }
	        },
	        supplierId: {
				required: {
					depends: function(element) {
	                     return $('#supplierId').val() == 0;
	                 }
	              }
	        },
			productDesc : {
				required : true
			}
		},
		messages : {
			productName : {
				required : "Please enter product name"
			},
			price : {
				required : "Please enter product price",
				digits: "Please enter only digits",
				min: "Please enter valid product price"
			},
			stock : {
				required : "Please enter product stock",
				digits: "Please enter only digits",
				min: "Please enter valid product stock"
			},
			catId : {
				required : "Please choose a category"
			},
			supplierId : {
				required : "Please choose a supplier"
			},
			productDesc : {
				required : "Please enter product description"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#contactForm").validate({
		rules : {
			contactName : {
				required : true
			},
			contactEmail : {
				required : true,
				email : true
			},
			contactNumber : {
				required : true,
				minlength : 10,
				maxlength : 10
			},
			queryTitle : {
				required : true
			},
			queryMessage : {
				required : true
			}
		},
		messages : {
			contactName : {
				required : "Please enter your name"
			},
			contactEmail : {
				required : "Please enter your email",
				email : "Please enter valid email"
			},
			contactNumber : {
				required : "Please enter your mobile number",
				minlength : "Please enter valid 10 digit mobile number",
				maxlength : "Please enter valid 10 digit mobile number"
			},
			queryTitle : {
				required : "Please enter query title"
			},
			queryMessage : {
				required : "Please enter your message"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
});
function validateCartForm()
{
	var cartStock = $("#cartStock").val();
	var cartQuantity = $("#cartQuantity").val();
	//alert(cartStock);
	//alert(cartQuantity);
	if (parseInt(cartQuantity)==null || parseInt(cartQuantity)=="")
	{  
		 //alert("Please enter the quantity");  
		 $(".error").html("Please enter the quantity");
		 return false;  
	}
	else if (parseInt(cartQuantity)=="0" || parseInt(cartQuantity)==0)
	{  
		 //alert("Please enter the quantity greater than zero");
		 $(".error").html("Please enter the quantity greater than zero");  
		 return false;  
	}
	else if(parseInt(cartQuantity) > parseInt(cartStock))
	{  
		  //alert("The quantity should be within the available stock."); 
		  $(".error").html("The quantity should be within the available stock"); 
		  return false;  
	}  
}
function paymentModeChange()
{
	var paymentMode = $("#paymentMode").val();
	//alert(paymentMode);
	if(paymentMode == "CC" || paymentMode == "DC")
	{
		$(".creditDebitCardDetails").css("display", "inline-block");
	}
	else
	{
		$(".creditDebitCardDetails").css("display", "none");
	}
}
function validateInvoiceForm()
{
	var paymentMode = $("#paymentMode").val();
	if(paymentMode == "CC" || paymentMode == "DC")
	{
		var cardName = $("#cardName").val(); 
		var cardNumber = $("#cardNumber").val(); 
		var expireMonth = $("#expireMonth").val(); 
		var expireYear = $("#expireYear").val(); 
		var cvv = $("#cvv").val();
		
		if(cardName == null || cardName == '')
		{
			$(".error").html("Please enter the name of the card holder"); 
			return false;  
		}
		else if(parseInt(cardNumber) == null || parseInt(cardNumber) == "" || parseInt(cardNumber) == "0" || parseInt(cardNumber) == 0)
		{
			$(".error").html("Please enter your card number"); 
			return false;  
		}
		else if(isNaN(parseInt(cardNumber)))
		{
			$(".error").html("Card number need to be only numbers"); 
			return false;  
		}
		else if(parseInt(cardNumber).length > '14')
		{
			$(".error").html("Please enter valid card number"); 
			return false;  			
		}
		else if(parseInt(expireMonth) == null || parseInt(expireMonth) == "" || parseInt(expireMonth) == "0" || parseInt(expireMonth) == 0)
		{
			$(".error").html("Please enter the expire month"); 
			return false; 
		}
		else if(isNaN(parseInt(expireMonth)))
		{
			$(".error").html("Expire month need to be only numbers"); 
			return false; 
		}
		else if(parseInt(expireMonth) < 0 || parseInt(expireMonth) > 12)
		{
			$(".error").html("Please enter valid expire month from 01 to 12"); 
			return false; 
		}
		else if(parseInt(expireYear) == null || parseInt(expireYear) == "" || parseInt(expireYear) == "0" || parseInt(expireYear) == 0)
		{
			$(".error").html("Please enter the expire year"); 
			return false; 
		}
		else if(isNaN(parseInt(expireYear)))
		{
			$(".error").html("Expire year need to be only numbers"); 
			return false; 
		}
		else if(parseInt(expireYear) < 1995 || parseInt(expireYear) > 2060)
		{
			$(".error").html("Please enter valid expire year from 1995 to 2060"); 
			return false; 
		}
		else if(parseInt(cvv) == null || parseInt(cvv) == "" || parseInt(cvv) == "0" || parseInt(cvv) == 0)
		{
			$(".error").html("Please enter the cvv number"); 
			return false;  
		}
		else if(isNaN(parseInt(cvv)))
		{
			$(".error").html("CVV need to be only numbers"); 
			return false;  
		}
		else if(parseInt(cvv).length > 3)
		{
			$(".error").html("Please enter valid 3 digits CVV number"); 
			return false;  			
		}
	}
}