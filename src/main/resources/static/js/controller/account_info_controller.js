'use strict';

App.controller('AccountInfoController', ['$scope', 'AccountInfoService', function ($scope, AccountInfoService) {
    var self = this;

    self.email = '';

    self.init = function(){
        AccountInfoService.current().then(function (d) {
                self.userName = d.data.userName;
            },
            function (errResponse) {
                console.error('Error while save accountInfo');
            }
        );
    };
    self.init();
}]);