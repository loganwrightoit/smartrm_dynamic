<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <!--
                <div class="home">Home</div>
                <div class="resource">Resource</div>
                <div class="booking">Booking</div>
                <hr>
                -->
                <nav class="navbar navbar-default dark-border">
                    <div class="container-fluid" style="padding: 0; margin: 0;">
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding: 0; margin: 0;">
                            <ul class="nav navbar-nav" style="width: 100%;">
                            	<li>
                            		<a href="index.jsp">
                                		<img src="images/sbutton.png" height="20px" width="20px"></img>
                            		</a>
                            	</li>
	                            <li id="home" class="active"><a>Home</a></li>
	                            <li id="location"><a>Location</a></li>
	                            <li id="resource"><a>Resource</a></li>
	                            <li id="booking"><a>Booking</a></li>
	                            <li class="login-status"><small>Logged in as ${u_name} (<a href="Logout">Logout</a>)</small></li>
                            </ul>
                        </div><!-- /.navbar-collapse -->

                    </div><!-- /.container-fluid -->
                </nav>
            </header>
            <div class="content">
            	
            	<!--  Content gets loaded here -->
				            	            	
            </div>
            <footer class="dark-border round-corners">
                <div>Copyright &copy; 2015</div>
            </footer>
        </div>

    </body>
</html>