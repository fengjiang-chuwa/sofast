
'use strict';

App.controller('StudentBasicController', ['$sce', '$scope', 'StudentBasicService', function ($sce, $scope, TermService) {
    var self = this;

    self.studentBasicEntity = {
        "firstName": null,
        "familyName": null,
        "email": null,
        "phoneNumber": null
    };

    self.saveStudent = function () {
        $scope.frmStudent.firstName.$pristine = false;
        $scope.frmStudent.familyName.$pristine = false;
        $scope.frmStudent.email.$pristine = false;
        $scope.frmStudent.phoneNumber.$pristine = false;
        if($scope.frmStudent.$invalid) {
            return false;
        }
        StudentBasicService.save(self.studentBasicEntity)
            .then(
                function (d) {
                    if(d.data==="success"){
                        window.location.href = getFullRequestPath("/welcome");
                    }else {
                        $scope.showErrorMsg = true;
                        $scope.errorMsg = $sce.trustAsHtml(d.data);
                    }
                },
                function (errResponse) {
                    // console.error('Error while checking User');
                }
            );
    };
    self.cancel = function() {
        window.location.href = getFullRequestPath("/welcome");
    };
}]);