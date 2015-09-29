<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
	
<h1 class="title">Employee Seating Cubicles</h1>
<h2 class="subtitle">Booking Service</h2>
<p>Here you can cancel a reservation for a cubicle.</p>

<form method="post">
    <table>
			<tr>
				<td>Resource name:</td>
				<td><input type="number" min="1" name="r_name" Required></td>
			</tr>
			<tr>
				<td>Booking ID:</td>
				<td><input type="number" min="1" name="b_id" Required></td>
			</tr>
    </table>
    <p>Will show selectable bookings in a table here...</p>
    <input type="submit" value="Cancel Reservation"/>
</form>
	</jsp:body>
</t:master>