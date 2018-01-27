<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ritesh's Online Pizza Store</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
	<script src="<c:url value="/resources/js/global.js"/>"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<h1>Welcome to Ritesh's Online Pizza Store!</h1>
			<h3>We provide best Pizza in the town.</h3>
			<p>Using organic products and special herbs, our Pizza's come with unique taste that you cant find we bet.</p>
			<p>Don't hesitate to buy one today!</p>
			<p>Owning a social responsibility, we also acknowledge that pizza are not so good for health!</p>
		</div>
	</div>
</body>
</html>