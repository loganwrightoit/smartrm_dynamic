<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="welcome-image-container">
	<img src="images/conferencehall.jpg" alt="Conference Hall" style="max-height: 150px; display: inline;"></img>
	<img src="images/cubicles.jpg" alt="Cubicles" style="max-height: 150px; display: inline;"></img>
	<img src="images/meetingroom.jpg" alt="Meeting Room" style="max-height: 150px; display: inline;"></img>
</section>

<div style="padding: 0 20px 0 20px;">

	<h1 class="title">Welcome ${u_name},</h1>
	
	<c:choose>
		<c:when test="${u_level=='admin'}">
			<p>This is the SMART Resource Management web portal.  From here you can add, update, or remove locations and resources.  You can also make future reservations for location resources.</p>
		</c:when>
		<c:otherwise>
			<p>This is the SMART Resource Management web portal.  From here you can make future reservations for location resources, or cancel existing bookings that you have made.</p>
		</c:otherwise>
    </c:choose>
		
	<h3>Navigation Tips</h3>
	<ul>
		<c:if test="${u_level=='admin'}">
			<li>You can add, edit, or remove locations by selecting <em>Location</em> from the navigation bar.</li>
			<li>You can add, edit, or remove resources by selecting <em>Resource</em> from the navigation bar.</li>
		</c:if>
		<li>You can make reservations for resources, or cancel existing reservations by selecting <em>Booking</em> from the navigation bar.</li>
	</ul>

</div>