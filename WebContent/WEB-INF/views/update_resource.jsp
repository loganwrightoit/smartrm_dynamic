<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<h3>Update a Resource</h3>
		
		<form method="get">		
			<h4>Select a Resource</h4>
			<select name="rr_id" onchange="this.form.submit()">
				<option>Select a Resource</option>
				<c:forEach items="${resources}" var="item">
					<option value="${item.rr_id}">${item.rr_name}</option>
				</c:forEach>
			</select>
		</form>
		
		<form method="post">
			<div class="form-group">
				<label for="aName">Name</label>
				<input type="text" class="form-control" id="aName" value="${rr_name}">
			</div>
			<div class="form-group">
				<label for="aCapacity">Capacity</label>
				<input type="number" class="form-control" id="aCapacity" value="${capacity}">
			</div>
			<div class="form-group">
				<label for="aSpecial">Special Features</label>
				<textarea>${special_features}</textarea>
			</div>
			<button type="submit" class="btn btn-default">Save</button>
		</form>
	
	</jsp:body>
</t:master>
