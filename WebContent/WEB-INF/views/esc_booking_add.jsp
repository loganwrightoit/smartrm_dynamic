<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		
<h1 class="title">Employee Seating Cubicles</h1>
<h2 class="subtitle">Booking Service</h2>
<p>Here you can make a reservation for a cubicle.</p>

<form method="post">
		<table>
			<tr>
				<td>Location Id:</td>
				<td><input type="number" name="l_id" Required></td>
			</tr>
			<tr>
				<td>Resource Id:</td>
				<td><input type="number" name="rr_id" Required></td>
			</tr>
					
			<tr>
				<td>User Id:</td>
				<td><input type="number" name="u_id" Required></td>
			</tr>
			
			<tr>
				<td>Start Time:</td>
				<td><input type="datetime" name="start_time" Required></td>
			</tr>

			<tr>
				<td>End Time:</td>
				<td><input type="datetime" name="end_time" Required></td>
			</tr>
			
			<tr>
				<td>Special Requests:</td>
				<td><input type="text" name="special_requests" Required></td>
			</tr>
			
			<tr>
				<td>Purpose:</td>
				<td><input type="text" name="purpose" Required></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Book"/></td>
			</tr>
		</table>
</form>
	</jsp:body>
</t:master>