<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<h1 class="title">Select a location</h1>
		
		NOTE: Need to populate this dropdown with business logic
		<select id="location">
			<option>Select a location</option>
			<option value="mr">Location A</option>
			<option value="ch">Location B</option>
			<option value="esc">Location C</option>
		</select>
		
		<br>
		
		<div class="nav">
			<a class="btn" href="InsertLocation">Add Location</a>&nbsp;
			<a class="btn" href="UpdateLocation">Update Location</a>&nbsp;
			<a class="btn" href="DeleteLocation">Delete Location</a>&nbsp;
			<a class="btn" href="LocationSummary">View Locations</a>&nbsp;
			
		</div>

	</jsp:body>
</t:master>