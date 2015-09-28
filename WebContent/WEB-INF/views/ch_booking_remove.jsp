<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		<h1 class="title"><center>Remove Conference Hall</center></h1>
	
	<p>
	<center>
	<form method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" Required></td>
			</tr>
					
			<tr>
				<td>Room Number:</td>
				<td><input type="number" min="1" name="roomnumber" Required></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Remove"/></td>
			</tr>
		</table>
	</form>
	</center>
	</p>
		
	</jsp:body>
</t:master>