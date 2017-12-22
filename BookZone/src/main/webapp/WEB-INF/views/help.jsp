<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="clear spaces10"></div>
	<div class="form-group" align="center">
		<b class="formTitle">Hello. What can we help you with?</b>
	</div>
	<div class="clear spaces20"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/Home.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- Home Page</label>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/Products.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- All Products Page</label>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/Productdetail.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- Product Detail Page</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/Cart.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- My Cart Page</label>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/profile.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- Profile Page</label>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" align="center">
			<img src="${pageContext.request.contextPath}/resources/images/MyOrders.png" class="center-block productImageStyle" alt="">
			<div class="clear spaces10"></div>
			<label class="detailContent">BookZone- My Orders Page</label>
		</div>
	</div>	
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>