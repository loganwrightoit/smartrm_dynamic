<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		<form method="get">
		<table>
		
		<tr><td><h1 class="title">Select a location</h1><td><tr>
		<tr><td colspan="2">
		<select id="location" name="blocation" onchange="this.form.submit()">
		        <option value="nolocation">Select a Location</option>
		        <c:forEach items="${locations}" var="d">
		        	<option value="${d}"<c:if test="${d.equals( pickedlocation ) }"> selected="selected" </c:if>      >${d}</option>
		        </c:forEach>
		</select>
		</td><tr>
		
		<tr><td><h1 class="title">Select a resource</h1></td></tr>
		
		<tr><td>
		<select id="resource" name="bresource" onchange="this.form.submit()">
		        <option value="noresource">Select a Resource</option>
		        <c:forEach items="${resources}" var="d">
		        	<option value="${d}"<c:if test="${d.equals( pickedresource ) }"> selected="selected" </c:if>      >${d}</option>
		        </c:forEach>
		</select>
		</td></tr>
		
					           	
	           		<c:if test="${not empty message}">
					    <h4 class="failure">${message}</h4>
					</c:if>
		
		<tr>
		<div class="nav">
		
		<td>
		<br>
		<input type="submit" class="btn btn-success" id="newbooking" name="book" value="New Booking">
		
		<input type="submit" class="btn btn-success" id="deletebooking" name="book" value="Delete Booking"/>
		</td>
		</div>
		</tr>
		</table>
		</form>
	</jsp:body>
</t:master>