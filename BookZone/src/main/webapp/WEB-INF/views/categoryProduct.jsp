<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12"></div>
		<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
			<form:form action="${pageContext.request.contextPath}/categoryProducts" modelAttribute="category">
				<div class="form-group" align="left">
					<form:select path="catId" class="form-control" onchange="this.form.submit();">
						<option <c:if test="${catId eq 0}">selected="selected"</c:if> value="0">All Products</option>
            			<c:forEach items="${categoryList}" var="category">
            				<option <c:if test="${category.key eq catId}">selected="selected"</c:if> value="${category.key}">${category.value}</option>
        				</c:forEach>
					</form:select>
				</div>
			</form:form>
		</div>
		<c:forEach items="${productList}" var="product">
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			<div class="view overlay hm-orange-light">
    			<a href="${pageContext.request.contextPath}/viewProduct/${product.productId}">
    				<img src="${pageContext.request.contextPath}/resources/images/products/${product.productId}.jpg" class="center-block productImageStyle" alt="">
    			</a>
    			<div class="mask flex-center">
        			<p class="white-text"></p>
    			</div>
    			<c:if test="${product.stock eq 0}">
			    	<c:set var="watermarkVar" value="watermark"></c:set>
			    </c:if>
			    <c:if test="${product.stock ne 0}">
			    	<c:set var="watermarkVar" value="watermarkHide"></c:set>
			    </c:if>
			    <div class="${watermarkVar}">Out Of Stock</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 spaces10 bottom20" align="center">
				<a href="${pageContext.request.contextPath}/viewProduct/${product.productId}">
					<span class="bookHeadContentStyle">${product.productName}</span>
				</a>
				</br>
				<span class="bookContentStyle">&#8377;${product.price}</span>
			</div>
			<div class="clear spaces20"></div>
		</div>
		</c:forEach>
		
	</div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>