<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="clear spaces20"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<h1>${errorTitle}</h1>
		<span>${errorTitle}</span>
		<ul>
			<c:if test="${descList1 != null}">
				<li>${descList1}</li>
			</c:if>
			<c:if test="${descList2 != null}">
				<li>${descList2}</li>
			</c:if>
			<c:if test="${descList3 != null}">
				<li>${descList3}</li>
			</c:if>
		</ul>
	</div>
	<div class="clear spaces20"></div>
</div>

<div class="clear spaces10"></div>
<jsp:include page="footer.jsp"></jsp:include>