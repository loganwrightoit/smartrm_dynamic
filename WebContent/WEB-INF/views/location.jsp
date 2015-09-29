<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<div class="floating-box round-corners">
		
			<h3 class="title">Location Control Panel</h3>

			<div class="nav">
				<a class="btn btn-default" href="InsertLocation">Add Location</a>&nbsp;
				<a class="btn btn-default" href="UpdateLocation">Update Location</a>&nbsp;
				<a class="btn btn-default" href="DeleteLocation">Delete Location</a>&nbsp;
				<a class="btn btn-default" href="LocationSummary">View Locations</a>
			</div>
		
		</div>

	</jsp:body>
</t:master>