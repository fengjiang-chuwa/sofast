'use strict';

App.controller('UploadFileController', ['$scope', '$rootScope', '$confirm', 'UploadFileService', function ($scope, $rootScope, $confirm, UploadFileService) {
    var self = this;
    $rootScope.uploadFileError = [];
    $rootScope.uploadFileError[0] = false;
    $rootScope.uploadFileError[1] = false;
    $rootScope.uploadFileError[2] = false;
    $rootScope.uploadFileError[3] = false;
    $rootScope.uploadFileError[4] = false;
    $rootScope.uploadFileError[5] = false;

    self.fileUpload = function (uploadStatus, description, tabName){
        var tabData = "na";
        if(UploadFileService.checkUploadFile(uploadStatus, tabData)) {
            UploadFileService.fileUpload(uploadStatus, description, tabName, tabData, $scope.ctl.fileId).then(
                function (d) {
                    if (200 === d.status) {
                        if (d.data.data !== undefined) {
                            if (tabName == 'additionalProgram') {
                                var refreshFile = {};
                                refreshFile.fileId = $scope.ctl.fileId;
                                refreshFile.fileIndex = $scope.ctl.fileIndex;
                                $scope.$emit('refreshFile',refreshFile);

                                UploadFileService.clearFileStatus(appId,$scope.ctl.fileId)
                                    .then(
                                    function (d) {
                                        if(d.data){
                                            $scope.btnPersonPendingClass[$scope.ctl.fileIndex] = "btn-default";
                                            $scope.btnPersonReceivedClass[$scope.ctl.fileIndex] = "btn-default";
                                            $scope.btnPersonDeniedClass[$scope.ctl.fileIndex] = "btn-default";

                                            var denyReasons = [];
                                            for(var i=0;i<$rootScope.denyReason.length;i++){
                                                if($rootScope.denyReason[i].fileId!=$scope.ctl.fileId){
                                                    denyReasons.push($rootScope.denyReason[i]);
                                                }
                                            }
                                            $rootScope.denyReason = denyReasons;
                                            $rootScope.fileReview--;
                                            if($rootScope.fileReview<0){
                                                $rootScope.fileReview = 0;
                                            }
                                        }
                                    },
                                    function (errResponse) {
                                        console.error('Error while clear file status');
                                    }
                                );
                            }
                        } else {
                            if (tabName == 'additionalProgram') {
                                $rootScope.uploadFileError[$scope.ctl.fileIndex] = true;
                            }
                        }
                    } else {
                        // error handler
                    }
                },
                function (errResponse) {
                    console.error('Error while fetching Currencies');
                }
            );
        }
    };

    $scope.uploadFormPersonal = function(fileId,status,index){
        $scope.ctl.fileId = fileId;
        $scope.ctl.fileIndex = index;
        self.fileUpload(status, $scope.uCtrl.description[index], 'additionalProgram');
    };
    $scope.fullScreen = function(filePath){
        window.open(filePath);
    };
    $scope.$on('showDescription' , function (e, param) {
        if(param){
            if(param.type=='clearPersonal'){
                $scope.uCtrl.description = [];
                $scope.uCtrl.description[0] = "";
                $scope.uCtrl.description[1] = "";
                $scope.uCtrl.description[2] = "";
                $scope.uCtrl.description[3] = "";
                $scope.uCtrl.description[4] = "";
                $scope.uCtrl.description[5] = "";
            }
            if(param.type=='personal'){
                if(param.personalDescription){
                    $scope.uCtrl.description = param.personalDescription;
                }
            }
        }
    });
}]);
