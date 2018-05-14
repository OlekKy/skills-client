<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
				<div>
					<div>
						<div>
							<p>
								<a href="<spring:url value="/skills" />" class="btn btn-primary">
									<span class="glyphicon-list-alt glyphicon"></span> List of skills
								</a>
								<a href="<spring:url value="/login" />" class="btn btn-success">
									<span class="glyphicon-log-in glyphicon"></span> Login
								</a>
								<a href="<spring:url value="/newaccount" />" class="btn btn-warning">
									<span class="glyphicon-globe glyphicon"></span> Create an account
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>
</body>
</html>
