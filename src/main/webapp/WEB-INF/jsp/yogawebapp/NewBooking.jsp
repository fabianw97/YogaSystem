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
<meta name="description" content="New Booking page">
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
<title>New Booking | Yoga App</title>

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
							<li class="active"><a
								href="${pageContext.request.contextPath}/classes/book">Book
									new Class</a></li>
						</ul></li>
					<li><a href="${pageContext.request.contextPath}/calendar">Calendar</a></li>
					<li><a href="${pageContext.request.contextPath}/tutors">Tutors</a></li>
					
					<sec:authorize access="hasRole('Admin')">
						<li><a href="${pageContext.request.contextPath}/createUser">Add
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

			<h1>Book a new class</h1>
			<p>Create a new booking for your selected class using the form
				below, you can use the drop down selection boxes to select the class
				you want to book, the location off the class and the date and time
				you want to book it.</p>

			<c:if test="${not empty success}">
				<p>${success}</p>
			</c:if>

			<form role="form" action="book" method="GET" id="locationSubmit">
				<!-- Location Select  -->
				<div class="form-group">
					<label for="locationInput">Location</label> <select
						class="form-control" id="locationInput" name="location_id"
						onchange="this.form.submit()">
						<option value="" disabled selected>Select a Location</option>
						<c:forEach items="${locations}" var="location">
							<option value="${location.id}">${location.name},
								${location.address}</option>
						</c:forEach>
					</select>
				</div>
			</form>

			<p>Once you have chosen a location the classes below will be
				updated based on what is available.</p>
				
			<form role="form" action="addClass" method="POST">
				<!-- Customer select for tutors and admin to book classes for others -->
				<sec:authorize access="hasAnyRole('Admin','Tutor')">
					<div class="form-group">
						<label for="userInput">User</label> <select class="form-control"
							id="userInput" name="user_id">
							<option value="" disabled selected>Select a User</option>
							<c:forEach items="${users}" var="user">
								<option value="${user.id}">${user.id} | ${user.forenames}
									${user.surname}</option>
							</c:forEach>
						</select>
					</div>
				</sec:authorize>
				<!-- Class Select based off Location -->



				<div class="form-group">
					<label for="classTypeInput">Class</label> <select
						class="form-control" id="classTypeInput" name="class_id" required>
						<option value="" disabled selected>Select a Class</option>
						<c:if test="${not empty allClasses}">
							<c:forEach var="c" items="${allClasses}">
								<option value="${c.id}">${c.class_type.className}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group">
					<label for="dateInput">Date</label> <input type="date"
						class="form-control" id="dateInput" placeholder="Date"
						name="dateStart" required>
				</div>
				<!--  simple script that gets first time and copies in to second -->
				<script>
					function sync() {
						var time1 = document.getElementById('timeStartInput');
						var time2 = document.getElementById('inputTimeEnd');
						time2.value = time2.value;
					}
				</script>
				<div class="form-group">
					<label for="exampleInputPassword1">Time Start</label> <input
						type="time" class="form-control" id="timeStartInput"
						placeholder="Time" name="timeStart" onkeyup="sync()" required>
				</div>
				<div class="form-group">
					<label for="inputTimeEnd">Time End</label> <input type="time"
						class="form-control" id="inputTimeEnd" placeholder="Time End"
						name="timeEnd" required>
				</div>
				<button type="submit" class="btn btn-success">Book Class</button>
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