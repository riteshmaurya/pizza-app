<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ritesh's Online Pizza Store</title>

<link rel="stylesheet"
	href="<spring:url value="/resources/css/global.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/datepicker.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-multiselect.css"/>" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-multiselect.js"/>"></script>
<script src="<c:url value="/resources/js/global.js"/>"></script>
<script>
	var root = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<h1>Order Details</h1>
		</div>
		<ul class="list-group">
			<li class="list-group-item"><label>Customer:</label><span>${order.user.firstName } ${order.user.lastName}</span></li>
			<li class="list-group-item"><label>Order Number:</label><span>${order.orderId}</span></li>	
			<li class="list-group-item"><label>Order Time:</label><span>${order.orderDate}</span></li>
			<li class="list-group-item"><label>Total Items:</label><span>${order.totalItems}</span></li>
			<li class="list-group-item"><label>Delivery Address:</label><span>${order.deliveryAddress}</span></li>
			<li class="list-group-item"><label>Status:</label><span>${order.status}</span>
			<li class="list-group-item">
				<a class="btn btn-default" 
					href="<spring:url value="/order/back"/>" role="button">Back</a>
				<c:if test="${(order.status ne 'CANCEL') and (order.status ne 'COMPLETED')}">
				<a class="btn btn-default" 
					href="<spring:url value="/order/cancel"/>" role="button">Cancel</a>
				</c:if>
				<c:if test="${(order.status ne 'CANCEL') and  (order.status ne 'COMPLETED') and (order.status ne 'PROCESSING')}">	
				<a class="btn btn-default" 
					href="<spring:url value="/order/process"/>" role="button">Process</a>
				</c:if>
				<c:if test="${(order.status ne 'CREATED') and  (order.status eq 'PROCESSING') and  (order.status ne 'CANCEL') and (order.status ne 'COMPLETED')}">	
				<a class="btn btn-default" 
					href="<spring:url value="/order/complete"/>" role="button">Mark Complete</a>
				</c:if>	
			</li>
		</ul>
	</div>
</body>
</html>