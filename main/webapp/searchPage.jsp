<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a style="font-family: 'Roboto', sans-serif;" class="navbar-brand" href="${pageContext.request.contextPath}/home">BEER PRESSURE</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
	      			<li class="nav-item">
	        			<a class="nav-link" href="${pageContext.request.contextPath}/home.jsp">Home</a>
	      			</li>
	      			
			        <li class="nav-item">
	        			<a class="nav-link" href="${pageContext.request.contextPath}/feed.jsp">Your Feed</a>
	      			</li>
	      			
	      			<li class="nav-item">
	        			<a class="nav-link" href="${pageContext.request.contextPath}/postingPage.jsp">Post</a>
	      			</li>
	      			
	      		</ul>
			  </div>
	</nav>

	<div style= 
			"position: fixed;
  			top: 10%;
  			left: 50%;
  			transform: translate(-50%, -50%);">
		<h2>Search for people you know</h2>
	</div>
	
	<div class="topnav" style= 
			"position: fixed;
  			top: 20%;
  			left: 50%;
  			transform: translate(-50%, -50%);">
		<form action=SearchServlet method=post>
			<div class="input-group">
  				<input name=txtSearch type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
  				<button type=submit class="btn btn-outline-primary">search</button>
			</div>

		</form>
	</div>
</body>
</html>