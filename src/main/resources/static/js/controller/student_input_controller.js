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

        self.addEducation = function() {
            self.studentInputData.educationInfoList.push({
                                                            "id": null,
                                                            "schoolName": null,
                                                            "type": null,
                                                            "levelOfStudy": null,
                                                            "addressId": null,
                                                            "phoneId": null,
                                                            "startDate": null,
                                                            "endDate": null,
                                                            "address": null,
                                                            "phone": null
                                                        });
        };

        self.removeEducation = function(index) {
            self.studentInputData.educationInfoList.splice(index, 1);
        };

        self.addRecommender = function() {
            self.studentInputData.recommenderInfoList.push({
                                                                "id": null,
                                                                "type": null,
                                                                "nameOfRecommender": null,
                                                                "jobTitle": null,
                                                                "relationship": null,
                                                                "phoneId": null,
                                                                "cellPhoneId": null,
                                                                "email": null
                                                            });
        };

        self.removeRecommender = function(index) {
            self.studentInputData.recommenderInfoList.splice(index, 1);
        };

        self.addTestAccount = function() {
            self.studentInputData.standardizedTestAccountInfoList.push({
                                                                            "id": null,
                                                                            "accountName": null,
                                                                            "userName": null,
                                                                            "password": null
                                                                        });
        };

        self.removeTestAccount = function(index) {
            self.studentInputData.standardizedTestAccountInfoList.splice(index, 1);
        };

        self.saveStudentInfo = function () {
            $scope.studentInputForm.firstName.$pristine = false;
            $scope.studentInputForm.familyName.$pristine = false;
            $scope.studentInputForm.passportNumber.$pristine = false;
            $scope.studentInputForm.applicantEmailAddress.$pristine = false;
            $scope.studentInputForm.dateOfBirth.$pristine = false;
            $scope.studentInputForm.countryOfBirth.$pristine = false;
            $scope.studentInputForm.nationality.$pristine = false;

            if($scope.studentInputForm.$invalid) {
                return false;
            }
            StudentInputService.save(self.studentInputData)
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
    }]
);