<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="image" value="${contextPath}/resources" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	    <div class="col-md-12">
				<c:forEach items="${prodlist}" var="prod">
     		 <div class="col-sm-3">
     		 <img src="${image}/${prod.productid}.jpg"
			style="width: 250px; height: 250px;">
			<p><a href="${contextPath}/productinfo/${prod.productid}">${prod.productname}</a></p> <br>
			<%-- <p>Description : ${prod.productdesc}</p> <br> --%>
			<p style="color: green">Price : Rs. ${prod.productprice} /-</p> <br>
			<%-- <p>
				QTY :<input type="text" placeholder="only ${prod.productstock} left">
			</p> <br>
 --%>			<button style="color: red">Add Item To Cart</button>
			<button style="color: red">Buy Now</button>
			<br>
			</div>
	</c:forEach>
	<br>
	</div>

</body>
</html>