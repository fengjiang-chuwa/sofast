
'use strict';

App.controller('StudentBasicController', ['$sce', '$scope', 'StudentBasicService', function ($sce, $scope, TermService) {
    var self = this;

    self.yearTerm = {
        "year": null,
        "term": null,
        "startDate": null,
        "endDate": null,
        "applicationDeadline": null,
        "registrationStartDate": null,
        "registrationEndDate": null,
        "enrollStartDate": null,
        "enrollEndDate": null
    };
    self.init = function (termId) {
        TermService.init(termId).then(
            function (d) {
                if(200 === d.status){
                    if (d.data !== undefined) {
                        self.yearTerm = d.data;
                    }
                } else {
                    // error handler
                }
            },
            function (errResponse) {
                // console.error('Error while fetching Currencies');
            });
    };


    if(termId){
        self.init(termId);
    }

    self.saveTerm = function () {
        $scope.termForm.year.$pristine = false;
        $scope.termForm.term.$pristine = false;
        $scope.termForm.startDate.$pristine = false;
        $scope.termForm.endDate.$pristine = false;
        $scope.termForm.applicationDeadline.$pristine = false;
        if($scope.termForm.$invalid || self.yearTerm.startDate<=self.yearTerm.applicationDeadline
            || self.yearTerm.endDate<=self.yearTerm.startDate) {
            return false;
        }
        TermService.save(self.yearTerm)
            .then(
                function (d) {
                    if(d.data=="success"){
                        window.location.href = getFullRequestPath("") + "/termManagement";
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