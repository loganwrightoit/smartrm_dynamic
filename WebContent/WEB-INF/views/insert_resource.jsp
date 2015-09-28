<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		 
		<h3>Add a New Resource for Location ${l_name}</h3>
	
		<form method="post">
		
			<table>
				<tr>
					<td>Resource Name</td>
					<td><input name="name" type="text" placeholder="Enter Name"/></td>
				</tr>
				<tr>
					<td>Resource Type</td>
					<td>
						<select name="type">
							<option>Select a Resource Type</option>
							<option value="ch">Conference Hall</option>
							<option value="esc">Employee Seating Cubicle</option>
							<option value="mr">Delete Resource</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Seating Capacity</td>
					<td><input name="capacity" type="number" placeholder="Enter Capacity" required/></td>
				</tr>
				<tr>
					<td>Special Features</td>
					<td><textarea name="special_features" placeholder="Enter Special Features"></textarea></td>
				</tr>
			</table>
			
			<input type="submit" value="Create Resource" />
			
		</form>
	
	</jsp:body>
</t:master>