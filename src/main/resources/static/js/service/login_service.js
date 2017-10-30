'use strict';

App.factory('LoginService', ['$http', '$q', function($http, $q){

	return {
			checkUser: function(loginInfo) {
				return $http.post(getFullRequestPath("/user/checkuser"), loginInfo)
					.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						// console.error('Error while checkin user');
						return $q.reject(errResponse);
					}
				);
			}
	};

}]);
