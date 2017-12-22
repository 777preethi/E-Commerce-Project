<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="form-group" align="center">
		<b class="formTitle">Category Details</b>
	</div>
	<div class="clear spaces20"></div>
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 detailContentBR">
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Category Id:</label>
			<label class="detailContent">${category.getCatId()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Category Name:</label>
			<label class="detailContent">${category.getCatName()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<label class="detailTitle">Category Description:</label>
			<label class="detailContent">${category.getCatDesc()}</label>
		</div>
		<div class="clear spaces20"></div>
		<div class="form-group">
			<a href="${pageContext.request.contextPath}/admin/category"><button class="btn btn-primary shiftRight">Back To Category</button></a>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
	<div class="clear spaces20"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>