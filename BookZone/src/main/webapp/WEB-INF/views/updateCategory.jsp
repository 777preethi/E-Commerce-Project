<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<form:form action="${pageContext.request.contextPath}/admin/UpdateCategory" modelAttribute="category" method="post">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 updateFormStyle">
				<div class="clear spaces10"></div>
				<b class="formTitle" align="center">Update Category</b>
				<div class="clear spaces10"></div>
				<form:input type="hidden" path="catId" class="form-control" placeholder="Category Id" />
				<div class="form-group">
					<label>Category Name:</label>
					<form:input path="catName" class="form-control" placeholder="Category Name" />
				</div>
				<div class="form-group">
					<label>Category Description:</label>
					<form:textarea path="catDesc" class="form-control" placeholder="Category Description" />
				</div>
				<div class="form-group" align="center">	
					<input type="submit" value="Update Category" class="btn btn-primary" />
					<a href="${pageContext.request.contextPath}/admin/category"><button class="btn btn-primary">Back To Category</button></a>
				</div>
				<div class="clear spaces10"></div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
		</div>
	</form:form>
	<div class="clear spaces10"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>