<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
		<!-- 
		CREATE TABLE locationresource
		(
			r_id number primary key,
			r_name char(10) not null,
			r_type varchar(10),
			description varchar(1000)
		);
		
		CREATE TABLE registeredresource
		(
			rr_id number primary key,
			rr_name varchar(20) not null,
			l_id number not null,
			r_id number not null,
			special_features varchar(1000),
			capacity number,
			constraint fklocid foreign key (l_id) references location(l_id),
			constraint fkresid foreign key (r_id) references locationresource(r_id)
		);
		
		 -->
		 
		<h3>Add a New Resource for location ${l_name}</h3>
	
		<form action="InsertResource" method="post">
		
			<table>
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