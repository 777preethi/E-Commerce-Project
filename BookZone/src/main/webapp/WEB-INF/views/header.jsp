<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon" />
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/headerStyle.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/footerStyle.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"> </script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/formValidationScript.js"></script>
<title>${pageTitle}</title>
</head>
<body>

<!-- Header Navbar Content - Start -->
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container paddZero">
		<nav id="navbar-red" class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<ul class="nav navbar-nav">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bookzone-nav">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</ul>
			</div>
			<div class="collapse navbar-collapse spaces5 bottom5" id="bookzone-nav">	
				<a href="${pageContext.request.contextPath}/">
					<img src="${pageContext.request.contextPath}/resources/images/logo.png" class="logoImgStyle shiftLeft left5" />	
				</a>		
				<ul class="nav navbar-right navbar-nav right0">
					<li><a href="${pageContext.request.contextPath}/">BookZone</a></li>
					<c:if test="${pageContext.request.userPrincipal.name==null}">
						<li><a href="${pageContext.request.contextPath}/goToLogin">Sign In</a></li>
						<li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
					</c:if>					
					<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<c:if test = "${sessionScope.roleName == 'user'}">
					<li><a href="${pageContext.request.contextPath}/productList">Products</a></li>
					<li>
						<a href="${pageContext.request.contextPath}/MyCart"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;My Cart</a>
						<div class="notification">${sessionScope.cartCount}</div>
					</li>
					</c:if>	
					<c:if test = "${sessionScope.roleName == 'admin'}">
						<li>
							<a class="dropdown-toggle navbarTitleStyle" data-toggle="dropdown" href="#">Admin Roles<span class="caret"></span></a>
							<div><img src="${pageContext.request.contextPath}/resources/images/newIcon.png" class="newIconStyle" /></div>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/admin/category">Manage Categories&nbsp;<span class="notificationFont">(${sessionScope.categoryCount})</span></a></li>
								<li><a href="${pageContext.request.contextPath}/admin/supplier">Manage Suppliers&nbsp;<span class="notificationFont">(${sessionScope.supplierCount})</span></a></li>
								<li><a href="${pageContext.request.contextPath}/admin/product">Manage Products&nbsp;<span class="notificationFont">(${sessionScope.productCount})</span></a></li>
								<li><a href="${pageContext.request.contextPath}/admin/CustomerContact">Customer Queries&nbsp;<span class="notificationFont">(${sessionScope.contactCount})</span></a></li>
							</ul>
						</li>
						</c:if>
						<li>
							<a class="dropdown-toggle navbarTitleStyle" data-toggle="dropdown" href="#">
								Hi, ${sessionScope.userName}<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/viewProfile">My Profile</a></li>
								<c:if test = "${sessionScope.roleName == 'user'}">
									<li><a href="${pageContext.request.contextPath}/myOrders">My Orders</a></li>
								</c:if>
								<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			</div>
		</nav>
</div>
<!-- Header Navbar Content - End -->