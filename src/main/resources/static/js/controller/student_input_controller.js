'use strict';

App.controller('StudentInputController', ['StudentInputService', '$rootScope','$scope','$httpParamSerializer','DTOptionsBuilder', 'DTColumnBuilder',
    function (StudentInputService, $rootScope, $scope, $httpParamSerializer, DTOptionsBuilder, DTColumnBuilder) {
        var self = this;

        $rootScope.showUpload0 = true;
        $rootScope.showUpload1 = true;
        $rootScope.showUpload2 = true;
        $rootScope.showUpload3 = true;
        $rootScope.showUpload4 = true;
        $rootScope.showUpload5 = true;
        $rootScope.showUpload6 = true;
        $rootScope.uploadFileError0 = false;
        $rootScope.uploadFileError1 = false;
        $rootScope.uploadFileError2 = false;
        $rootScope.uploadFileError3 = false;
        $rootScope.uploadFileError4 = false;
        $rootScope.uploadFileError5 = false;
        $rootScope.uploadFileError6 = false;

        self.init = function(){
            StudentInputService.init(type, id).then(function (d) {
                    $scope.studentInputData = d.data;
                    if ($scope.studentInputData.uploadFileList != null) {
                        for (var i = 0; i < $scope.studentInputData.uploadFileList.length; i++) {
                            if ($scope.studentInputData.uploadFileList[i].type === "p") {
                                $rootScope.showUpload0 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "at") {
                                $rootScope.showUpload1 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "elr") {
                                $rootScope.showUpload2 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "i20") {
                                $rootScope.showUpload3 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "ps") {
                                $rootScope.showUpload4 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "cv") {
                                $rootScope.showUpload5 = false;
                            }
                            if ($scope.studentInputData.uploadFileList[i].type === "c") {
                                $rootScope.showUpload6 = false;
                            }
                        }
                    }
                },
                function (errResponse) {
                    console.error('Error while init StudentInfo');
                }
            );
        };
        self.init();

        self.addEducation = function() {
            if (!$scope.studentInputData.educationInfoList) {
                $scope.studentInputData.educationInfoList = [];
            }
            $scope.studentInputData.educationInfoList.push({
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
            $scope.studentInputData.educationInfoList.splice(index, 1);
        };

        self.addRecommender = function() {
            if (!$scope.studentInputData.recommenderInfoList) {
                $scope.studentInputData.recommenderInfoList = [];
            }
            $scope.studentInputData.recommenderInfoList.push({
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
            $scope.studentInputData.recommenderInfoList.splice(index, 1);
        };

        self.addTestAccount = function() {
            if (!$scope.studentInputData.standardizedTestAccountInfoList) {
                $scope.studentInputData.standardizedTestAccountInfoList = [];
            }
            $scope.studentInputData.standardizedTestAccountInfoList.push({
                                                                            "id": null,
                                                                            "accountName": null,
                                                                            "userName": null,
                                                                            "password": null
                                                                        });
            // $scope.studentInputForm.$setDirty(true);
        };

        self.removeTestAccount = function(index) {
            $scope.studentInputData.standardizedTestAccountInfoList.splice(index, 1);
            // $scope.studentInputForm.testAccountForm.$setDirty(true);
        };

        self.saveStudentInfo = function () {
            var formModel = $scope.studentInputForm;
            formModel.firstName.$pristine = false;
            formModel.familyName.$pristine = false;
            formModel.passportNumber.$pristine = false;
            formModel.applicantEmailAddress.$pristine = false;
            formModel.dateOfBirth.$pristine = false;
            formModel.countryOfBirth.$pristine = false;
            formModel.nationality.$pristine = false;

            formModel.homeLine1.$pristine = false;
            formModel.mailingLine1.$pristine = false;
            formModel.homeCountry.$pristine = false;
            formModel.mailingCountry.$pristine = false;
            formModel.homeState.$pristine = false;
            formModel.mailingState.$pristine = false;
            formModel.homeCity.$pristine = false;
            formModel.mailingCity.$pristine = false;
            formModel.homeZip.$pristine = false;
            formModel.mailingZip.$pristine = false;
            formModel.phoneId.$pristine = false;
            formModel.declarationAgree.$pristine = false;

            formModel.fatherName.$pristine = false;
            formModel.motherName.$pristine = false;
            formModel.motherPhoneId.$pristine = false;
            formModel.fatherPhoneId.$pristine = false;
            formModel.motherEducation.$pristine = false;
            formModel.fatherEducation.$pristine = false;
            formModel.motherProfession.$pristine = false;
            formModel.fatherProfession.$pristine = false;
            formModel.startDate.$pristine = false;
            formModel.targetSchool.$pristine = false;
            formModel.firstChoice.$pristine = false;
            formModel.secondChoice.$pristine = false;
            formModel.safetyChoice.$pristine = false;
            formModel.undecided.$pristine = false;
            formModel.nameOfHighestQualification.$pristine = false;

            if ($scope.studentInputData.educationInfoList) {
                for (var i = 0; i < $scope.studentInputData.educationInfoList.length; i++) {
                    if (formModel["educationForm" + i]) {
                        formModel["educationForm" + i]["schoolName" + i].$pristine = false;
                        formModel["educationForm" + i]["schoolType" + i].$pristine = false;
                        formModel["educationForm" + i]["levelOfStudy" + i].$pristine = false;
                        formModel["educationForm" + i]["startDate" + i].$pristine = false;
                        formModel["educationForm" + i]["endDate" + i].$pristine = false;
                        formModel["educationForm" + i]["line1" + i].$pristine = false;
                        formModel["educationForm" + i]["country" + i].$pristine = false;
                        formModel["educationForm" + i]["state" + i].$pristine = false;
                        formModel["educationForm" + i]["city" + i].$pristine = false;
                        formModel["educationForm" + i]["zip" + i].$pristine = false;
                        formModel["educationForm" + i]["eduPhoneId" + i].$pristine = false;
                    }
                }
            }
            if ($scope.studentInputData.recommenderInfoList) {
                for (var i = 0; i < $scope.studentInputData.recommenderInfoList.length; i++) {
                    if (formModel["recommenderInformationForm" + i]) {
                        formModel["recommenderInformationForm" + i]["nameOfRecommender" + i].$pristine = false;
                        formModel["recommenderInformationForm" + i]["jobTitle" + i].$pristine = false;
                        formModel["recommenderInformationForm" + i]["relationship" + i].$pristine = false;
                        formModel["recommenderInformationForm" + i]["recommenderPhoneId" + i].$pristine = false;
                        formModel["recommenderInformationForm" + i]["email" + i].$pristine = false;
                        formModel["recommenderInformationForm" + i]["cellPhoneId" + i].$pristine = false;
                    }
                }
            }
            if ($scope.studentInputData.standardizedTestAccountInfoList) {
                for (var i = 0; i < $scope.studentInputData.standardizedTestAccountInfoList.length; i++) {
                    if (formModel["testAccountForm" + i]) {
                        formModel["testAccountForm" + i]["accountName" + i].$pristine = false;
                        formModel["testAccountForm" + i]["userName" + i].$pristine = false;
                        formModel["testAccountForm" + i]["password" + i].$pristine = false;
                    }
                }
            }
            if ($scope.studentInputData.allQuestionnaireSurveyList) {
                for (var i = 0; i < $scope.studentInputData.allQuestionnaireSurveyList.length; i++) {
                    if (formModel["bragForm" + i]) {
                        formModel["bragForm" + i]["answer" + i].$pristine = false;
                    }
                }
            }
            if(formModel.$invalid) {
                return false;
            }
            if ($scope.studentInputData.educationInfoList) {
                for (var i = 0; i < $scope.studentInputData.educationInfoList.length; i++) {
                    if (formModel["educationForm" + i] && formModel["educationForm" + i].$invalid) {
                        return false;
                    }
                }
            }
            if ($scope.studentInputData.recommenderInfoList) {
                for (var i = 0; i < $scope.studentInputData.recommenderInfoList.length; i++) {
                    if (formModel["recommenderInformationForm" + i] && formModel["recommenderInformationForm" + i].$invalid) {
                        return false;
                    }
                }
            }
            if ($scope.studentInputData.standardizedTestAccountInfoList) {
                for (var i = 0; i < $scope.studentInputData.standardizedTestAccountInfoList.length; i++) {
                    if (formModel["testAccountForm" + i] && formModel["testAccountForm" + i].$invalid) {
                        return false;
                    }
                }
            }
            if ($scope.studentInputData.allQuestionnaireSurveyList) {
                for (var i = 0; i < $scope.studentInputData.allQuestionnaireSurveyList.length; i++) {
                    if (formModel["bragForm" + i] && formModel["bragForm" + i].$invalid) {
                        return false;
                    }
                }
            }
            StudentInputService.save($scope.studentInputData)
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