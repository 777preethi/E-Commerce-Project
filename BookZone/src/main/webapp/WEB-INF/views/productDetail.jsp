<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="clear spaces10"></div>
	<form action="${pageContext.request.contextPath}/AddCart" name="addCartForm" onsubmit="return validateCartForm()" method="post">
	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
		<img src="${pageContext.request.contextPath}/resources/images/products/${product.getProductId()}.jpg" class="productDetailImg detailBorderDtyle center-block" alt="">
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12 spacingWidth"></div>
	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" align="left">
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<div class="form-group">
				<span class="productDetailTitle">${product.getProductName()}</span>
			</div>
			<div class="form-group">
				<span class="aboutUsDataContent">${product.getProductDesc()}</span>
			</div>	
			<div class="form-group">
				<label class="detailTitle">Category:</label>
				<label class="detailContent">${category.getCatName()}</label>
			</div><div class="form-group">
				<label class="detailTitle">Supplier:</label>
				<label class="detailContent">${supplier.getSupplierName()}</label>
			</div>
			<div class="form-group">
				<span class="productDetailTitle">&#8377;${product.getPrice()}</span>
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<div class="clear spaces40"></div>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<span class="aboutUsDataContent"><b>NB: </b>Please SignIn for adding this product to your cart.</span>
			</c:if>
			<c:if test="${sessionScope.roleName == 'user'}">
				<input type="hidden" name="cartProductId" value="${product.getProductId()}" />
				<input type="hidden" name="cartUserId" value="${sessionScope.userId}" />
				<input type="hidden" name="cartStock" id="cartStock" value="${product.getStock()}" />
				<div class="form-group">
					<input name="cartQuantity" id="cartQuantity" class="form-control" placeholder="Quantity" />
				</div>
				<div class="error"></div>
				<c:if test="${product.getStock() eq 0}">
			    	<div class="form-group">
						<label class="detailTitle">Out Of Stock</label>
					</div>
			    </c:if>
			    <c:if test="${product.getStock() ne 0}">
			    	<div class="form-group">
						<label class="detailTitle">Available Stock: </label>
						<label class="detailContent">${product.getStock()}</label>
					</div>			
					<div class="form-group" align="left">	
						<input type="submit" value="Add to Cart" class="btn btn-primary" />
					</div>
			    </c:if>	
			</c:if>
		</div>
	</div>
	</form>
	<div class="clear spaces10"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>