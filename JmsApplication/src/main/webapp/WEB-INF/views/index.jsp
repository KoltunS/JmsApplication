<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="jmsApp">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="<c:url value='/resources/jQuery.2.1.4.min.js'/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/ui-bootstrap-tpls-0.13.0.min.js'/>"></script>
<script src="<c:url value='/resources/js/app.js'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
</head>
<body ng-controller="jmsCtrl">
	<nav class="navbar navbar-default">
	<div class=" navbar-brand">JMS Sample Application</div>
	</nav>
	<div class="container-fluid" style="margin-top: 5%;">
		<div class="row">
			<div class="col-md-4 ">
				<div class="col-md-8">
					<form id="createUserForm" class="form-horizontal" ng-submit="createUser()">
						<div class="form-group">
							<label for="firstname" class=" control-label col-sm-5">Imię:</label>
							<input id="firstname" class="col-sm-6" ng-model="formUser.firstname" required />
						</div>
						<div class="form-group">
							<label for="lastname" class=" control-label col-sm-5">Nazwisko:</label>
							<input id="lastname" class="col-sm-6" ng-model="formUser.lastname" required/>
						</div>
						<div class="form-group">
							<label for="email" class=" control-label col-sm-5">E-mail:</label>
							<input id="email" class="col-sm-6" ng-model="formUser.email" ng-maxlength="50"/>
						</div>
						<div class="row text-center">
							<button class="btn btn-success" type="submit" >Dodaj</button>
						</div>
					</form>
				</div>
			</div>

			<div class="col-md-8">
				<table class="table table-bordered table-stripped">
					<tr>
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>E-mail</th>
					</tr>
					<tr ng-repeat="user in users">
						<td>{{user.firstname}}</td>
						<td>{{user.lastname}}</td>
						<td>{{user.email}}</td>
					</tr>
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>