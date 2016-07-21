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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>PING</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/menu.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
 -->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<%@ include file="../shared/menu.jsp"%>
<br>
<br>
<br>
<br>

<div class="container-search">
<div class="col">
  
  <form class="navbar-form" role="search">
    <div class="input-group add-on">
      <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term" >
      <div class="input-group-btn">
        <button class="btn btn-default btn-btn-lg" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      </div>
    </div>
  </form>
  
  
</div>
</div>



<table border=1 class = "table table-condensed">
				<thead>
					<tr>
						<th align="center" width="120">Id</th>
						<th align="center" width="120">Name</th>
						<th align="center" width="200">Description</th>
						<th align="center" width="120">Price</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<th align="center" width="120">Category Id</th>
						<th align="center" width="120">Supplier Id</th>
						</sec:authorize>
						<th align="center" width="120">View</th>
						<th align="center" width="120">ADD to CART</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<th align="center" width="120">Delete</th>
						<th align="center" width="120">Edit</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody style="background-color:white;">
					<c:forEach items="${productList}" var="user">
						<tr>
							<td style=" text-align: centre"><c:out value="${user.id}" /></td>
							<td style=" text-align: centre"><c:out value="${user.name}" /></td>
							<td style=" text-align: centre"><c:out value="${user.description}" /></td>
							<td style=" text-align: centre"><c:out value="${user.price}" /></td>
							<td style=" text-align: centre"><c:out value="${user.categoryId}" /></td>
							<td style=" text-align: centre"><c:out value="${user.supplierId}" /></td>
							<td style=" text-align: centre"><a href="${contextPath}/Product/View/${user.id}">VIEW</a></td>
							<td style=" text-align: centre"><a href="${contextPath}/Product/AddToCart/${user.id}">ADD</a></td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
							<td style=" text-align: centre"><a href="${contextPath}/Product/delete/${user.id}">DELETE</a></td>
							<td style=" text-align: centre"><a href="${contextPath}/Product/edit/${user.id}">EDIT</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@ include file="../shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	
</body>
</html>