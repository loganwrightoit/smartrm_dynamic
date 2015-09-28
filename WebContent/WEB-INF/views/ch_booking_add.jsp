<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
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
				<td>Date:</td>
				<td><input type="date" name="date" Required></td>
			</tr>

			<tr>
				<td>Time:</td>
				<td><input type="text" placeholder="2:00pm - 3:00pm" name="time" Required>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Book"/></td>
			</tr>
		</table>
	
		
		</form>
	</jsp:body>
</t:master>