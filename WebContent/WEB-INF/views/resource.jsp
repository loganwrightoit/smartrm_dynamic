<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<form method="post">

			<h4>Select a location</h4>
			<select name="l_id">
				<option>Select a location</option>
				<c:forEach items="${locations}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
			
			<select name="task">
				<option>Select a task</option>
				<option value="add_resource">Add Resource</option>
				<option value="update_resource">Update Resource</option>
				<option value="delete_resource">Delete Resource</option>
			</select>

			<input type="submit" value="Continue" />

		</form>
	
	</jsp:body>
</t:master>