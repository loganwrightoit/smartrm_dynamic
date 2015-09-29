<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<div class="floating-box round-corners">
		
			<h3 class="title">Delete a Resource</h3>
	
			<div class="form-group">
				<label>Select Resource</label>
				<br>
				<form method="get">
					<select name="rr_id" onchange="this.form.submit()" class="form-control" required>
						<option value="">Select a Resource</option>
						<c:forEach items="${resources}" var="item">
							<option value="${item.rr_id}" ${rr_id==item.rr_id?'selected':''}>${item.rr_name}</option>
						</c:forEach>
					</select>
				</form>
			</div>
			
			<form method="post">
				<div class="form-group">
					<label>Name</label>
					<input type="text" class="form-control" value="${rr_name}" disabled>
				</div>
				<div class="form-group">
					<label>Capacity</label>
					<input type="number" class="form-control" value="${capacity}" disabled>
				</div>
				<div class="form-group">
					<label>Special Features</label>
					<textarea style="background-color: rgb(238,238,238);" class="form-control" disabled>${special_features}</textarea>
				</div>
				<button type="submit" class="btn btn-default">Delete</button>
			</form>
		
		</div>
	
	</jsp:body>
</t:master>
