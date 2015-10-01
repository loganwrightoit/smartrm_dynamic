<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="Master Page template" pageEncoding="UTF-8" %>

<html>
	<head>
		<title>SMART Resource Management</title>
		<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="styles/stylesheet.css"/>
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
	</head>
	<body>
		<div class="inner-wrapper floating-box">
			  
			<header>
				<a href="index.jsp"><img src="images/banner_small.png"></img></a>
				<nav class="navbar navbar-default dark-border">
					<div class="container-fluid" style="padding: 0; margin: 0;">
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding: 0; margin: 0;">
							<ul class="nav navbar-nav" style="width: 100%;">
								<li>
									<a href="index.jsp">
										<img src="images/sbutton.png" height="20px" width="20px"></img>
									</a>
								</li>
								<li><a href="Main">Home</a></li>
								<c:if test="${u_level=='admin'}">
									<li><a href="Location">Location</a></li>
									<li><a href="Resource">Resource</a></li>
								</c:if>
								<li><a href="Booking">Booking</a></li>
								<li class="login-status"><small>Logged in as ${u_name} (<a href="Logout">Logout</a>)</small></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
			
			<div class="content">
			
					<c:if test="${not empty error}">
						<div class="floating-box round-corners">
					    	<h4 class="failure">${error}</h4>
					    </div>
					</c:if>
					
					<c:if test="${not empty message}">
						<div class="floating-box round-corners">
					    	<h4 class="failure">${message}</h4>
					    </div>
					</c:if>
					
					<c:if test="${not empty param.success}">
						<div class="floating-box round-corners">
					    	<h4 class="donecreation">${param.success}</h4>
					    </div>
					</c:if>
			
				<jsp:doBody/>
				
			</div>
			 
			<footer class="dark-border round-corners">
				<div>Copyright &copy; 2015</div>
			</footer>
		
		</div>
	</body>
</html>