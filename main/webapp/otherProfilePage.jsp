<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${param.name}</title>
</head>
<body>
	<h1>${param.name}</h1>
	<%
	String username = request.getParameter("name");
	;
	%>
	<%@ page import="database.UserLandingPageDao, java.util.HashMap"%>
	<%
	UserLandingPageDao mainpage = new UserLandingPageDao();
	HashMap<String, String> data = mainpage.getData(username);
	%>

	<table>
		<tr>
			<td>Drinks:</td>
			<td><%=data.get("Drinks")%></td>
		</tr>
		<tr>
			<td>Drink Years:</td>
			<td><%=data.get("DrinkYears")%></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td><%=data.get("Age")%></td>
		</tr>
		<tr>
			<td>Awards:</td>
			<td><%=data.get("Awards")%></td>
		</tr>
		<tr>
			<td>Weight Class:</td>
			<td><%=data.get("WeightClass")%></td>
		</tr>
	</table>
</body>
</html>