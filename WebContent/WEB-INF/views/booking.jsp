<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<div class="floating-box round-corners">
			
			<h3 class="title">Booking Control Panel</h3>
	
	
			<form method="get">
			
				<div class="form-group">
					<label>Select Location</label>
					<br>
					<select id="location" name="blocation" onchange="this.form.submit()" class="form-control">
				        <option value="nolocation">Select a Location</option>
				        <c:forEach items="${locations}" var="d">
				        	<option value="${d}" ${d==pickedlocation?'selected':''}>${d}</option>
				        </c:forEach>
				    </select>
				</div>

				
				<div class="form-group">
					<label>Select Resource</label>
					<br>
					<select id="resource" name="bresource" onchange="this.form.submit()" class="form-control">
				        <option value="noresource">Select a Resource</option>
				        <c:forEach items="${resources}" var="d">
				        	<option value="${d}" ${d==pickedresource?'selected':''}>${d}</option>
				        </c:forEach>
					</select>
				</div>

				<input type="submit" class="btn btn-default" id="newbooking" name="book" value="New Booking">
				<input type="submit" class="btn btn-default" id="deletebooking" name="book" value="Delete Booking"/>
				
			</form>
		
		</div>
		
	</jsp:body>
</t:master>