
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/images" var="images"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
	
	<div class= "container">
<div class="row">
	<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-default">
		
		<div class="panel-header">
		<h2 align="center" >Cart</h2>
		</div>
			
			<div class="panel-body">
			
			<c:forEach items="${cartList}" var="user">
		
		<div class="form-group">
		<label >Quantity:</label>
		
		<span><c:out value="${user.quantity}"/></span>	
			
		<label>Product ID:</label>
		
		<span><c:out value="${user.productId}"/></span>
		
		<%--  <label>Product Name:</label>
		
		<span><c:out value="${name}"/></span>  --%>
		
		<label>Total Price:</label>
		
		<span><c:out value="${user.totalPrice}"/></span>
	
		<a href="${contextPath}/CartItem/delete/${user.id}" onclick="myFunction() ">DELETE</a>
			<br>
			</div>
			</c:forEach>
			
			<div class="form-group" align="right">
			
			<label>GRAND TOTAL:</label>
		
		<span><c:out value="${grandTotal}"></c:out></span>
			
			</div>
			
			<div class="form-group" align="right">
		
		<button type="submit" value="checkout" style="color: white;" class="btn btn-default btn-md">CHECKOUT</button>
			
			</div>
			
			
				
	</div>
	</div>
	</div>
	</div>
	</div>
	

	<%@ include file="../shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${js}/scripts.js"></script>
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>