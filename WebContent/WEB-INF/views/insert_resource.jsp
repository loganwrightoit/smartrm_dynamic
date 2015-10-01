<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>

		<form method="post">
		
<<<<<<< HEAD
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
							<option value="mr">Meeting Room</option>
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
=======
			<div class="floating-box round-corners">
		
				<h3 class="title">Create a New Resource</h3>

				<div class="form-group">
					<label>Resource Name</label>
					<br>
					<input name="name" type="text" class="form-control" placeholder="Enter resource name" required/>
				</div>

				<div class="form-group">
					<label>Resource Type</label>
					<br>
					<select name="type" class="form-control" required>
						<option value="">Select a Resource Type</option>
						<option value="ch">Conference Hall</option>
						<option value="esc">Employee Seating Cubicle</option>
						<option value="mr">Meeting Room</option>
					</select>
				</div>

				<div class="form-group">
					<label>Seating Capacity</label>
					<br>
					<input name="capacity" type="number" class="form-control" placeholder="Enter Capacity" required/>
				</div>
				
				<div class="form-group">
					<label>Special Features</label>
					<br>
					<textarea name="special_features" class="form-control" placeholder="Enter Special Features"></textarea>
				</div>
				
				<button type="submit" class="btn btn-default">Create</button>
>>>>>>> 067d4fdea2a96f28c3328f9e8babf1489d864db6
			
			</div>
			
		</form>
	
	</jsp:body>
</t:master>