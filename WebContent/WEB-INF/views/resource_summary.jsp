<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<h2 align="center">Resource Summary for ${l_name}</h2>
	
		<div class="floating-box round-corners">
			<table class="table table-striped">
				<tr>
					<th>Name</th>
					<th>Resource Type</th>
					<th>Capacity</th>
					<th>Special Features</th>
				</tr>
				<c:forEach items="${resources}" var="item">
					<tr>
						<td>${item.rr_name}</td>
						<td>${item.r_name}</td>
						<td>${item.capacity}</td>
						<td>${item.special_features}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</jsp:body>
</t:master>