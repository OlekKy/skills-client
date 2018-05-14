<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>User</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>User</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		<div class="col-md-5">
</div>
		
			<div class="col-md-5">
				<p>
					<strong>User ID </strong>: ${userFull.id}
				</p>
				<p>
					<strong>Name</strong>: ${userFull.name}
				</p>
				<p>
					<strong>Email </strong>: ${userFull.email}
				</p>
				<p>
					<strong>Password </strong>: ${userFull.password}
				</p>
				<div>
					<h3>
						<strong>User's skills:</strong>
					</h3>
					<c:forEach items="${userFull.skills}" var="skill">
					
						 <p>
						 	<strong>Skill ID</strong>: ${skill.id}
						 </p>
						 <p>
						 	<strong>Skill name</strong>: ${skill.skillName}
						 </p>
					</c:forEach>
				</div>
			
				<p>
					<a href="<spring:url value="/skills" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Show all skills
					</a>
				</p>

			</div>
		</div>
	</section>
</body>
</html>
