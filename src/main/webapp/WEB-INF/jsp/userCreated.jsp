<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Details</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>User Details</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		<div class="col-md-5">
</div>
		
			<div class="col-md-5">
				<p>
					<strong>User ID</strong>: ${userFull.id}
				</p>
				<p>
					<strong>User name</strong>: ${userFull.name}
				</p>
				<p>
					<strong>Password</strong>: ${userFull.password}
				</p>
				<p>
					<strong>Email</strong>: ${userFull.email}
				</p>
				<p>
					<h3>
						<strong>Please save this information</strong>
					</h3>
				</p>
				<p>
					<h3>
						<strong>Now you can Log In and update your details</strong>
					</h3>
				</p>
				<p>
					
					<a href="<spring:url value="/skills" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Back
					</a>
					<a href="<spring:url value="/login" />" class="btn btn-default" >
						<span class="glyphicon-hand-right glyphicon"></span> Login
					</a>

				</p>
				

			</div>
		</div>
	</section>
</body>
</html>
