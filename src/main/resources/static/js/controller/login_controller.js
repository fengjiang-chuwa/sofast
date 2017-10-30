'use strict';

App.controller('LoginController', ['$sce', '$scope', 'LoginService', function ($sce, $scope, LoginService) {
    var self = this;
    self.loginInfo = {
        "email": null,
        "password": null
    };
    self.resetHref = getFullRequestPath("/user/resetPasswordStep1");

    self.checkUser = function () {
        $scope.frmLogin.email.$pristine = false;
        $scope.frmLogin.password.$pristine = false;
        if($scope.frmLogin.$invalid) {
            return false;
        }
        LoginService.checkUser(self.loginInfo)
            .then(
            function (d) {
                if(d.data=="CHECK_FAIL"){
                    $scope.showErrorMsg = true;
                    $scope.errorMsg = $sce.trustAsHtml("Email or Password is wrong.");
                }else if(d.data=="CHECK_DONE"){
                    window.location.href = getFullRequestPath("") + "/welcome";
                }
            },
            function (errResponse) {
                // console.error('Error while checking User');
            }
        );
    };

}]);