<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>${param.name}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a style="font-family: 'Roboto', sans-serif;" class="navbar-brand"
			href="${pageContext.request.contextPath}/home">BEER PRESSURE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/home.jsp">Home</a></li>
					
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/feed.jsp">Your Feed</a>
				</li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/searchPage.jsp">Search</a>
				</li>
				
				
			</ul>
		</div>
	</nav>
	
	<div style= 
			"position: fixed;
  			top: 10%;
  			left: 8%;
  			transform: translate(-50%, -50%);">
		<h3>Drinking stats</h3>
	</div>
	
	<%
	String username = request.getParameter("name");
	;
	%>
	<%@ page import="database.UsersDao, java.util.HashMap"%>
	<%
	UsersDao mainpage = new UsersDao();
	HashMap<String, String> data = mainpage.getUserData(username);
	%>
	
	<div style= 
			"position: fixed;
  			top: 25%;
  			left: 8%;
  			transform: translate(-50%, -50%);">
		<table class="table">
		  <tbody>
		    <tr>
		      <th scope="row">Drinks: </th>
		      <td><%=data.get("Drinks")%></td>
		    </tr>
		    <tr>
		      <th scope="row">Drink Years: </th>
		      <td><%=data.get("DrinkYears")%></td>
		    </tr>
		    <tr>
		      <th scope="row">Age: </th>
		      <td><%=data.get("Age")%></td>
		    </tr>
		    <tr>
		      <th scope="row">Weight Class</th>
		      <td><%=data.get("Weight Class")%></td>
		    </tr>
		  </tbody>
		</table>
	</div>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
</body>
</html>