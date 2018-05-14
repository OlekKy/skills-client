<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Create new User</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Create new User</h1>
			
			</div>	
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="userNew" class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="email">Email</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text" class="form:input-large"/>
						<form:errors path="email" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="CREATE"/>
					</div>
				</div>
				<p>
					<a href="<spring:url value="/" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Cancel
					</a>
				</p>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
