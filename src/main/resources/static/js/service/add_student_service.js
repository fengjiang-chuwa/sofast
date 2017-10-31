'use strict';

App.factory('StudentBasicService', ['$http', '$q', function($http, $q){

    return {
        init: function(studentId) {
            return $http.get(getFullRequestPath("/studentbasic/data/"+studentId))
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        // console.error('Error while visit education');
                        return $q.reject(errResponse);
                    }
                );
        },
        save: function(studentBasicEntity) {
            return $http.post(getFullRequestPath("/studentbasic/save"), studentBasicEntity)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        // console.error('Error while save education');
                        return $q.reject(errResponse);
                    }
                );
        }
    };

}]);
