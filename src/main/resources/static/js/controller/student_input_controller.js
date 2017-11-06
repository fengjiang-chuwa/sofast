'use strict';

App.controller('StudentInputController', ['StudentInputService', '$rootScope','$scope','$httpParamSerializer','DTOptionsBuilder', 'DTColumnBuilder',
    function (StudentInputService, $rootScope, $scope, $httpParamSerializer, DTOptionsBuilder, DTColumnBuilder) {
        var self = this;
        self.init = function(){
            StudentInputService.init(type, id).then(function (d) {
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

            for (var i=0; i<self.studentInputData.educationInfoList.length; i++) {
                if (formModel["educationForm"+i]) {
                    formModel["educationForm"+i]["schoolName"+i].$pristine = false;
                    formModel["educationForm"+i]["schoolType"+i].$pristine = false;
                    formModel["educationForm"+i]["levelOfStudy"+i].$pristine = false;
                    formModel["educationForm"+i]["startDate"+i].$pristine = false;
                    formModel["educationForm"+i]["endDate"+i].$pristine = false;
                    formModel["educationForm"+i]["line1"+i].$pristine = false;
                    formModel["educationForm"+i]["country"+i].$pristine = false;
                    formModel["educationForm"+i]["state"+i].$pristine = false;
                    formModel["educationForm"+i]["city"+i].$pristine = false;
                    formModel["educationForm"+i]["zip"+i].$pristine = false;
                    formModel["educationForm"+i]["eduPhoneId"+i].$pristine = false;
                }
            }

            for (var i=0; i<self.studentInputData.recommenderInfoList.length; i++) {
                if (formModel["recommenderInformationForm"+i]) {
                    formModel["recommenderInformationForm"+i]["nameOfRecommender"+i].$pristine = false;
                    formModel["recommenderInformationForm"+i]["jobTitle"+i].$pristine = false;
                    formModel["recommenderInformationForm"+i]["relationship"+i].$pristine = false;
                    formModel["recommenderInformationForm"+i]["recommenderPhoneId"+i].$pristine = false;
                    formModel["recommenderInformationForm"+i]["email"+i].$pristine = false;
                    formModel["recommenderInformationForm"+i]["cellPhoneId"+i].$pristine = false;
                }
            }

            for (var i=0; i<self.studentInputData.standardizedTestAccountInfoList.length; i++) {
                if (formModel["testAccountForm"+i]) {
                    formModel["testAccountForm"+i]["accountName"+i].$pristine = false;
                    formModel["testAccountForm"+i]["userName"+i].$pristine = false;
                    formModel["testAccountForm"+i]["password"+i].$pristine = false;
                }
            }

            for (var i=0; i<self.studentInputData.allQuestionnaireSurveyList.length; i++) {
                if (formModel["bragForm"+i]) {
                    formModel["bragForm"+i]["answer"+i].$pristine = false;
                }
            }

            if(formModel.$invalid) {
                return false;
            }
            for (var i=0; i<self.studentInputData.educationInfoList.length; i++) {
                if (formModel["educationForm"+i] && formModel["educationForm"+i].$invalid) {
                    return false;
                }
            }

            for (var i=0; i<self.studentInputData.recommenderInfoList.length; i++) {
                if (formModel["recommenderInformationForm"+i] && formModel["recommenderInformationForm"+i].$invalid) {
                    return false;
                }
            }

            for (var i=0; i<self.studentInputData.standardizedTestAccountInfoList.length; i++) {
                if (formModel["testAccountForm"+i] && formModel["testAccountForm"+i].$invalid) {
                    return false;
                }
            }

            for (var i=0; i<self.studentInputData.allQuestionnaireSurveyList.length; i++) {
                if (formModel["bragForm"+i] && formModel["bragForm"+i].$invalid) {
                    return false;
                }
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