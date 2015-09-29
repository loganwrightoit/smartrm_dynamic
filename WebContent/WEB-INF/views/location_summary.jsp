<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<div class="floating-box round-corners">
		
			<h3 class="title">Location Summary</h3>
			
			<table class="table table-striped">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Phone</th>
					<th>Head</th>
					<th>City</th>
					<th>Country</th>
					<th>Time Zone</th>
				</tr>
				<c:forEach items="${locations}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.phone}</td>
						<td>${item.head}</td>
						<td>${item.city}</td>
						<td>${item.country}</td>
						<td>${item.timezone}</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	
	</jsp:body>
</t:master>