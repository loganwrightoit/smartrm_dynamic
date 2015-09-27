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
        
            <div class="login-content">
            	<div class="login floating-box round-corners">
            								
					<form method="post">
						<table>
							<tr>
								<td colspan="2" align="center"><h2>Please Login</h2></td>
							</tr>
							<tr>
								<td>Username</td>
								<td><input type="text" name="u_name" placeholder="Enter Username" required/></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="password" name="u_pass" placeholder="Enter Password" required/></td>
							</tr>
						</table>
						<br>
						<input class="btn btn-default" type="submit" value="Login"/>						
					</form>
										           	
	           		<c:if test="${not empty message}">
					    <h4 class="failure">${message}</h4>
					</c:if>
					
            	</div>            					            	            	
            </div>
                                
	        <footer class="dark-border round-corners">
	            <div>Copyright &copy; 2015</div>
	        </footer>
            
        </div>


    </body>
</html>