'use strict';

App.factory('StudentBasicService', ['$http', '$q', function($http, $q){

    return {
        init: function(termId) {
            return $http.get(getFullRequestPath("/term/data/"+termId))
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
        save: function(yearTerm) {
            return $http.post(getFullRequestPath("/term/save"), yearTerm)
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
