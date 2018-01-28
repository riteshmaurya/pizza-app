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
			<spring:url value="/selectOrder/add" var="formUrl"/>
			<form:form modelAttribute="pizza" action="${formUrl}" method="post" cssClass="col-md-8 col-md-offset-2">
				<div class="form-group">
					<label for="pizzaSize">Select Pizza Size</label>
					<form:select path="pizzaSize" cssClass="selectpicker" items="${getPizzaSize}"></form:select>
				</div>
				
				<div class="form-group">
					<label for="pizzaBase">Select Pizza Base</label>
					<form:select path="pizzaBase" cssClass="selectpicker" items="${getPizzaBase}"></form:select>
				</div>
				
				<div class="form-group">
					<label for="quantity">Select Quantity</label>
					<form:select path="quantity" cssClass="selectpicker" items="${getPizzaQuantity}"></form:select>
				</div>
				
				<div class="form-group">
					<label for="toppingMushroom">Topping Mushroom</label>
					<form:checkbox id="toppingMushroom" path="toppingMushroom"/>
				</div>
				
				<div class="form-group">
					<label for=toppingMeatball>Topping Meatball</label>
					<form:checkbox id="toppingMeatball" path="toppingMeatball"/>
				</div>
				
				<div class="form-group">
					<label for="toppingChicken">Topping Chicken</label>
					<form:checkbox id="toppingChicken" path="toppingChicken"/>
				</div>
				
				<div class="form-group">
					<label for="toppingExtracheese">Topping Extra Cheese</label>
					<form:checkbox id="toppingExtracheese" path="toppingExtracheese"/>
				</div>														
				<button type="submit" class="btn btn-default">Proceed</button>
			</form:form>
		</div>
	</div>
</body>
</html>