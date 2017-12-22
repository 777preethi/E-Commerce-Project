<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<form:form action="${pageContext.request.contextPath}/admin/UpdateSupplier" modelAttribute="supplier" method="post">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 updateFormStyle">
				<div class="clear spaces10"></div>
				<b class="formTitle" align="center">Update Supplier</b>
				<div class="clear spaces10"></div>
				<form:input type="hidden" path="supplierId" class="form-control" placeholder="Supplier Id" />
				<div class="form-group">
					<label>Supplier Name:</label>
					<form:input path="supplierName" class="form-control" placeholder="Supplier Name" />
				</div>
				<div class="form-group">
					<label>Supplier Address:</label>
					<form:input path="supplierAddress" class="form-control" placeholder="Supplier Address" />
				</div>
				<div class="form-group">
					<label>Supplier Email:</label>
					<form:input path="supplierEmail" class="form-control" placeholder="Supplier Email" />
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
					<div class="form-group">	
					    <input type="submit" value="Update Supplier" class="btn btn-primary" />
					<a href="${pageContext.request.contextPath}/admin/supplier"><button class="btn btn-primary">Back To Supplier</button></a>
					</div>
				</div>
				<div class="clear spaces5"></div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
		</div>
	</form:form>
	<div class="clear spaces10"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>