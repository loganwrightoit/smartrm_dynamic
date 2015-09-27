<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="title">Employee Seating Cubicles</h1>
<h2 class="subtitle">Booking Service</h2>
<p>Here you can make a reservation for a cubicle.</p>

<form>
    <table>
        <tr>
            <td>Cubicle Id</td>
            <td colspan="2"><input type="text" placeholder="Enter cubicle Id" required/></td>
        </tr>
        <tr>
            <td>Reserve From</td>
            <td><input type="date" required/></td>
        </tr>
        <tr>
            <td>To</td>
            <td><input type="date" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Make Reservation"/></td>
        </tr>
    </table>
</form>
