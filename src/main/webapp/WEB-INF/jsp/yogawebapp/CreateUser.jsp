<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Add new Class page">
<meta name="author" content="Fabian Woodman">

<!-- all favicons for different platforms start -->
<link rel="apple-touch-icon" sizes="57x57"
	href="${pageContext.request.contextPath}/img/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="${pageContext.request.contextPath}/img/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${pageContext.request.contextPath}/img/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/img/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${pageContext.request.contextPath}/img/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${pageContext.request.contextPath}/img/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="${pageContext.request.contextPath}/img/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${pageContext.request.contextPath}/img/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${pageContext.request.contextPath}/img/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="${pageContext.request.contextPath}/img/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${pageContext.request.contextPath}/img/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="${pageContext.request.contextPath}/img/favicon-16x16.png">
<link rel="manifest"
	href="${pageContext.request.contextPath}/img/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="${pageContext.request.contextPath}/img/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- favicons end  -->
<title>Add New User | Yoga App</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/NavBar.css"
	rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home">Yoga Booking App
					<sec:authorize access="hasRole('Admin')"> | Admin </sec:authorize>
					<sec:authorize access="hasRole('Tutor')"> | Tutor </sec:authorize>
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/home">Dashboard</a></li>
					<li class="dropdown active"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Classes <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<sec:authorize access="hasAnyRole('Admin','Tutor')">
								<li><a
									href="${pageContext.request.contextPath}/classes/createClass">Add
										New Class</a></li>
								<li><a
									href="${pageContext.request.contextPath}/classes/createClassType">Add
										New Class Type</a></li>
							</sec:authorize>
							<li><a
								href="${pageContext.request.contextPath}/classes/manage">Manage
									Your Classes</a></li>
							<li><a
								href="${pageContext.request.contextPath}/classes/book">Book
									new Class</a></li>
						</ul></li>
					<li><a href="${pageContext.request.contextPath}/calendar">Calendar</a></li>
					<li><a href="${pageContext.request.contextPath}/tutors">Tutors</a></li>
					<sec:authorize access="hasRole('Admin')">
						<li><a class="active" href="${pageContext.request.contextPath}/createUser">Add
								new User</a></li>
					</sec:authorize>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../navbar/"> </a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><c:forEach items="${FirstName}"
								var="firstName"> Hello, ${firstName}</c:forEach> <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Account</a></li>
							<li><a href="<c:url value="/logout" />">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">

			<h1>Add a new User</h1>

			<c:if test="${not empty message}">
				<p>${message}</p>
			</c:if>
			
			<form role="form " class="form" action="addUser" method="post">
				<!-- First name input -->
				<label for="firstnameInput">First Name</label> <input
					name="user_fname" type="text" id="firstnameInput"
					class="form-control" placeholder="First Name" required autofocus>
				<!-- Last name input -->
				<label for="lastnameInput">Last Name</label> <input
					name="user_lname" type="text" id="lastnameInput"
					class="form-control" placeholder="Last Name" required>
				<!-- Phone number input -->
				<label for="phonenumInput">Phone Number</label> <input
					name="user_phonenum" type="number" id="phonenumInput"
					class="form-control" placeholder="Phone Number" required>
				<!-- Email Input -->
				<label for="inputEmail">Email address</label> <input
					name="user_email" type="email" id="inputEmail" class="form-control"
					placeholder="Email address" required>
				<!-- Password input -->
				<label for="inputPassword">Password</label> <input
					name="user_password" type="password" id="inputPassword"
					class="form-control" placeholder="Password" required>
					
				<!-- User Type input -->
				<div class="form-group">
					<label for="userTypeInput">User Type</label> <select
						class="form-control" id="userTypeInput" name="user_type" required>
						<option value="" disabled selected>Select a User Type</option>
						<option value="Customer" disabled >Customer</option>
						<option value="Tutor">Tutor</option>
						<option value="Admin" disabled>Admin</option>
					</select>
				</div>

				<button class="btn btn-success" type="submit">Submit</button>
			</form>
		</div>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>