<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post</title>
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
					href="${pageContext.request.contextPath}/searchPage.jsp">Search</a>
				</li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/feed.jsp">Feed</a>
				</li>
			</ul>
		</div>
	</nav>
	<div
		style="position: fixed; top: 20%; left: 50%; transform: translate(-50%, -50%);">
		<form action=AddDrinkServlet method=post>
			<table>
				<tr>
					<td>What did you drink?</td>
					<td><input type=text name=txtNameOfDrink></td>
				</tr>

				<tr>
					<td>How many did you have?</td>
					<td><input type=text name=txtNumberOfDrinks></td>
				</tr>

				<tr>
					<td>Where did you drink?</td>
					<td><input type=text name=txtLocationOfPost></td>
				</tr>
				
			</table>
				<div>
					<input class = "button" type=submit value=Post> 
				</div>
		</form>
	</div>
</body>
</html>