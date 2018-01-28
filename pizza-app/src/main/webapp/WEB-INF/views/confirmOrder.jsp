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
			<spring:url value="/selectOrder/save" var="formUrl"/>
			<form:form modelAttribute="pizza" action="${formUrl}" method="post" cssClass="col-md-8 col-md-offset-2">
				<div class="form-group">
					<label for="pizzaSize">Pizza Size: </label>${pizza.pizzaSize}
				</div>
				<div class="form-group">
					<label for="pizzaBase">Pizza Base: </label>${pizza.pizzaBase}
				</div>
				<div class="form-group">
					<label for="quantity">Quantity: </label>${pizza.quantity}
				</div>
				<div class="form-group">
					<label for="toppings">Toppings Selected: </label>
					<c:if test="${pizza.toppingMushroom}">
					Mushroom
					</c:if>
					<c:if test="${pizza.toppingChicken}">
					Chicken
					</c:if>
					<c:if test="${pizza.toppingExtracheese}">
					Extra Cheese
					</c:if>
					<c:if test="${pizza.toppingMeatball}">
					Meatball
					</c:if>
				</div>
				<div class="form-group">
					<label for="pricePerPizza">Price per pizza: </label>${pricePerPizza}
				</div>
				<div class="form-group">
					<label for="totalPrice">Total Price: </label>${totalPrice}
				</div>
				<button type="submit" class="btn btn-default">Submit Order</button>
			</form:form>
		</div>
	</div>
</body>
</html>