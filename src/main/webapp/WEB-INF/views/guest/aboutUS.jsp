
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
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
		
			<img align="left" class="img-thumbnail" style="float: left" src="${images}/building-glass.jpg"
				alt="Bros" width="400" height="440">
			
			<div class="panel" align="center">
			
			
			<h1>CONTACT US</h1>
			<h5>Whether you're looking for answers, would
				like to solve a problem, or just want to let us know how we did,
				you'll find many ways to contact us right here. We'll help you
				resolve your issues quickly and easily, getting you back to more
				important things, like relaxing and enjoying your new game.</h5>

			<h3>EMAIL ID:</h3>
			<h5 >lalitsinghadia@gmail.com</h5>

			<h3>CONTACT NO:</h3>
			<h5>USA : +1 3096605684</h5>
			<h5>INDIA : +91 7738134480</h5>


			<h3  >Operating Hours:</h3>
			<h5>Everyday: 9am - 12am (IST)</h5>
			
			</div>
			</div>
			</div>





	<%@ include file="../shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>