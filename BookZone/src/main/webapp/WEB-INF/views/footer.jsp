<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Footer Content - Start -->
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 bookzoneFooter">
	<footer class="">
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 spaces10 bottom10" align="left">
			<a href="${pageContext.request.contextPath}/AboutUs" class="footerContent">About Us</a>
			<span class="footerContent">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
			<a href="${pageContext.request.contextPath}/Help" class="footerContent">Help</a>
			<div class="clear spaces5"></div>
			<a href="${pageContext.request.contextPath}/PrivacyPolicy" class="footerContent">Privacy Policy</a>
			<c:if test = "${sessionScope.roleName == 'user'}">
			<span class="footerContent">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
			<a href="${pageContext.request.contextPath}/ContactUs" class="footerContent">Contact Us</a>
			</c:if>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 spaces20" align="center">
			<span class="footerContent">Copyright 2017 BookZone</span>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 spaces15 bottom10" align="right">
			<a href="https://www.facebook.com"><i id="social-fb1" class="fa fa-facebook-square fa-3x social"></i></a>
			<a href="https://twitter.com"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
			<a href="https://plus.google.com"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
			<a href="mailto:777preethu@gmail.com"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
		</div>	
	</footer>
</div>
<!-- Footer Content - End -->
</body>
</html>