var app = angular.module('jmsApp', [ 'ui.bootstrap' ]);

app.controller('jmsCtrl', function($scope, $http, $location) {
	var url = $location.absUrl();
	
	$http.get(url + "/all").success(function(d) {
		$scope.users = d;
	})

	$scope.createUser = function() {	
		var formUser = $scope.formUser
		console.log(formUser);
		$http.post(url+"/",formUser).success(function(d) {
			$http.get(url + "/all").success(function(d) {
				$scope.users = d;
			})
		})
	}
});