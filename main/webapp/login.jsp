<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
		
</head>
<body>
	<div style= 
			"position: fixed;
  			top: 10%;
  			left: 50%;
  			transform: translate(-50%, -50%);">
		<h2> Login </h2>
	</div>
	<form action=LoginServlet method=post>
		<div style= 
			"position: fixed;
  			top: 25%;
  			left: 50%;
  			transform: translate(-50%, -50%);">
  			
			<table class="table">
				<tr>
					<th>Enter Name:</th>
					<td><input type=text name=txtName></td>
				</tr>
				<tr>
					<th> Enter Password: </th>
					<td> <input type=text name=txtPassword>
					</td>
				</tr>
				<tr align = center>
					<td> <input class = "button" type=submit value=Login> </td>
					<td> <a href="http://localhost:8080/demo.jsp/register.jsp"> Register</a> </td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>