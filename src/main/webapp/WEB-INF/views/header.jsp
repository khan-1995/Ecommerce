<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-inverse">
<ul class="nav navbar-nav">
<li><a class="navbar-brand" href="#">WebSiteName</a></li>
<li class="active"><a href="${contextPath}">Home</a></li>
				<security:authorize access="hasAuthority('ROLE_ADMIN')">
					<li><a href="${contextPath}/admin/product">Product Operations</a></li>
					<li><a href="${contextPath}/admin/category">Category Operations</a></li>
				</security:authorize>
				<security:authorize access="!hasAuthority('ROLE_ADMIN')">
				 <li><a href="${contextPath}/user">View Products</a></li>
				 <li><a href="${contextPath}/customer/mycart">View Cart</a></li>
				 <li style="color: red"><a>WELCOME ${user.getName().toUpperCase()} </a></li>
				 </security:authorize>
				 <form class="navbar-form navbar-left" action="">
                 <div class="form-group">
				 <li><input type="text"  placeholder="Search" name="search">
				 <button type="submit" >search</button></li>
				 </div>
				 </form>
				 
</ul>
			
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    
    <ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="${contextPath}/reg"><span class="glyphicon glyphicon-user"></span>signup</a></li>
					<li><a href="${contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				</security:authorize>                    
				<security:authorize access="isAuthenticated()">
					<li id="logout"><a href="${contextPath}/perform_logout"><span
							class="glyphicon glyphicon-user"></span>Logout</a></li>
				</security:authorize>
			</ul>
  </div>
</nav>
  

    