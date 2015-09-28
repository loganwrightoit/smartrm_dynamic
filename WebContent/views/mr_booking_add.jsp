<%@ page language="java" %>
		<h1 class="title">Register Meeting Room</h1>
		<form id="form1" name="form1" method="post" action="Booking">
			<table>
				<tr>
				<td>Room name</td>
				<td><input type="text" name="roomname" placeholder="Enter room name" /></td>
				</tr>
				<br>
				<tr>
				<td>Location:</td>
				<td><label>${location}</label></td>
				</tr>
				<br>
				<tr>
				<td>capacity:</td>
				<td><input type="number" name="capacity" placeholder="Enter room capacity" /></td>
				<br>
				<tr>
				<td>Description:</td>
				<td><textarea rows="5" cols="22" name="description"> </textarea></td>
				</tr>
				<br>
				<tr>
				<td colspan="2"><input type="submit" value="register meeting room" name="submit" /></td>
				</table>
		</form>
	