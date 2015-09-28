<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<jsp:body>
		<h1 class="title">Delete Meeting Room</h1>
		<form method="post">
			<p>Name: </p> 
			<input type="text" name="roomname" />
			<br>
			<p>Location: </p>
			<select>
				<option>A</option>
				<option>B</option>
				<option>C</option>
			</select>
			<br>
			<select>

			</select>
			<br>
			<input type="submit" value="Delete Meeting Room" />
			<br>
		</form>
	</jsp:body>
</t:master>