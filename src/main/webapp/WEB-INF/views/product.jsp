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
</head>
<body>
<%@include file="header.jsp"%>
<form:form id="prodForm" modelAttribute="product" action="${contextPath}/admin/prodprocess" enctype="multipart/form-data" method="post">

 	<div class="table-responsive">

			<center>
				<h2>Product form</h2>
			</center>
			</br>

			<div class="container">

				<div class="row">

					<div class=col-sm-3></div>

					<div class="col-sm-6">

						<div class="form-group">

							 <form:input path="productid" type="hidden" /> 

							<label for="productname">Product Name:</label>

							<form:input path="productname" name="productname" id="productname" required="true"
								class="form-control" />

						</div>

						<div class="form-group">

							<label for="productdesc">Product Description:</label>

							<form:input path="productdesc" name="productdesc"
								id="productdesc" class="form-control" />

						</div>
						<div class="form-group">

							<label for="productprice">Product price:</label>

							<form:input path="productprice" name="productprice" id="productprice"
								class="form-control" />

						</div>
						<div class="form-group">

							<label for="productstock">Product stock:</label>

							<form:input path="productstock" name="productstock" id="productstock"
								class="form-control" />

						</div>
						<div class="form-group">

							<label for="category.categoryid">Category id:</label>

							<form:input path="category.categoryid" name="category.categoryid"
								id="category.categoryid" class="form-control" />

						</div>

						<div class="form-group">
							<label for="image">Upload Image:</label>
							<form:input path="image" type="file" class="form-control"
								required="true" />
								</div>


							<button type="submit" class="btn btn-default">Add
								Product</button>



						</div>

					</div>

			</div>

		</div> 
 
 

 
	<div class="table-responsive">
		<table border="2" align="center" class="table table-inverse"
			style="width: 70%">
			<tr>
			  <th style="text-align: center">Image</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product price</th>
				<th>Product stock</th>
				<th>Category id</th>
				<th>Edit Product</th>
				<th>Delete Product</th>
			</tr>
			<c:forEach items="${prodlist}" var="prod">
				<tr>
				 
					<tr style="text-align: center"></tr>
						<td><img src="${image}/${prod.productid}.jpg"
							style="width: 100px; height: 100px;">
							</td>
							
				
				
					<td>${prod.productname}</td>
					<td>${prod.productdesc}</td>
					<td>${prod.productprice}</td>
					<td>${prod.productstock}</td>
					<td>${prod.category.categoryid}</td>
					<td><a href="${contextPath}/admin/updatePat/${prod.productid}"><button
								type="button" class="btn btn-primary">Edit</button></a></td>
					<td><a href="${contextPath}/admin/deletePat/${prod.productid}"><button
								type="button" class="btn btn-danger">Delete</button></a></td>
				</tr>
			
				</c:forEach>
		</table>
	</div>

</form:form> 
</body>
</html>
