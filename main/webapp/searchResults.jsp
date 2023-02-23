<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap"
	rel="stylesheet">
</head>
<body>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/home.jsp">Home</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/feed.jsp">Your Feed</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/postingPage.jsp">Post</a></li>

		</ul>
	</div>
	<h2
		style="position: fixed; top: 10%; left: 50%; transform: translate(-50%, -50%);">
		Search Results</h2>
	<%@ page import="java.util.ArrayList"%>
	<%
	ArrayList<String> searchResults = (ArrayList<String>) request.getSession().getAttribute("searchResults");
	%>

	<div
		style="position: fixed; top: 20%; left: 50%; transform: translate(-50%, -50%);">

		<table class="table">
			<%
			for (String sr : searchResults) {
			%>
			<tr>
				<td><a href=http://localhost:8080/demo.jsp/otherProfilePage.jsp?name=<%=sr%> > <%=sr%> </a></td>
				<td><a href=http://localhost:8080/demo.jsp/follow?user_name=<%=sr%> > follow </a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>