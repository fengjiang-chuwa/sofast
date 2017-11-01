'use strict';

App.factory('StudentInputService', ['$http', '$q', function($http, $q){

    return {
        init: function() {
            return $http.get(getFullRequestPath("/studentInput/data/" + linkId))
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
        // save: function(studentBasicEntity) {
        //     return $http.post(getFullRequestPath("/studentbasic/save"), studentBasicEntity)
        //         .then(
        //             function(response){
        //                 return response.data;
        //             },
        //             function(errResponse){
        //                 // console.error('Error while save education');
        //                 return $q.reject(errResponse);
        //             }
        //         );
        // }
    };

}]);
