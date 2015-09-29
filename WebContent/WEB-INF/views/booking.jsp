<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		<form method="post">
		<table>
		
		<tr><td><h1 class="title">Select a location</h1><td><tr>
		<tr><td colspan="2">
		<select id="location" name="blocation">
		        <option value="nolocation">Select a Location</option>
		        <c:forEach items="${locations}" var="d">
		        	<option value="${d}">${d}</option>
		        </c:forEach>
		</select>
		</td><tr>
		
		<tr><td><h1 class="title">Select a resource</h1></td></tr>
		
		<tr><td>
		<select id="resource" name="bresource">
		        <option value="noresource">Select a Resource</option>
			<option value="mr">Meeting Rooms</option>
			<option value="ch">Conference Hall</option>
			<option value="esc">Employee Seating Cubicles</option>
		</select>
		</td></tr>
		
		<tr>
		<div class="nav">
		
		<td>
		<br>
		<input type="submit" class="btn btn-success" id="newbooking" name="nb" value="New Booking">
		
		<input type="submit" class="btn btn-success" id="deletebooking" name="db" value="Delete Booking"/>
		</td>
		</div>
		</tr>
		</table>
		</form>
	</jsp:body>
</t:master>