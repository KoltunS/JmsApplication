var app = angular.module('jmsApp', [ 'ui.bootstrap' ]);

app.controller('jmsCtrl', function($scope, $http, $location) {
	var url = $location.absUrl();
	getAll();
	
	
	function getAll(){
		$http.get(url + "/all").success(function(d) {
			$scope.users = d;
		})
	}

	$scope.deleteUser = function(idx) {
		$http({
			url : url + '/delete/' + $scope.users[idx].idUser,
			method : 'DELETE',
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		}).then(function(res) {
			$scope.users.splice(idx, 1);
		});
		
	}

	$scope.createUser = function() {
		var formUser = $scope.formUser
		$http.post(url + "/", formUser).success(function(d) {
			$scope.users.push(d);
		})
		$scope.formUser = null;
	}

});