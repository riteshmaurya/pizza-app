<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<spring:url value="/"/>" class="navbar-brand">Ritesh's Online Pizza Store</a>
			</div>
			<ul class="nav navbar-nav">
				<sec:authorize access="hasRole('ROLE_ADMIN')" var="roleCheck"/>
				<sec:authorize access="hasRole('ROLE_USER')" var="roleCheckUser"/>
				<c:if test="${!roleCheck}">
				<li><a href="<spring:url value="/selectOrder/add/"/>">Start Your Order</a></li>
				</c:if>
				<c:if test="${roleCheckUser}">
				<li><a href="<spring:url value="/selectOrder/findAll/"/>">View Orders</a></li>
				</c:if>				
				<c:if test="${roleCheck}">
				<li><a href="<spring:url value="/order/findAll/"/>">Manage Orders</a></li>
				</c:if>
				<sec:authorize access="authenticated" var="authenticated"/>
				<c:choose>
					<c:when test="${authenticated}">
						<li>
							<p class="navbar-text">
								Welcome
								<sec:authentication property="name"/>
								<a id="logout" href="#">Logout</a>
							</p>
							<form id="logout-form" action="<c:url value="/logout"/>" method="post">
								<sec:csrfInput/>
							</form>
						</li>	
					</c:when>
					<c:otherwise>
						<li><a href="<spring:url value="/login/"/>">Sign In</a></li>			
						<li><a href="<spring:url value="/register/"/>">Register</a></li>			
					</c:otherwise>
				</c:choose>			
			</ul>
		</div>
	</nav>