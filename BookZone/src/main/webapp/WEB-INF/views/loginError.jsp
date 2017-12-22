<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 acknowledgementBG" align="center">
		<div class="clear spaces20"></div>
		<div class="form-group" align="center">
			<b class="acknowledgementTitle">Invalid Login</b>
		</div>
		<div class="clear spaces10"></div>
		<div class="form-group" align="left">
			<label class="detailContent">You have given incorrect credentials for login. Please try again with correct credentials!</label>
		</div>
		<div class="clear spaces10"></div>
		<div class="form-group" align="center">						
			<a href="${pageContext.request.contextPath}/goToLogin"><input type="button" value="Sign In" class="btn btn-primary" /></a>
		</div>
		<div class="clear spaces20"></div>
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>