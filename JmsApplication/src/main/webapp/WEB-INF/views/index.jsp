<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="jmsApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/ui-bootstrap-tpls-0.13.0.min.js'/>"></script>
<script src="<c:url value='/resources/js/app.js'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title> 
</head>
<body ng-controller="jmsCtrl">
	<div class="container-fluid"> 
		<p class="btn btn-default text-center" ng-click="getData()">Get</p>
		<div>
			{{user.firstname}} {{user.lastname}} {{user.email}}
		</div>
	</div> 
</body>
</html>