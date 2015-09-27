<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>SMART Resource Management - Login</title>
        <link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css"/>
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <div class="inner-wrapper floating-box">
        
	        <header>
	       		<img src="images/banner_medium.png"></img>
	       	</header>
        
            <div class="login-content" style="text-align: center;">
            	<div class="login floating-box round-corners">
            		<h1 class="title">Please Login</h1>
	
					<c:if test="${not empty message}">
					    <h3 class="failure">${message}</h3>
					</c:if>
					
					<form method="post">
						<table>
							<tr>
								<td>Username</td>
								<td><input type="text" name="u_name" placeholder="Enter Username" required/></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="password" name="u_pass" placeholder="Enter Password" required/></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="Login"/></td>
							</tr>
						</table>
					</form>
            	</div>
            					            	            	
            </div>
                                
	        <footer class="dark-border round-corners">
	            <div>Copyright &copy; 2015</div>
	        </footer>
            
        </div>


    </body>
</html>