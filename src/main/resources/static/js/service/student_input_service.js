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
        save: function(studentInputData) {
            return $http.post(getFullRequestPath("/studentInfo"), studentInputData)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        // console.error('Error while save education');
                        return $q.reject(errResponse);
                    }
                );
        },
        sendEmail: function(studentId) {
            return $http.post(getFullRequestPath('/student/send/mail/')+studentId, null)
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
