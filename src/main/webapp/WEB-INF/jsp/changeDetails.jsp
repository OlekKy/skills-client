<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Details</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Update your details</h1>
			</div>	
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="detailsNewDTO" class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<legend>Update details</legend>

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
						<form:errors path="firstName" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
						<form:errors path="lastName" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="university">University</label>
					<div class="col-lg-10">
						<form:input id="university" path="university" type="text" class="form:input-large"/>
						<form:errors path="university" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="fieldOfStudy">Field of Study</label>
					<div class="col-lg-10">
						<form:input id="fieldOfStudy" path="fieldOfStudy" type="text" class="form:input-large"/>
						<form:errors path="fieldOfStudy" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="yearOfStudy">Year of Study</label>
					<div class="col-lg-10">
						<form:input id="yearOfStudy" path="yearOfStudy" type="text" class="form:input-large"/>
						<form:errors path="yearOfStudy" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="UPDATE"/>
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
