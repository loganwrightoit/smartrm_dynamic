<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<div class="floating-box round-corners">

			<h3 class="title">Delete a Resource</h3>

			<form method="get">
				<div class="form-group">
					<label>Select Location</label>
					<br>
					<select name="l_id" onchange="this.form.submit()" class="form-control" required>
						<option value="">Select a Location</option>
						<c:forEach items="${locations}" var="item">
							<option value="${item.id}" ${l_id==item.id?'selected':''}>${item.name}</option>
						</c:forEach>
					</select>
				</div>				
			</form>
			
			<form method="post">
				<div class="form-group">
					<label>Description</label>
					<br>
					<textarea name="description" class="form-control" style="background-color: rgb(238,238,238);" disabled>${description}</textarea>
				</div>
				<div class="form-group">
					<label>City</label>
					<input type="text" class="form-control" name="city" value="${city}" disabled>
				</div>
				<div class="form-group">
					<label>Country</label>
					<input type="text" class="form-control" name="country" value="${country}" disabled>
				</div>
				<button type="submit" class="btn btn-default">Delete</button>
			</form>

		</div>

	</jsp:body>
</t:master>