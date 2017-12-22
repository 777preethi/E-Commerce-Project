<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12" align="center">
		<div class="clear spaces10"></div>
		<div class="form-group" align="center">
			<b class="formTitle">Shipping & Payment Details</b>
		</div>
		<div class="clear spaces10"></div>
		<form action="${pageContext.request.contextPath}/invoice" name="invoiceForm" id="invoiceForm" onsubmit="return validateInvoiceForm()" method="post">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group" align="center">
					<b class="formTitle">Shipping Address</b>
				</div>
				<div class="form-group" align="left">
					<label class="detailTitle">Name:</label>
					<label class="detailContent">${userName}</label>
				</div>
				<div class="form-group" align="left">
					<label class="detailTitle">Email:</label>
					<label class="detailContent">${userEmail}</label>
				</div>
				<div class="form-group" align="left">
					<label class="detailTitle">Phone:</label>
					<label class="detailContent">${userPhone}</label>
				</div>
				<div class="form-group" align="left">
					<label class="detailTitle">Address:</label>
					<label class="detailContent">${userAddress}</label>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 verticalLine" style="min-height:300px;">		
				<div class="form-group" align="center">
					<b class="formTitle">Payment Mode</b>
				</div>
				<div class="clear spaces10"></div>	
				<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">		
					<div class="error"></div>		
					<div class="clear spaces15"></div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" align="left">
						<label>Mode of Payment:</label>
						<select name="paymentMode" id="paymentMode" class="form-control" onchange="paymentModeChange()">
							<option value="COD" label="Cash on Delivery"></option>
							<option value="CC" label="Credit Card"></option>
							<option value="DC" label="Debit Card"></option>
							<option value="NB" label="Net Banking"></option>
						</select>
					</div>
					<div class="creditDebitCardDetails" style="display:none;">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" align="left">
							<input name="cardName" id="cardName" class="form-control" placeholder="Name on Card" />
						</div>						
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12form-group" align="left">
							<input name="cardNumber" id="cardNumber" class="form-control" placeholder="Card Number" maxlength="16" />
						</div>
						<div class="clear spaces15"></div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group" align="left">
							<input name="expireMonth" id="expireMonth" class="form-control" placeholder="MM" maxlength="2" />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group" align="left">
							<input name="expireYear" id="expireYear" class="form-control" placeholder="YYYY" maxlength="4" />
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12form-group" align="left">
							<input name="cvv" id="cvv" class="form-control" placeholder="CVV" maxlength="3" />
						</div>
					</div>
					<c:forEach items="${userCartList}" var="cart">
						<c:set var="grandtotal" value="${grandtotal + (cart.cartQuantity*cart.cartPrice) }"></c:set>
					</c:forEach>
					<input type="hidden" name="orderAmount" value="${grandtotal }" />
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="form-group" align="right">						
					<input type="submit" value="Continue" class="btn btn-primary" />
				</div>
			</div>
		</form>
	</div>	
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>