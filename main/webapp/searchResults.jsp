<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<h1> Search Results </h1>
	<%@ page import="java.util.ArrayList" %>
	<% ArrayList<String> searchResults = (ArrayList<String>)request.getSession().getAttribute("searchResults"); %>
	
	<table>
			<%for ( String sr : searchResults){ %>
				<tr>
         		 	<td> <a href=http://localhost:8080/demo.jsp/otherProfilePage.jsp?name=<%=sr%>> <%=sr%> </a> </td> 
         		 	<td> <a href=http://localhost:8080/demo.jsp/followServlet?user_name=<%=sr%>> follow </a> </td>
         		 </tr>
    		<%}%>
	</table>
</body>
</html>