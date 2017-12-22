<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	${loginData}
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
		<table class="table table-hover" align="center">
			<tr class="tableHead">
				<th colspan="2">Product Name $ Details</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>SubTotal</th>
			</tr>
			<c:if test="${empty userCartList}">
				<tr class="tableContent" align="center">
					<td colspan="5">No products available in your cart.</td>
				</tr>
			</c:if>
			<c:if test="${!empty userCartList}">
			<c:forEach items="${userCartList}" var="cart">
				<tr class="tableContent">
					<td><img src="${pageContext.request.contextPath}/resources/images/products/${cart.product.productId}.jpg" class="productThumb" /></td>
					<td>
						${cart.product.productName}
						<br>
						<a href="${pageContext.request.contextPath}/viewProduct/${cart.product.productId}">View Details</a>
					</td>
					<td>${cart.cartQuantity }</td>
					<td>${cart.cartPrice }</td>
					<td>
						${cart.cartQuantity*cart.cartPrice }
						&nbsp;<a href="${pageContext.request.contextPath}/deleteCart/${cart.cartId}">Remove</a>
					</td>
					<c:set var="grandtotal" value="${grandtotal + (cart.cartQuantity*cart.cartPrice) }"></c:set>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right"><label>Grand Total: </label></td>
				<td colspan="1"><label><c:out value="${grandtotal }"></c:out></label></td>
			</tr>
			</c:if>
		</table>
		<c:if test="${empty userCartList}">
			<div class="form-group" align="right">	
				<a href="${pageContext.request.contextPath}/productList"><input type="button" value="< Start Shopping" class="btn btn-primary" /></a>
			</div>
		</c:if>
		<c:if test="${!empty userCartList}">
			<div class="form-group" align="right">	
				<a href="${pageContext.request.contextPath}/productList"><input type="button" value="< Continue Shopping" class="btn btn-primary" /></a>					
				<a href="${pageContext.request.contextPath}/checkout"><input type="button" value="Place Order" class="btn btn-primary" /></a>
			</div>
		</c:if>
		<div class="clear spaces10"></div>
	</div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>