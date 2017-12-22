<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="form-group" align="center">
		<b class="formTitle">Customer Query Details</b>
	</div>
	<div class="clear spaces20"></div>
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 detailContentBR">
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Contact Id:</label>
			<label class="detailContent">${contact.getContactId()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Customer Name:</label>
			<label class="detailContent">${contact.getContactName()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Customer Phone:</label>
			<label class="detailContent">${contact.getContactNumber()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Customer Email:</label>
			<label class="detailContent">${contact.getContactEmail()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Query Title:</label>
			<label class="detailContent">${contact.getQueryTitle()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Customer Message:</label>
			<label class="detailContent">${contact.getQueryMessage()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<a href="${pageContext.request.contextPath}/admin/CustomerContact"><button class="btn btn-primary shiftRight">Back To Customer Queries</button></a>
		</div>
		<div class="clear spaces20"></div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
	<div class="clear spaces20"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>