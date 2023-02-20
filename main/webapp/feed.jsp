<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your feed</title>
</head>
<body>
	These are the people you follow:
	<%@ page import="database.RegisterDao, java.util.ArrayList" %>
	<% RegisterDao rd = new RegisterDao(); %>
	<% ArrayList<String> followings = rd.getFollowing((String)request.getSession().getAttribute("user_name")); %>
	
	<table>
			<%for ( String f : followings){ %>
				<tr>
         		 	<td> <a href=http://localhost:8080/demo.jsp/otherProfilePage.jsp?name=<%=f%>> <%=f%> </a> </td> 
         		 </tr>
    		<%}%>
	</table>
	
</body>
</html>