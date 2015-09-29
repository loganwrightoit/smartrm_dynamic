<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<div class="floating-box round-corners">

			<h3 class="title">Update a Resource</h3>

			<form method="get">
				<div class="form-group">
					<label>Select Resource</label>
					<br>
					<select name="rr_id" onchange="this.form.submit()" class="form-control" required>
						<option value="">Select a Resource</option>
						<c:forEach items="${resources}" var="item">
							<option value="${item.rr_id}" ${rr_id==item.rr_id?'selected':''}>${item.rr_name}</option>
						</c:forEach>
					</select>
				</div>				
			</form>
			
			<form method="post">
				<div class="form-group">
					<label>Name</label>
					<input type="text" class="form-control" name="rr_name" value="${rr_name}" required>
				</div>
				<div class="form-group">
					<label>Capacity</label>
					<input type="number" class="form-control" name="capacity" value="${capacity}" required>
				</div>
				<div class="form-group">
					<label>Special Features</label>
					<br>
					<textarea name="special_features" class="form-control">${special_features}</textarea>
				</div>
				<button type="submit" class="btn btn-default">Save</button>
			</form>
		
		</div>
	
	</jsp:body>
</t:master>
