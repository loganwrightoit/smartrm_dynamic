<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		<form method="post">
		
		
		<h1 class="title">Register Meeting Room</h1>
			<table>
				<tr>
				<td>Room name</td>
				<td><input type="text" name="roomname" placeholder="Enter room name" /></td>
				</tr>
				
				<br>
				
				<tr>
				<td>Location:</td>
				<td>
					${pickedlocation}
				</td>
				</tr>
				
				<br>
				
				<tr>
				<td>capacity:</td>
				<td><input type="number" name="capacity" placeholder="Enter room capacity" /></td>
				</tr>
				
				<br>
				
				<tr>	
				<td>special requests</td>
				<td><input type="text" name="specialrequests" placeholder="Enter special requests" /></td>
				</tr>
				
				<br>
				
				<tr>	
				<td>purpose</td>
				<td><input type="text" name="purpose" placeholder="purpose" /></td>
				</tr>
				
				<tr>
				<td>Special Features:</td>
				<td><textarea rows="5" cols="22" name="specialfeatures"> </textarea></td>
				</tr>
				
				<br>
				
				<tr>
				<td>Start Time:</td>
				<td><input type="datetime" name="starttime"> </textarea></td>
				</tr>
				
				<br>
				
				<tr>
				<td>End Time:</td>
				<td><input type="datetime" name="endtime"> </textarea></td>
				</tr>
				
				<br>
				
				<tr>
				<td colspan="2"><input type="submit" value="register meeting room" name="submit" /></td>
				</tr>
				</table>
		</form>
	</jsp:body>
</t:master>