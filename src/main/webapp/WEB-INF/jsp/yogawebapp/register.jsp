<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Register page">
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
<title>Yoga App Register</title>

<!-- Bootstrap core CSS -->

<!-- c:url link -->

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">

		<form role="form " class="form-signin" action="add" method="post">

			<h2 class="form-signin-heading">Yoga Web App</h2>
			<h2 class="form-signin-heading">Register</h2>

			<c:if test="${not empty message}">
				<p>${message}</p>
			</c:if>

			<!-- First name input -->
			<label for="firstnameInput" class="sr-only">First Name</label> <input
				name="user_fname" type="text" id="firstnameInput"
				class="form-control" placeholder="First Name" required autofocus>
			<!-- Last name input -->
			<label for="lastnameInput" class="sr-only">Last Name</label> <input
				name="user_lname" type="text" id="lastnameInput"
				class="form-control" placeholder="Last Name" required>
			<!-- Phone number input -->
			<label for="phonenumInput" class="sr-only">Phone Number</label> <input
				name="user_phonenum" type="number" id="phonenumInput"
				class="form-control" placeholder="Phone Number" required>
			<!-- Email Input -->
			<label for="inputEmail" class="sr-only">Email address</label> <input
				name="user_email" type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required>
			<!-- Password input -->
			<label for="inputPassword" class="sr-only">Password</label> <input
				name="user_password" type="password" id="inputPassword"
				class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>