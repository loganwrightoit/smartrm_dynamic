<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<p>
		<center>
		<form>
		<table>
			
			<tr><td><h1 class="title">Select a location</h1></td></tr>
			<tr><td>
			<select id="location">
				<option>Select a location</option>
				<option value="a">Location A</option>
				<option value="b">Location B</option>
				<option value="c">Location C</option>
			</select>
			</td></tr>
			
			<tr><td><h1 class="title">Select a resource</h1></td></tr>
			<tr><td>
			<select id="rresource">
				<option>Select a resource</option>
				<option value="mr">Meeting Room</option>
				<option value="ch">Conference Hall</option>
				<option value="esc">Employee Cubicle</option>
			</select>
			</td></tr>
			<tr>
			<td colspan="3">
			<div class="nav">
		
			<br>
			<button type="button" class="btn btn-success" id="newresource">Add Resource</button>&nbsp;
			<button type="button" class="btn btn-success" id="updateresource">Update Resource</button>&nbsp;
			<button type="button" class="btn btn-success" id="deleteresource">Delete Resource</button>&nbsp;
			</div>
			</td>
			</tr>
		</table>
		</form>
		</center>	
	
	</jsp:body>
</t:master>