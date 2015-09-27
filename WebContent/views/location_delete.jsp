<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 class="title">Location</h1>
<h2 class="subtitle">Registration Service</h2>
<p>Here you can delete a location.</p>

<form action="DeleteLocation">

    <table>
    	<tr>
    		<td>Enter ID</td>
    		<td><input type="text" name="l_id" /></td>
    	</tr>
        <tr>
            <td>Select Location</td>
            <td>
                <select name="l_name">
                    <option value="A">Location A</option>
                    <option value="B">Location B</option>
                    <option value="C">Location C</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Delete Location"/></td>
        </tr>
    </table>

</form>
</body>
</html>