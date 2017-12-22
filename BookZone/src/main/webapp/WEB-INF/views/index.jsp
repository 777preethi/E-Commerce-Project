<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div id="bookZoneCarousel" class="carousel silde" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#bookZoneCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#bookZoneCarousel" data-slide-to="1" class="active"></li>
			<li data-target="#bookZoneCarousel" data-slide-to="2" class="active"></li>
			<li data-target="#bookZoneCarousel" data-slide-to="3" class="active"></li>
			<li data-target="#bookZoneCarousel" data-slide-to="4" class="active"></li>
			<li data-target="#bookZoneCarousel" data-slide-to="5" class="active"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="${pageContext.request.contextPath}/resources/images/slider1.png" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">A reader lives a thousand lives before he dies. The man who never reads lives only one.</p>
					<h2 class="sliderHeadContentStyle">- George R.R. Martin</h2>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/slider2.jpg" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">If we encounter a man of rare intellect, we should ask him what books he reads.</p>
					<h2 class="sliderHeadContentStyle">- Ralph Waldo Emerson</h2>
				</div> 
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/slider3.jpg" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">I would never read a book if it were possible for me to talk half an hour with the man who wrote it.</p>
					<h2 class="sliderHeadContentStyle">- Woodrow Wilson</h2>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/slider4.jpg" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">Great books help you understand, and they help you feel understood.</p>
					<h2 class="sliderHeadContentStyle">- John Green</h2>
				</div> 
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/slider5.jpg" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">Life is too short to read books that I'm not enjoying.</p>
					<h2 class="sliderHeadContentStyle">- Melissa Marr</h2>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/slider6.jpg" class="img-rounded img-responsive center-block sliderImg" />
				<div class="carousel-caption">
					<p class="sliderContentStyle">Clearly one must read every good book at least once every ten years.</p>
					<h2 class="sliderHeadContentStyle">- C.S. Lewis</h2>
				</div> 
			</div>
		</div>
		<a class="left carousel-control" href="#bookZoneCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#bookZoneCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div class="clear spaces20"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="clear spaces10"></div>
		<c:if test="${empty latestProductList}">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 left10 right10" align="center">
				<span class="bookHeadContentStyle">No Products Available</span>
			</div>
		</c:if>
		<c:if test="${!empty latestProductList}">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 left10 right10">
				<c:forEach items="${latestProductList}" var="product">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 spaces10">
						<div class="view overlay hm-orange-light">
			    			<img src="${pageContext.request.contextPath}/resources/images/products/${product.productId}.jpg" class="center-block productImageStyle" alt="">
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
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 spaces10" align="center">
							<span class="bookHeadContentStyle">${product.productName}</span>
							<div class="clear"></div>
							<span class="bookContentStyle">${fn:substring(product.productDesc,0,25)}... <a href="${pageContext.request.contextPath}/viewProduct/${product.productId}">More</a></span>
							<div class="clear"></div>
							<span class="bookContentStyle">&#8377;${product.price}</span>
						</div>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<div class="clear spaces10"></div>
	</div>
</div>
<div class="clear spaces20"></div>
<jsp:include page="footer.jsp"></jsp:include>