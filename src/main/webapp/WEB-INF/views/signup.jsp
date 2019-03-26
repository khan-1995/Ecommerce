<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<form:form action="signup" modelAttribute="user">
Name:<form:input required="required" path="name" />
		<br>
Email:<form:input required="required" path="email_id" />
		<br>
Address:<form:input  required="required" path="address" />
		<br>
PrimaryMobile:<form:input required="required" path="primary_mobile" />
		<br>
SecondaryMobile:<form:input required="required" path="secondary_mobile" />
		<br>
password:<form:input type="password" required="required" path="password" />
		<br>
		<input type="submit" value="GO">
	</form:form>
</body>
</html>
