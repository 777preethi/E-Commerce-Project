<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12" align="center">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 aboutUsHead" align="center">
			<div class="clear spaces20"></div>
			<div class="form-group" align="center">
				<b class="aboutUsTitle">The BookZone Story</b>
			</div>
			<div class="clear spaces20"></div>
		</div>
		<div class="clear spaces20"></div>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 aboutUsContent" align="center">
			<div class="clear spaces20"></div>
			<div class="form-group" align="center">
				<b class="aboutUsContentItalic">Launched in September 2017</b>
			</div>
			<div class="clear spaces10"></div>
			<div class="form-group" align="center">
				<b class="aboutUsDataContent">BookZone is India's leading E-commerce marketplace with so many products across many of book categories.</b>
			</div>
			<div class="clear spaces20"></div>
		</div>
		<div class="clear spaces20"></div>
		<div id="bookZoneCarousel" class="carousel silde spaces40" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#bookZoneCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#bookZoneCarousel" data-slide-to="1" class="active"></li>
				<li data-target="#bookZoneCarousel" data-slide-to="2" class="active"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="${pageContext.request.contextPath}/resources/images/aboutBooks1.jpg" class="img-rounded img-responsive center-block sliderImg" />
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/images/aboutBooks2.jpg" class="img-rounded img-responsive center-block sliderImg" />
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/images/aboutBooks3.jpg" class="img-rounded img-responsive center-block sliderImg" />
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
	</div>
	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12"></div>
</div>
<div class="clear spaces20"></div>
<jsp:include page="footer.jsp"></jsp:include>