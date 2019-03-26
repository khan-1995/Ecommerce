<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<form:form id="catForm" modelAttribute="category"
		action="${contextPath}/admin/catprocess" method="post">

		<div class="table-responsive">

			<center>
				<h2>category form</h2>
			</center>
			</br>

			<div class="container">

				<div class="row">

					<div class=col-sm-3></div>

					<div class="col-sm-6">

						<div class="form-group">

							<form:input path="categoryid" type="hidden" />

							<label for="categoryname">category Name:</label>

							<form:input path="categoryname" name="categoryname"
								id="categoryname" required="true" class="form-control" />

						</div>

						<div class="form-group">

							<label for="categorydescription">category Description:</label>
							<form:input path="categorydescription" name="categorydescription"
								id="categorydescription" class="form-control" />

						</div>


						<button type="submit" class="btn btn-default">Add
							category</button>

					</div>

				</div>

			</div>

		</div>






		<div class="table-responsive">

			<table border="2" align="center" class="table table-inverse"
				style="width: 70%">

				<tr>

					<th>category Name</th>

					<th>category Description</th>

					<th>Edit category</th>

					<th>Delete category</th>



				</tr>

				<c:forEach items="${catlist}" var="cat">



					<tr>

						<td>${cat.categoryname}</td>

						<td>${cat.categorydescription}</td>

						<td><a
							href="${contextPath}/admin/updateCat/${cat.categoryid}"><button
									type="button" class="btn btn-primary">Edit</button></a></td>

						<td><a
							href="${contextPath}/admin/deleteCat/${cat.categoryid}"><button
									type="button" class="btn btn-danger">Delete</button></a></td>





					</tr>

				</c:forEach>

			</table>

		</div>

	</form:form>
</body>
</html>