'use strict';

App.controller('StudentInputController', ['StudentInputService', '$rootScope','$scope','$httpParamSerializer','DTOptionsBuilder', 'DTColumnBuilder',
    function (StudentInputService, $rootScope, $scope, $httpParamSerializer, DTOptionsBuilder, DTColumnBuilder) {
        var self = this;
        self.init = function(){
            StudentInputService.init().then(function (d) {
                    self.studentInputData = d.data;
                },
                function (errResponse) {
                    console.error('Error while init StudentInfo');
                }
            );
        };
        self.init();
    }]
);