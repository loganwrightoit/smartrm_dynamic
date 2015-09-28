<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		
<h1 class="title">Employee Seating Cubicles</h1>
<h2 class="subtitle">Booking Service</h2>
<p>Here you can make a reservation for a cubicle.</p>

<form method="post">
    <table>
        <tr>
            <td>Cubicle Id</td>
            <td colspan="2"><input type="text" placeholder="Enter cubicle Id" name="cubicleid" required/></td>
        </tr>
        <tr>
            <td>Reserve From</td>
            <td><input type="date" name="reservefrom" required/></td>
        </tr>
        <tr>
            <td>To</td>
            <td><input type="date" name="to" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Make Reservation"/></td>
        </tr>
    </table>
</form>
	</jsp:body>
</t:master>