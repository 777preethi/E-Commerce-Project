<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12"></div>
	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive scrollBar">
			<table class="table table-hover" align="center">
				<tr class="tableHead">
					<th>Customer Name</th>
					<th>Customer Phone</th>
					<th>Customer Email</th>
					<th>Query Title</th>
					<th>View More</th>
				</tr>
				<c:if test="${empty queriesList}">
					<tr class="tableContent">
						<td colspan="5" align="center">No Queries from Customers yet.</td>
					</tr>
				</c:if>
				<c:if test="${!empty queriesList}">
					<c:forEach items="${queriesList}" var="queries">
						<tr class="tableContent">
							<td>${queries.contactName }</td>
							<td>${queries.contactNumber }</td>
							<td>${queries.contactEmail }</td>
							<td>${queries.queryTitle }</td>
							<td>
								<a href="${pageContext.request.contextPath}/admin/viewQuery/${queries.contactId}">
									<img src="${pageContext.request.contextPath}/resources/images/viewIcon.png" class="iconStyle" />
								</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>	
	<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>