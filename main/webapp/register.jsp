<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div align=center>
		<h1>Register page</h1>
	</div>
	<form action=RegisterServlet method=post>
		<table>
			<tr>
				<td>Enter Name:</td>
				<td><input type=text name=txtName></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td> <input type=text name=txtPassword> </td>
			</tr>
			
			<tr>
				<td>Enter Age:</td>
				<td> <input type=text name=txtAge> </td>
			</tr>
			
			<tr>
				<td>Enter the number of years you have drank:</td>
				<td> <input type=text name=txtYears> </td>
			</tr>
			
			<tr>
				<td><input type=submit value=Register></td>
			</tr>


		</table>
	</form>

</body>
</html>