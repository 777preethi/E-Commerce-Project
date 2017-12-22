<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
		<div class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab1supplier" data-toggle="tab">Add Supplier</a></li>
					<li><a href="#tab2supplier" data-toggle="tab">List Supplier</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content scrollBar">
					<div class="tab-pane fade in active" id="tab1supplier">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<form:form action="${pageContext.request.contextPath}/admin/AddSupplier" name="supplierForm" id="supplierForm" modelAttribute="supplier">
								<div class="clear spaces10"></div>
								<b class="formTitle" align="center">Add Supplier</b>
								<div class="clear spaces10"></div>
								<div class="form-group">
									<label>Supplier Name:</label>
									<form:input path="supplierName" class="form-control" placeholder="Supplier Name" />
									<form:errors path="supplierName" cssStyle="color:red"></form:errors>
								</div>
								<div class="form-group">
									<label>Supplier Address:</label>
									<form:input path="supplierAddress" class="form-control" placeholder="Supplier Address" />
									<form:errors path="supplierAddress" cssStyle="color:red"></form:errors>
								</div>
								<div class="form-group">
									<label>Supplier Email:</label>
									<form:input path="supplierEmail" class="form-control" placeholder="Supplier Email" />
									<form:errors path="supplierEmail" cssStyle="color:red"></form:errors>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
									<div class="form-group">	
									    <input type="submit" value="Add Supplier" class="btn btn-primary" />
									</div>
								</div>
								<div class="clear spaces5"></div>
							</form:form>
						</div>
					</div>
					<div class="tab-pane fade" id="tab2supplier">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
							<table class="table table-hover" align="center">
								<tr class="tableHead">
									<th>Supplier Name</th>
									<th>Supplier Address</th>
									<th>Supplier Email</th>
									<th>Operation</th>
								</tr>
								<c:if test="${empty supplierList}">
									<tr class="tableContent">
										<td colspan="5" align="center">No Supplier Available.</td>
									</tr>
								</c:if>
								<c:if test="${!empty supplierList}">
									<c:forEach items="${supplierList}" var="supplier">
										<tr class="tableContent">
											<td>${supplier.supplierName}</td>
											<td>${supplier.supplierAddress}</td>
											<td>${supplier.supplierEmail}</td>
											<td>
												<a href="${pageContext.request.contextPath}/admin/updateSupplier/${supplier.supplierId}">
													<img src="${pageContext.request.contextPath}/resources/images/editIcon.png" class="iconStyle" />
												</a>
												&nbsp;&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/admin/deleteSupplier/${supplier.supplierId}">
													<img src="${pageContext.request.contextPath}/resources/images/deleteIcon.png" class="iconStyle" />
												</a>
												&nbsp;&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/admin/viewSupplier/${supplier.supplierId}">
													<img src="${pageContext.request.contextPath}/resources/images/viewIcon.png" class="iconStyle" />
												</a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>