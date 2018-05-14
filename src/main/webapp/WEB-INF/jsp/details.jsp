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
				<h1>Details</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		<div class="col-md-5">
</div>
		
			<div class="col-md-5">
				<h3>
				<strong>Detail ID</strong>: ${detailsDTO.id}
				</h3>
				<p>
					<strong>First name</strong>: ${detailsDTO.firstName}
				</p>
				<p>
					<strong>Last name</strong>: ${detailsDTO.lastName}
				</p>
				<p>
					<strong>University</strong>: ${detailsDTO.university}
				</p>
				<p>
					<strong>Field of study</strong>: ${detailsDTO.fieldOfStudy}
				</p>
				<p>
					<strong>Year of study</strong>: ${detailsDTO.yearOfStudy}
				</p>
			
				<p>
					
					<a href="<spring:url value="/skills" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Back
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>
