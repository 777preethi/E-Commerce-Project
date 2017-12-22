<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%! String baseUrl="http://localhost:8080/BookZone/resources/";%>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="clear spaces10"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 registerContent">
		<form:form action="${pageContext.request.contextPath}/UpdateProfile" modelAttribute="user" enctype="multipart/form-data">
			<div class="clear spaces10"></div>
				<b class="formTitle">Update Profile</b>
			<div class="clear spaces10"></div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
				    <label>Your Name:</label>
					<form:input path="name" class="form-control" placeholder="Your Name" />
				</div>
				<div class="form-group">
				    <label>Your Email:</label>
					<form:input path="email" class="form-control" placeholder="Your Email" />
				</div>
				<div class="form-group">
				    <label>Your Phone:</label>
					<form:input path="phone" class="form-control" placeholder="Mobile Number" />
				</div>
				<div class="form-group">
					<form:input type="hidden" path="username" class="form-control" placeholder="Your Username" />
				</div>
				<div class="form-group">
					<form:input type="hidden" path="password" class="form-control" minlength="5" placeholder="Atleast 5 Characters" />
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
				    <label>Your Address:</label>
					<form:input path="address" class="form-control" placeholder="Your Address" />
				</div>
				<div class="form-group">
				    <label>Your Country:</label>
					<form:input path="country" class="form-control" placeholder="Your Country" />
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
				    <input type="submit" value="Edit Profile" class="btn btn-primary" />
				</div>
			</div>
			<div class="clear spaces5"></div>
		</form:form>
	</div>
	<div class="clear spaces10"></div>
</div>
<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>