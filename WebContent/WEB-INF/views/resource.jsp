<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<form method="post">

			<div class="floating-box round-corners">
			
				<h3 class="title">Resource Control Panel</h3>

				<div class="form-group">
					<label>Select Location</label>
					<br>
					<select name="l_id" class="form-control" required>
						<option value="">Select a location</option>
						<c:forEach items="${locations}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label>Select Task</label>
					<br>
					<select name="task" class="form-control" required>
						<option value="">Select a task</option>
						<option value="add_resource">Add Resource</option>
						<option value="update_resource">Update Resource</option>
						<option value="delete_resource">Delete Resource</option>
					</select>
				</div>
	
				<button type="submit" class="btn btn-default">Continue</button>
			
			</div>

		</form>
	
	</jsp:body>
</t:master>