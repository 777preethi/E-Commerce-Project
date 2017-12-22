<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12" align="center">
		<div class="clear spaces10"></div>
		<div class="form-group" align="left">
			<b class="formTitle">Order Details <label class="detailContent">#${orderId}</label></b>
		</div>
		<div class="clear spaces10"></div>
		<div class="form-group" align="left">
			<label class="detailTitle">Order Information</label>
		</div>
		<table class="table table-condensed">
			<tr>
				<td>
					<label class="detailTitle">Date:</label> 
					<label class="detailContent"><fmt:formatDate value="${orderDate}" pattern="MMMM dd, YYYY" /></label>
				</td>
				<td>
					<label class="detailTitle">Name/Email:</label> 
					<label class="detailContent">${userName}</label>
				</td>
			</tr>
			<tr>
				<td>
					<label class="detailTitle">Phone:</label> 
					<label class="detailContent">${userPhone}</label>
				</td>
				<td>
					<label class="detailTitle">Estimated Delivery:</label> 
					<label class="detailContent">Within 7 Working Days</label>
				</td>
			</tr>
			<tr>
				<td>
					<label class="detailTitle">Amount:</label> 
					<label class="detailContent">&#8377;${userAmount}</label>
				</td>
				<td>
					<label class="detailTitle">Mode of Payment:</label> 
					<c:if test="${userPMode == 'COD'}">
						<c:set var="paymentMode" value="Cash On Delivery"></c:set>
					</c:if>					
					<c:if test="${userPMode == 'CC'}">
						<c:set var="paymentMode" value="Credit Card"></c:set>
					</c:if>					
					<c:if test="${userPMode == 'DC'}">
						<c:set var="paymentMode" value="Debit Card"></c:set>
					</c:if>					
					<c:if test="${userPMode == 'NB'}">
						<c:set var="paymentMode" value="Net Banking"></c:set>
					</c:if>					
					<label class="detailContent">${paymentMode}</label>
				</td>
			</tr>
		</table>
		<div class="form-group" align="left">
			<label class="detailTitle">Items</label>
		</div>
		<table class="table table-condensed">
			<tr>
				<th colspan="2">Product Name $ Details</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>SubTotal</th>
			</tr>
			<c:forEach items="${userCartList}" var="cart">
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images//products/${cart.product.productId}.jpg" class="productThumb" /></td>
					<td>${cart.cartId }</td>
					<td>${cart.cartQuantity }</td>
					<td>${cart.cartPrice }</td>
					<td>${cart.cartQuantity*cart.cartPrice }</td>
					<c:set var="grandtotal" value="${grandtotal + (cart.cartQuantity*cart.cartPrice) }"></c:set>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right"><label>Grand Total: </label></td>
				<td><label><c:out value="${grandtotal }"></c:out></label></td>
			</tr>
		</table>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="form-group" align="right">						
				<a href="${pageContext.request.contextPath}/ack"><input type="button" value="Confirm" class="btn btn-primary" /></a>
			</div>
		</div>
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>