<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People</title>
</head>
<body>
	<h1>Search for people you know</h1>
	<div class="topnav">
		<form action=SearchServlet method=post>
			<table>
				<tr> 
					<td> <input type="text" placeholder="Search.." name=txtSearch> </td>
				</tr>
				<tr>
					<td> <input type=submit value=Search> </td> 
				</tr>
			</table>
		</form>
	</div>
</body>
</html>