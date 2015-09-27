<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<table>
		
		<tr><td><h1 class="title">Select a location</h1><td><tr>
		<tr><td colspan="2">
		<select id="location">
		        <option value="locationselect">Select a Location</option>
			<option value="A">Location A</option>
			<option value="B">Location B</option>
			<option value="C">Location C</option>
		</select>
		</td><tr>
		
		<tr><td><h1 class="title">Select a resource</h1></td></tr>
		
		<tr><td>
		<select id="resource">
		        <option value="resourceselect">Select a Resource</option>
			<option value="mr">Meeting Rooms</option>
			<option value="ch">Conference Hall</option>
			<option value="esc">Employee Seating Cubicles</option>
		</select>
		</td></tr>
		
		<tr>
		<div class="nav">
		
		<td>
		<br>
		<button type="button" class="btn btn-success" id="newbooking">New Booking</button>
		
		<button type="button" class="btn btn-success" id="deletebooking">Delete Booking</button>
		</td>
		</div>
		</tr>
		</table>

	</jsp:body>
</t:master>