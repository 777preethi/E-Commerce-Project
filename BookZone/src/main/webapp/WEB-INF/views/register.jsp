<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%! String baseUrl="http://localhost:8080/BookZone/resources/";%>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<img src="${pageContext.request.contextPath}/resources/images/banner2.jpg" class="img-rounded img-responsive bannerImgStyle" />
	</div>
	<div class="clear spaces10"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 registerContent">
		<form:form action="${pageContext.request.contextPath}/AddUser" name="registerForm" id="registerForm" modelAttribute="user" enctype="multipart/form-data">
			<div class="clear spaces10"></div>
			<b class="formTitle">Create Account</b>
			<div class="clear spaces10"></div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
				    <label>Your Name:</label>
					<form:input path="name" class="form-control" placeholder="Your Name" />
					<form:errors path="name" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>Your Email:</label>
					<form:input path="email" class="form-control" placeholder="Your Email" />
					<form:errors path="email" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>Your Username:</label>
					<form:input path="username" class="form-control" placeholder="Your Username" />
					<form:errors path="username" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>Password:</label>
					<form:input type="password" path="password" class="form-control" minlength="5" placeholder="Atleast 5 Characters" />
					<form:errors path="password" cssStyle="color:red"></form:errors>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
				    <label>Your Phone:</label>
					<form:input path="phone" class="form-control" placeholder="Mobile Number" />
					<form:errors path="phone" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>Your Address:</label>
					<form:input path="address" class="form-control" placeholder="Your Address" />
					<form:errors path="address" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>Your Country:</label>
					<form:input path="country" class="form-control" placeholder="Your Country" />
					<form:errors path="country" cssStyle="color:red"></form:errors>
				</div>
				<div class="form-group">
				    <label>User Image:</label>
					<form:input type="file" path="uimage" />
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
				<div class="form-group">	
					<form:input type="hidden" path="enabled" value="TRUE" />
					<form:input type="hidden" path="role" value="ROLE_USER" />
				    <input type="submit" value="Sign Up" class="btn btn-primary" />
				</div>
			</div>
			<div class="clear spaces5"></div>
		</form:form>
	</div>
	<div class="clear spaces10"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<img src="${pageContext.request.contextPath}/resources/images/banner1.png" class="img-rounded img-responsive bannerImgStyle" />
	</div>	

</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>