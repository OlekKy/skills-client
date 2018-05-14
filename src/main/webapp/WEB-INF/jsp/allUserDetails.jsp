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
					<strong>Detail ID</strong>: ${detailsFullDTO.id}
				</p>
				<p>
					<strong>First name</strong>: ${detailsFullDTO.firstName}
				</p>
				<p>
					<strong>Last name</strong>: ${detailsFullDTO.lastName}
				</p>
				<p>
					<strong>University</strong>: ${detailsFullDTO.university}
				</p>
				<p>
					<strong>Field of study</strong>: ${detailsFullDTO.fieldOfStudy}
				</p>
				<p>
					<strong>Year of study</strong>: ${detailsFullDTO.yearOfStudy}
				</p>
				<div>
				<p>
					<strong>User Id</strong>: ${detailsFullDTO.user.id}
				</p>
				<p>
					<strong>User Name</strong>: ${detailsFullDTO.user.name}
				</p>
				<p>
					<strong>User password</strong>: ${detailsFullDTO.user.password}
				</p>
				<p>
					<strong>User email</strong>: ${detailsFullDTO.user.email}
				</p>
	
					<div>
					<h3>
						<strong>User's skills:</strong>
					</h3>
					<c:forEach items="${detailsFullDTO.user.skills}" var="skill">
					
						 <p>
						 	<strong>Skill ID</strong>: ${skill.id}
						 </p>
						 <p>
						 	<strong>Skill name</strong>: ${skill.skillName}
						 </p>
					</c:forEach>
					</div>
				</div>
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
