<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="site-wrapper">
	<div class="site-wrapper-inner">
		<div class="cover-container">
			<div class="masthead clearfix">
				<div class="inner">
					<h1 class="masthead-brand"><u>GAME</u><u><span style="color:red;">STOP</span></u></h1>
					<nav>
						<ul class="nav masthead-nav">
							<li class="active"><a href="${contextPath}/index"><span
									class="glyphicon glyphicon-home"></span></a></li>
							<li><a href="${contextPath}/aboutUS">ABOUT US</a></li>
							<li><a href="${contextPath}/ViewProduct">CONSOLES</a></li>
							<li><a href="${contextPath}/ViewProduct">ACCESSORIES</a></li>
							<li><a href="${contextPath}/ViewProduct">GAMES</a></li>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="${contextPath}/Product">ADD PRODUCT</a></li>
							<li><a href="${contextPath}/Category">ADD CATEGORY</a></li>
							<li><a href="${contextPath}/Supplier">ADD SUPPLIER</a></li>
							</sec:authorize>
							
							<sec:authorize access="isAnonymous()">	
							<li><a href="${contextPath}/login"><span
									class="glyphicon glyphicon-shopping-cart"></span></a></li>
							</sec:authorize>	
							
							<sec:authorize access="hasRole('ROLE_USER')">	
							<li><a href="${contextPath}/Cart"><span
									class="glyphicon glyphicon-shopping-cart"></span></a></li>
							</sec:authorize>
					
							
							<sec:authorize access="isAnonymous()">
							<li><a href="${contextPath}/login"><span
									class="glyphicon glyphicon-user"></span></a></li>
							<li><a href="${contextPath}/SignUP">SIGN UP</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li><a href="${contextPath}/logout">LOGOUT</a></li>
							</sec:authorize>
						</ul>
					</nav>
				</div>
			</div>     
		</div>
	</div>
</div>
