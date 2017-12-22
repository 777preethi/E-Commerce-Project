<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive scrollBar">
		<table class="table table-hover" align="center">
			<tr class="tableHead">
				<th colspan="2">Product Name $ Details</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>SubTotal</th>
			</tr>
			<c:if test="${empty completedOrdersList}">
				<tr class="tableContent" align="center">
					<td colspan="6">No completed orders available yet.</td>
				</tr>
			</c:if>
			<c:if test="${!empty completedOrdersList}">
				<c:forEach items="${completedOrdersList}" var="cart">
					<tr class="tableContent">
						<td><img src="${pageContext.request.contextPath}/resources/images/products/${cart.product.productId}.jpg" class="productThumb" /></td>
						<td>
							${cart.product.productName}
							<br>
							<a href="${pageContext.request.contextPath}/viewProduct/${cart.product.productId}">View Details</a>
						</td>
						<td>${cart.cartQuantity }</td>
						<td>${cart.cartPrice }</td>
						<td>${cart.cartQuantity*cart.cartPrice }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>