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
		<h2>Orders</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Order Number</th><th>Order Details</th><th>Customer</th><th>Order Date</th>
						<th>Total Items</th><th>Total Price</th><th>Delivery Address</th><th>Status</th>
				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>
						<sec:authorize access="hasRole('ROLE_ADMIN')" var="roleCheck"/>

						<c:choose>
						<c:when test="${roleCheck}">
						<a href="<spring:url value="/order/${order.orderId}"/>">${order.orderId}</a>
						</c:when>
						<c:otherwise>
						${order.orderId}
						</c:otherwise>
						</c:choose>
						</td>
						<td>
						<c:choose>
						<c:when test="${roleCheck}">
						<a href="<spring:url value="/order/item/${order.orderId}"/>">${item}</a>
						</c:when>
						<c:otherwise>
						${item}
						</c:otherwise>	
						</c:choose>					
						</td>
						<td>${order.user.firstName } ${order.user.lastName}</td>
						<td>${order.orderDate}</td>
						<td>${order.totalItems}</td>
						<td>${order.totalPrice}</td>
						<td>${order.deliveryAddress}</td>
						<td>${order.status}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>