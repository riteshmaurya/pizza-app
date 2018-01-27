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
<script src="<spring:url value="/resources/js/appointments.js"/>"></script>
<script>
	var root = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<h2>Items</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>PIZZA NUMBER</th><th>PIZZA_SIZE</th><th>PIZZA_BASE</th><th>TOPPING_MUSHROOM</th>
						<th>TOPPING_CHICKEN</th><th>TOPPING_EXTRACHEESE</th><th>TOPPING_MEATBALL</th>
						<th>QUANTITY</th><th>UNIT_PRICE</th>
				</tr>
				<c:forEach items="${pizzas}" var="pizza">
					<tr>
						<td>${pizza.pizzaId}</td>
						<td>${pizza.pizzaSize}</td>
						<td>${pizza.pizzaBase}</td>
						<td>${pizza.toppingMushroom}</td>
						<td>${pizza.toppingChicken}</td>
						<td>${pizza.toppingExtracheese}</td>
						<td>${pizza.toppingMeatball}</td>
						<td>${pizza.quantity}</td>
						<td>${pizza.unitPrice}</td>
					</tr>	
				</c:forEach>

			</tbody>
		</table>
		<table>
			<tbody>
				<tr>
					<td>
					<a class="btn btn-default" 
					href="<spring:url value="/order/back"/>" role="button">Back</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>