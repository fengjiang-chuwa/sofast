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
            // $scope.studentInputForm.$setDirty(true);
        };

        self.removeTestAccount = function(index) {
            self.studentInputData.standardizedTestAccountInfoList.splice(index, 1);
            // $scope.studentInputForm.testAccountForm.$setDirty(true);
        };

        self.saveStudentInfo = function () {
            $scope.studentInputForm.firstName.$pristine = false;
            $scope.studentInputForm.familyName.$pristine = false;
            $scope.studentInputForm.passportNumber.$pristine = false;
            $scope.studentInputForm.applicantEmailAddress.$pristine = false;
            $scope.studentInputForm.dateOfBirth.$pristine = false;
            $scope.studentInputForm.countryOfBirth.$pristine = false;
            $scope.studentInputForm.nationality.$pristine = false;

            $scope.studentInputForm.homeLine1.$pristine = false;
            $scope.studentInputForm.mailingLine1.$pristine = false;
            $scope.studentInputForm.homeCountry.$pristine = false;
            $scope.studentInputForm.mailingCountry.$pristine = false;
            $scope.studentInputForm.homeState.$pristine = false;
            $scope.studentInputForm.mailingState.$pristine = false;
            $scope.studentInputForm.homeCity.$pristine = false;
            $scope.studentInputForm.mailingCity.$pristine = false;
            $scope.studentInputForm.homeZip.$pristine = false;
            $scope.studentInputForm.mailingZip.$pristine = false;
            $scope.studentInputForm.phoneId.$pristine = false;

            $scope.studentInputForm.fatherName.$pristine = false;
            $scope.studentInputForm.motherName.$pristine = false;
            $scope.studentInputForm.motherPhoneId.$pristine = false;
            $scope.studentInputForm.fatherPhoneId.$pristine = false;
            $scope.studentInputForm.motherEducation.$pristine = false;
            $scope.studentInputForm.fatherEducation.$pristine = false;
            $scope.studentInputForm.motherProfession.$pristine = false;
            $scope.studentInputForm.fatherProfession.$pristine = false;
            $scope.studentInputForm.startDate.$pristine = false;
            $scope.studentInputForm.targetSchool.$pristine = false;
            $scope.studentInputForm.firstChoice.$pristine = false;
            $scope.studentInputForm.secondChoice.$pristine = false;
            $scope.studentInputForm.safetyChoice.$pristine = false;
            $scope.studentInputForm.undecided.$pristine = false;
            $scope.studentInputForm.nameOfHighestQualification.$pristine = false;

            if($scope.studentInputForm.educationForm) {
                $scope.studentInputForm.educationForm.schoolName.$pristine = false;
                $scope.studentInputForm.educationForm.schoolType.$pristine = false;
                $scope.studentInputForm.educationForm.levelOfStudy.$pristine = false;
                $scope.studentInputForm.educationForm.startDate.$pristine = false;
                $scope.studentInputForm.educationForm.endDate.$pristine = false;
                $scope.studentInputForm.educationForm.line1.$pristine = false;
                $scope.studentInputForm.educationForm.country.$pristine = false;
                $scope.studentInputForm.educationForm.state.$pristine = false;
                $scope.studentInputForm.educationForm.city.$pristine = false;
                $scope.studentInputForm.educationForm.zip.$pristine = false;
                $scope.studentInputForm.educationForm.eduPhoneId.$pristine = false;
            }

            if($scope.studentInputForm.recommenderInformationForm) {
                $scope.studentInputForm.recommenderInformationForm.nameOfRecommender.$pristine = false;
                $scope.studentInputForm.recommenderInformationForm.jobTitle.$pristine = false;
                $scope.studentInputForm.recommenderInformationForm.relationship.$pristine = false;
                $scope.studentInputForm.recommenderInformationForm.recommenderPhoneId.$pristine = false;
                $scope.studentInputForm.recommenderInformationForm.email.$pristine = false;
                $scope.studentInputForm.recommenderInformationForm.cellPhoneId.$pristine = false;
            }

            if($scope.studentInputForm.testAccountForm){
                // $scope.studentInputForm.testAccountForm.accountName.$pristine = false;
                $scope.studentInputForm.testAccountForm.userName.$pristine = false;
                $scope.studentInputForm.testAccountForm.password.$pristine = false;
            }
            $scope.studentInputForm.testAccountForm1.$pristine = false;

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