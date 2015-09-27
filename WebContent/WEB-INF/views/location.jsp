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
			<button type="button" class="btn btn-success" id="newlocation">Add Location</button>&nbsp;
			<button type="button" class="btn btn-success" id="updatelocation">Update Location</button>&nbsp;
			<button type="button" class="btn btn-success" id="deletelocation">Delete Location</button>&nbsp;
		</div>

	</jsp:body>
</t:master>