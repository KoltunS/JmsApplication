var app = angular.module('jmsApp', ['ui.bootstrap']);

app.controller('jmsCtrl', function($scope, $http, $location) {
   var url = $location.absUrl();
   $scope.getData = function(){
	   $http.get(url+"/get").success(function(d){
	    		$scope.user = d;
	   })
   }
});