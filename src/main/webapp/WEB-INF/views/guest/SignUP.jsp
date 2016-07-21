

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/images" var="images"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Registration</title>

<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/registration.css" rel="stylesheet">

<link href="${css}/menu.css" rel="stylesheet">


</head>

<body class="body">
<form:form action="${contextPath}/register" modelAttribute="userModel" method="post">

<%@ include file="../shared/menu.jsp"%>

<br>
<br>
<br>
<br>
<div class="container">

	<table class="table table-bordered table-striped">

		<thead>

			<tr>

				<th>Registration</th>

			</tr>
			
		</thead>
		
		<tbody>
			<tr>
				<td >Id:<form:hidden path="id" /></td>
				</tr>
				<tr bgcolor="lime">
					<td>Name:<form:input type="text"  path="name" class="form-control" /></td>
				</tr>
				<tr>
					<td >Contact NO:<form:input type="text" path="contactNumber" class="form-control" /></td>
				</tr>
				<tr bgcolor="lime">
					<td >Email ID:<form:input type="text" path="email_Id" class="form-control" /></td>
				</tr>
				<tr>
					<td >Password:<form:password path="password" class="form-control" /></td>
				</tr>
				<tr bgcolor="lime">
					<td >Confirm Password:<form:password path="confirmPassword" class="form-control" /></td>
				</tr>
				
				<tr align="center" >
					<td><button type="submit" class="btn btn-info btn-sm" name="Submit">Submit</button>
					</td>
				</tr>
		</tbody>

	</table>

</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</form:form>
</body>
</html>