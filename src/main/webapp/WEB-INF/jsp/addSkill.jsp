<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Skills</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Skills</h1>
				<p>Add new Skill</p>
			</div>	
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newSkill" class="form-horizontal">
			<fieldset>
				<legend>Add new Skill</legend>

				<div class="form-group">
					<label class="control-label col-lg-2" for="skillName">Skill name</label>
					<div class="col-lg-10">
						<form:input id="skillName" path="skillName" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="ADD"/>
					</div>
				</div>
				<p>
					<a href="<spring:url value="/skills" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Back
					</a>
				</p>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
