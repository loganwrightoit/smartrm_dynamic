<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<h2 align="center">Location Summary</h2>
	
		<div class="floating-box round-corners">
			<table class="table table-striped">
				<tr class="heading">
					<td>Name</td>
					<td>Description</td>
					<td>Phone</td>
					<td>Head</td>
					<td>City</td>
					<td>Country</td>
					<td>Time Zone</td>
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