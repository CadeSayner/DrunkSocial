<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>Login succesful ${user_name}
	<% String username= (String)request.getSession().getAttribute("user_name"); %>
	<%@ page import="database.UserLandingPageDao, java.util.HashMap" %>
	<%
		UserLandingPageDao mainpage = new UserLandingPageDao();
		HashMap<String, String> data = mainpage.getData(username);
	%>
	
	<table>
		<%for ( String sr : data.keySet()){ %>
			<tr> <td> <%=sr%>: </td>  <td > <%= data.get(sr) %> </td> </tr>
    	<%}%>
	</table>
	
	<form action=AddDrinkServlet method=post>
		<table> 
			<tr>
				<td> Add drink: </td>
				<td> <input type=text name=txtNoOfDrinks> </td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td> <a href="http://localhost:8080/demo.jsp/feed.jsp"> Go to feed </a> </td>
		</tr>
		<tr>
			<td> <a href="http://localhost:8080/demo.jsp/people.jsp"> Search bitch </a> </td>
		</tr>
	</table>
	
</body>
</html>