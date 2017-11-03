'use strict';

App.factory('AccountInfoService', ['$http', '$q', function($http, $q){

    return {
        current: function() {
            return $http.get(getFullRequestPath("/user/current"))
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    // console.error('Error while load personal');
                    return $q.reject(errResponse);
                }
            );
        }
    };

}]);
