<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align=center>
		<h1>Login page</h1>
	</div>
	<form action=LoginServlet method=post>
		<table>
			<tr>
				<td>Enter Name:</td>
				<td><input type=text name=txtName></td>
			</tr>
			<tr>
				<td> Enter Password: </td>
				<td>> <input type=text name=txtPassword>
				</td>
			</tr>
			<tr>
				<td><input type=submit value=Login></td>
				<td> <a href="http://localhost:8080/demo.jsp/register.jsp"> Register</a> </td>
			</tr>
			

		</table>
	</form>

</body>
</html>