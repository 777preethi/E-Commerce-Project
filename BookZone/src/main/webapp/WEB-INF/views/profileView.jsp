<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
		<img src="${pageContext.request.contextPath}/resources/images/users/${userId}.jpg" class="productDetailImg detailBorderDtyle center-block" alt="">
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12 spacingWidth"></div>
	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" align="left">
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<div class="form-group" align="left">
				<label class="detailTitle">Name:</label>
				<label class="detailContent">${userName}</label>
			</div>
			<div class="form-group" align="left">
				<label class="detailTitle">Phone:</label>
				<label class="detailContent">${userPhone}</label>
			</div>
			<div class="form-group" align="left">
				<label class="detailTitle">Email:</label>
				<label class="detailContent">${userEmail}</label>
			</div>
			<div class="form-group" align="left">
				<label class="detailTitle">Address:</label>
				<label class="detailContent">${userAddress}</label>
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<!-- <div class="form-group" align="right">	
				<a href="${pageContext.request.contextPath}/updateProfile">
					<input type="button" value="Edit Your Profile" class="btn btn-primary" />
				</a>
			</div> -->
		</div>
	</div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>