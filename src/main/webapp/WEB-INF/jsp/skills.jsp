<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Skills</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>
					<a href="<spring:url value="/" />" class="btn btn-success btn-large">
					 <span class="glyphicon-home glyphicon"></span> Home
					</a>
					<a href="<spring:url value="/skills/addskill" />" class="btn btn-success btn-large">
					 <span class="glyphicon-plus glyphicon"></span> Add a new Skill to list
					</a>
					<a href="<spring:url value="/users/addskills" />" class="btn btn-success btn-large">
					 <span class="glyphicon-pencil glyphicon"></span> Save skills to User
					</a>	
					<a href="<spring:url value="/users/getdesc" />" class="btn btn-success btn-large">
					 <span class="glyphicon-search glyphicon"></span> Get description by details ID
					</a>
					<a href="<spring:url value="/users/getuserdetails" />" class="btn btn-success btn-large">
					 <span class="glyphicon-search glyphicon"></span> Get all user details
					</a>
					<a href="<spring:url value="/users/updatedetails" />" class="btn btn-warning btn-large">
					 <span class="glyphicon-pencil glyphicon"></span> Update your details
					</a>
					<a href="<spring:url value="/logout" />" class="btn btn-danger btn-large">
					 <span class="glyphicon-off glyphicon"></span> Logout
					</a>
				</p>
				<h1>Skills</h1>
				<p>List of skills</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">

			<c:forEach items="${skills}" var="skill">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${skill.id}</h3>
							<p>${skill.skillName}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
